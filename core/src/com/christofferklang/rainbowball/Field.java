package com.christofferklang.rainbowball;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.christofferklang.rainbowball.entities.Pin;

import java.util.ArrayList;
import java.util.List;

// A Field is responsible for keeping track of active and non-active Pegs.
public class Field implements ShapeRenderable {
    private final World world;
    private List<Pin> activePins = new ArrayList<Pin>();

    public Field(World world) {
        this.world = world;
    }

    public void reset(GameLevelDefinition level, int width, int height) {
        activePins.clear();
        for (int i = 0; i < level.getNumPins(); i++) {
            Pin pin = new Pin(world);
            pin.getBody().setTransform(width * (float) Math.random(), height * (float) Math.random(), 0);
            activePins.add(pin);
        }
    }

    @Override
    public void render(ShapeRenderer renderer) {
        for (Pin pin : activePins) {
            pin.render(renderer);
            // System.out.println("Render pin:" + pin);
        }
    }
}
