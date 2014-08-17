package com.christofferklang.rainbowball;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.christofferklang.rainbowball.entities.Pin;

import java.util.ArrayList;
import java.util.List;

public class GameField implements ShapeRenderable {
    private final int width;
    private final int height;
    private List<Pin> activePins = new ArrayList<Pin>();

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void reset(int numPins, int numColors) {
        activePins.clear();
        for(int i = 0; i < numPins; i++) {
            Pin pin = new Pin();
            pin.position.set(width * (float) Math.random(), height * (float) Math.random());
            activePins.add(pin);
        }
    }

    @Override
    public void render(ShapeRenderer renderer) {
        for(Pin pin : activePins) {
            pin.render(renderer);
            // System.out.println("Render pin:" + pin);
        }
    }
}
