package com.christofferklang.rainbowball.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.christofferklang.rainbowball.ShapeRenderable;

public class Pin extends Entity implements ShapeRenderable {
    private static final float RADIUS = 20;

    public Pin(World world) {
        super(world);
    }

    @Override
    protected void setupBodyDef(BodyDef bodyDef) {
        bodyDef.type = BodyDef.BodyType.StaticBody;
    }

    @Override
    protected void setupFixtures(Body body) {
        CircleShape shape = new CircleShape();
        shape.setRadius(RADIUS);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body.createFixture(fixtureDef);
        shape.dispose();
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        Vector2 pos = getBody().getPosition();
        shapeRenderer.setColor(1, 1, 1, 1);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(pos.x, pos.y, RADIUS);
        shapeRenderer.end();
    }

    @Override
    public String toString() {
        return String.format("Pin <%s, %s>", getBody(), RADIUS);
    }
}
