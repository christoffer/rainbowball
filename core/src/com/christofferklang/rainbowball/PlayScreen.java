package com.christofferklang.rainbowball;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Screen where the game is played.
 */
public class PlayScreen extends AppScreen {
    private static final float TOUCH_DISTANCE_FOR_AIM = 50;

    private final GameState gameState;
    private final Field field;
    private final OrthographicCamera camera;

    private final Box2DDebugRenderer debugRenderer;
    private final ShapeRenderer shapeRenderer;

    private final World world;
    private final PlayerBall playerBall;

    private boolean isAiming = false; // true if the user is currently aiming a shot
    private final Vector2 aimReleaseWordCoords = new Vector2(); // The point where the user released the shot

    private Vector3 inputWorldCoord = new Vector3(0, 0, 0); // temporary vector reused for mapping screen coordinates to world coordinates

    public PlayScreen(RainbowBallApplication app) {
        final int width = app.getWidth();
        final int height = app.getHeight();

        world = new World(new Vector2(0, 0), true);

        // Initialize graphics
        camera = new OrthographicCamera(app.getWidth(), app.getHeight());
        // Move the coordinate system to 0, 0 -> width, height instead of
        // -width / 2, -height / 2 -> width / 2, height / 2
        camera.translate(width * 0.5f, height * 0.5f, 0f);
        shapeRenderer = new ShapeRenderer();

        // Initialize game
        gameState = new GameState();
        field = new Field(world);
        field.reset(gameState.getCurrentLevel(), width, height);
        playerBall = new PlayerBall(world);

        playerBall.getBody().setTransform(width * .5f, height * .5f, 0);

        debugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void onCreate(Graphics graphics) {
    }

    @Override
    public void onUpdate(float deltaMillis) {

    }

    @Override
    public void onRender() {
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);

        // Render Pins
        field.render(shapeRenderer);

        // Render player ball
        playerBall.render(shapeRenderer);

        // Render Physics
        debugRenderer.render(world, camera.combined);

        if (isAiming) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.circle(aimReleaseWordCoords.x, aimReleaseWordCoords.y, 10);
            shapeRenderer.line(playerBall.getBody().getPosition(), aimReleaseWordCoords);
            shapeRenderer.end();
        }
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (!isAiming) {
            updateInputWorldCoord(screenX, screenY);
            if (shouldStartAiming(playerBall.getBody().getPosition(), inputWorldCoord)) {
                // Reset the release position
                aimReleaseWordCoords.x = inputWorldCoord.x;
                aimReleaseWordCoords.y = inputWorldCoord.y;
                isAiming = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (isAiming) {
            updateInputWorldCoord(screenX, screenY);
            aimReleaseWordCoords.x = inputWorldCoord.x;
            aimReleaseWordCoords.y = inputWorldCoord.y;
            makeShot(playerBall.getBody().getPosition(), aimReleaseWordCoords);
            isAiming = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (isAiming) {
            updateInputWorldCoord(screenX, screenY);
            aimReleaseWordCoords.x = inputWorldCoord.x;
            aimReleaseWordCoords.y = inputWorldCoord.y;
            return true;
        }
        return true;
    }

    // Updates the world coordinates by unprojecting the x and y in screen space
    // Does not create any new objects
    private void updateInputWorldCoord(int screenX, int screenY) {
        inputWorldCoord.x = screenX;
        inputWorldCoord.y = screenY;
        inputWorldCoord = camera.unproject(inputWorldCoord);
    }

    private boolean shouldStartAiming(Vector2 playerPos, Vector3 touchWorldCoord) {
        final float distance = touchWorldCoord.dst(playerPos.x, playerPos.y, 0);
        return distance < TOUCH_DISTANCE_FOR_AIM;
    }

    // Perform the shot from origin to release
    private void makeShot(Vector2 origin, Vector2 release) {

    }
}
