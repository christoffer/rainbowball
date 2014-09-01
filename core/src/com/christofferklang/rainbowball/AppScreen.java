package com.christofferklang.rainbowball;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.InputProcessor;

public abstract class AppScreen implements InputProcessor {

    /**
     * Called when the state is created and ready to go.
     */
    public abstract void onCreate(Graphics graphics);

    /**
     * Called when the state can update.
     */
    public abstract void onUpdate(float deltaMillis);

    /**
     * Called when the game state should render its' shapes.
     */
    public abstract void onRender();

    /**
     * Called when the game state is destroyed and should free up its resources.
     */
    public abstract void onDestroy();

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
