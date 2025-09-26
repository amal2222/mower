package com.libon.mower.dto;

import com.libon.mower.domain.Orientation;

public class MowerResult {
    
    private String id;
    private PositionDto position;
    private Orientation orientation;
    
    public MowerResult(String id, PositionDto position, Orientation orientation) {
        this.id = id;
        this.position = position;
        this.orientation = orientation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PositionDto getPosition() {
        return position;
    }

    public void setPosition(PositionDto position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    

}
