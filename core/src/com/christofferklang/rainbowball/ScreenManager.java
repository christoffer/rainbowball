package com.christofferklang.rainbowball;

import com.badlogic.gdx.Gdx;

/**
 * Keeps track of which screen is current, and where to transition after a screen is completed.
 */
public class ScreenManager {
    private final RainbowBallApplication app;

    private AppScreen currentScreen = null;

    public static enum GameScreen {
        PLAY
    }

    public ScreenManager(RainbowBallApplication app) {
        this.app = app;
    }

    public void gotoScreen(GameScreen screen) {
        if (currentScreen != null) {
            currentScreen.onDestroy();
        }

        AppScreen newState;

        switch (screen) {
            case PLAY:
                newState = new PlayScreen(app);
                break;
            default:
                throw new IllegalArgumentException("Not a known state value: " + screen);
        }

        currentScreen = newState;
        currentScreen.onCreate(Gdx.graphics);

        Gdx.input.setInputProcessor(currentScreen);
    }

    public void render() {
        if (currentScreen != null) {
            currentScreen.onRender();
        }
    }

    public void update(float deltaTime) {
        if (currentScreen != null) {
            currentScreen.onUpdate(deltaTime);
        }
    }
}
