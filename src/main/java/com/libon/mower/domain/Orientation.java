package com.libon.mower.domain;

public enum Orientation {
    N(0, 1),   // North: x doesn't change, y increases by 1
    E(1, 0),   // East:  x increases by 1, y doesn't change  
    S(0, -1),  // South: x doesn't change, y decreases by 1
    W(-1, 0);  // West:  x decreases by 1, y doesn't change

    /** Change in X coordinate when moving forward in this direction */    
    private final int xMovement;
    /** Change in Y coordinate when moving forward in this direction */
    private final int yMovement;
    
    private Orientation(int xMovement, int yMovement) {
        this.xMovement = xMovement;
        this.yMovement = yMovement;
    }

    public int getXMovement() { return xMovement; }
    public int getYMovement() { return yMovement; }

    /**
     * Turns left by 90 degrees.
     * 
     * Uses modular arithmetic to handle the circular nature of directions.
     * Adding 3 is equivalent to subtracting 1 in modulo 4 arithmetic,
     * avoiding negative number handling.
     * 
     * @return the new orientation after turning left
     */
    public Orientation turnLeft() {
        return values()[(ordinal() + 3) % 4];
    }
    
    /**
     * Turns right by 90 degrees.
     * 
     * Uses modular arithmetic to handle wrap-around from W back to N.
     * 
     * @return the new orientation after turning right
     */
    public Orientation turnRight() {
        return values()[(ordinal() + 1) % 4];
    }

}
