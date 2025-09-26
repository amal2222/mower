package com.libon.mower.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldDto {
    @JsonProperty("max_x")
    private int maxX;

    @JsonProperty("max_y")
    private int maxY;
    
    public FieldDto(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    
}
