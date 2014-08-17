package com.christofferklang.rainbowball;

public class GameLevelDefinition {
    private final int pointsPerHit;
    private final int numPins;
    private final int numColors;

    public GameLevelDefinition(int pointsPerHit, int numPins, int numColors) {
        this.pointsPerHit = pointsPerHit;
        this.numPins = numPins;
        this.numColors = numColors;
    }

    public int getPointsPerHit() {
        return pointsPerHit;
    }

    public int getNumPins() {
        return numPins;
    }

    public int getNumColors() {
        return numColors;
    }
}
