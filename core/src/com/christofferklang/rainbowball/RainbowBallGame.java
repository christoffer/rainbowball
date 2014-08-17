package com.christofferklang.rainbowball;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class RainbowBallGame extends ApplicationAdapter {
    // Physics world
    private World world;
    private GameStateManager gameStateManager;
    private Camera camera;
    private ShapeRenderer shapeRenderer;

    private int WIDTH;
    private int HEIGHT;

    @Override
	public void create () {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(WIDTH, HEIGHT);
        // Move the coordinate system to 0, 0 -> width, height instead of
        // -width / 2, -height / 2 -> width / 2, height / 2
        camera.translate(WIDTH * 0.5f, HEIGHT * 0.5f, 0f);

        shapeRenderer = new ShapeRenderer();
        world = new World(new Vector2(0, 0), true);
        gameStateManager = new GameStateManager(shapeRenderer);

        gameStateManager.setState(GameStateManager.STATE_PLAY);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);

        gameStateManager.updateGameState(Gdx.graphics.getDeltaTime());
        gameStateManager.renderGameState();
	}
}
