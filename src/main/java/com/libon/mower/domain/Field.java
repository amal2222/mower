package com.libon.mower.domain;
/**
 * Represents a rectangular lawn field with boundary validation capabilities.
 * 
 * The field uses a coordinate system where:
 * - Bottom-left corner is at (0, 0)
 * - Top-right corner is at (maxX, maxY)
 * - All positions within these bounds are valid
 * 
 * This class enforces business rules about field boundaries and prevents
 * mowers from moving outside the designated area.
 */

public class Field {
    
    private final int maxX;
    private final int maxY;

    public Field(int maxX, int maxY) {
        if (maxX < 0 || maxY < 0) {
            throw new IllegalArgumentException("Field dimensions must be positive");
        }
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Validates whether a position is within the field boundaries.
     * 
     * A position is valid if:
     * - X-coordinate is between 0 and maxX
     * - Y-coordinate is between 0 and maxY
     * 
     * @param position the position to validate
     * @return true if the position is within bounds, false otherwise
     */
    public boolean isValidPosition(Position position) {
        return position.getX() >= 0 && position.getX() <= maxX &&
               position.getY() >= 0 && position.getY() <= maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

}
