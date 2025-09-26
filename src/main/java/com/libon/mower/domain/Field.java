package com.libon.mower.domain;

public class Field {
    
    private final int maxX;
    private final int maxY;

    public Field(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

}
