package com.christofferklang.rainbowball.gamestates;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.christofferklang.rainbowball.GameField;
import com.christofferklang.rainbowball.GameLevelDefinition;
import com.christofferklang.rainbowball.GameStateManager;

import java.util.Arrays;
import java.util.List;

public class PlayState extends GameState {
    private static final List<GameLevelDefinition> GAME_LEVELS = Arrays.asList(
            new GameLevelDefinition(1, 5, 2)
    );

    GameField field;
    private GameLevelDefinition currentLevel;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        currentLevel = getNextLevel();
    }

    @Override
    public void onCreate(Graphics graphics) {
        field = new GameField(graphics.getWidth(), graphics.getHeight());
        field.reset(currentLevel.getNumPins(), currentLevel.getNumColors());
    }

    @Override
    public void onUpdate(float deltaMillis) {

    }

    @Override
    public void onRenderShapes(ShapeRenderer renderer) {
        field.render(renderer);
    }

    @Override
    public void onInput() {

    }

    @Override
    public void onDestroy() {

    }

    private GameLevelDefinition getNextLevel() {
        if (currentLevel == null) {
            return GAME_LEVELS.get(0);
        } else if (currentLevel == GAME_LEVELS.get(GAME_LEVELS.size() - 1)) {
            // stay on the last level until the player dies
            return currentLevel;
        }

        return GAME_LEVELS.get(GAME_LEVELS.indexOf(currentLevel) + 1);
    }
}
