package com.libon.mower.domain;

public enum Orientation {
    N(0, 1),   // North: x doesn't change, y increases by 1
    E(1, 0),   // East:  x increases by 1, y doesn't change  
    S(0, -1),  // South: x doesn't change, y decreases by 1
    W(-1, 0);  // West:  x decreases by 1, y doesn't change

    private final int xMovement;
    private final int yMovement;
    
    private Orientation(int xMovement, int yMovement) {
        this.xMovement = xMovement;
        this.yMovement = yMovement;
    }

    public int getXMovement() { return xMovement; }
    public int getYMovement() { return yMovement; }

    public Orientation turnLeft() {
        // %4 handles the wrap around
        // To avoid negatives we use position +3 instead of position -1 which leads to the same position in a 4 element circle context
        return values()[(ordinal() + 3) % 4];
    }
    
    public Orientation turnRight() {
        return values()[(ordinal() + 1) % 4];
    }

}
