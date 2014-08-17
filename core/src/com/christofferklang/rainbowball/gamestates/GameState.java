package com.christofferklang.rainbowball.gamestates;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.christofferklang.rainbowball.GameStateManager;

/**
 * Represents a state of the game.
 */
public abstract class GameState {
    private final GameStateManager gameStateMananger;

    public GameState(GameStateManager gameStateManager) {
        this.gameStateMananger = gameStateManager;
    }

    /** Called when the state is created and ready to go. */
    public abstract void onCreate(Graphics graphics);

    /** Called when the state can update. */
    public abstract void onUpdate(float deltaMillis);

    /** Called when the game state should render its' shapes. */
    public abstract void onRenderShapes(ShapeRenderer renderer);

    /** Called when the game state should respond to user input. */
    public abstract void onInput();

    /** Called when the game state is destroyed and should free up its resources. */
    public abstract void onDestroy();
}
