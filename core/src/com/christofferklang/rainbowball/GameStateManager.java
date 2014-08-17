package com.christofferklang.rainbowball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.christofferklang.rainbowball.gamestates.GameState;
import com.christofferklang.rainbowball.gamestates.PlayState;

/**
 * Manager for handling the GameState lifecycle as
 * the game transition from one state to another.
 */
public class GameStateManager {
    private final ShapeRenderer shapeRenderer;
    private GameState currentState = null;

    /** Game is playing. */
    public static final int STATE_PLAY = 1;

    public GameStateManager(ShapeRenderer shapeRenderer) {
        currentState = null;
        this.shapeRenderer = shapeRenderer;
    }

    public void setState(int state) {
        if(currentState != null) {
            currentState.onDestroy();
        }

        GameState newState;

        switch(state) {
            case STATE_PLAY:
                newState = new PlayState(this);
                break;
            default:
                throw new IllegalArgumentException("Not a known state value: " + state);
        }

        currentState = newState;
        currentState.onCreate(Gdx.graphics);
    }

    public void renderGameState() {
        if(currentState != null) {
            currentState.onRenderShapes(shapeRenderer);
        }
    }

    public void updateGameState(float deltaTime) {
        if(currentState != null) {
            currentState.onUpdate(deltaTime);
        }
    }
}
