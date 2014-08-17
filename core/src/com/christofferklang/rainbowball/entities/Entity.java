package com.christofferklang.rainbowball.entities;

import com.badlogic.gdx.math.Vector2;
import com.christofferklang.rainbowball.ShapeRenderable;

public abstract class Entity implements ShapeRenderable {
    public final Vector2 position = new Vector2();
}
