package com.libon.mower.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;

public class FieldDto {

    @Min(0)
    @JsonProperty("max_x")
    private int maxX;

    @Min(0)
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
