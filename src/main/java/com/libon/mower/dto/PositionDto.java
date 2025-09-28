package com.libon.mower.dto;

import jakarta.validation.constraints.Min;

public class PositionDto {
    
    @Min(0)
    private int x;
    
    @Min(0)
    private int y;
    
    public PositionDto(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    
}
