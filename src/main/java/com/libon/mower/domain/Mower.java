package com.libon.mower.domain;

public class Mower {
    private final String id;
    private Position position;
    private Orientation orientation;
    private final Field field;

    public Mower(String id, Position position, Orientation orientation, Field field) {
        this.id = id;
        this.position = position;
        this.orientation = orientation;
        this.field = field;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }    

}
