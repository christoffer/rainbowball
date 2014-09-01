package com.christofferklang.rainbowball;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.christofferklang.rainbowball.entities.Entity;

/**
 * The ball that the player shoots.
 */
public class PlayerBall extends Entity implements ShapeRenderable {
    private static final float RADIUS = 25.0f;

    public PlayerBall(World world) {
        super(world);
    }

    @Override
    public void render(ShapeRenderer renderer) {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        Vector2 pos = getBody().getPosition();
        renderer.circle(pos.x, pos.y, 5);
        renderer.end();
    }

    @Override
    protected void setupBodyDef(BodyDef bodyDef) {
        bodyDef.type = BodyDef.BodyType.DynamicBody;
    }

    @Override
    protected void setupFixtures(Body body) {
        CircleShape shape = new CircleShape();
        shape.setRadius(RADIUS);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.5f;
        fixtureDef.shape = shape;

        body.createFixture(fixtureDef);
    }
}
