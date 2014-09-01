package com.christofferklang.rainbowball.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Entity {
    private final Body body;

    public Entity(World world) {
        BodyDef bodyDef = new BodyDef();
        setupBodyDef(bodyDef);
        Body body = world.createBody(bodyDef);
        setupFixtures(body);
        this.body = body;
    }

    /**
     * Initialize properties of the physics body of this Entity.
     */
    protected void setupBodyDef(BodyDef bodyDef) {
        // NOOP
    }

    /**
     * Creates and adds fixtures for the body.
     */
    protected void setupFixtures(Body body) {
        // NOOP
    }

    public Body getBody() {
        return body;
    }
}
