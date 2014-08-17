package com.christofferklang.rainbowball.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Pin extends Entity {
    private static final float RADIUS = 20;

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(position.x, position.y, RADIUS);
        shapeRenderer.end();
    }

    @Override
    public String toString() {
        return String.format("Pin <%s, %s>", position, RADIUS);
    }
}
