package com.christofferklang.rainbowball;

import java.util.Arrays;
import java.util.List;

/**
 * The current state
 */
public class GameState {
    private int score; // current player score
    private GameLevelDefinition currentLevel; // current level specs

    public GameState() {
        score = 0;
        currentLevel = getNextLevel();
    }

    private static final List<GameLevelDefinition> LEVELS = Arrays.asList(
            new GameLevelDefinition(1, 5, 2)
    );

    private GameLevelDefinition getNextLevel() {
        if (currentLevel == null) {
            return LEVELS.get(0);
        } else if (currentLevel == LEVELS.get(LEVELS.size() - 1)) {
            // stay on the last level until the player dies
            return currentLevel;
        }

        return LEVELS.get(LEVELS.indexOf(currentLevel) + 1);
    }

    public GameLevelDefinition getCurrentLevel() {
        return currentLevel;
    }
}
