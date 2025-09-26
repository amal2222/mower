package com.libon.mower.domain;

import java.util.List;

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
    

    public String getId() {
        return id;
    }


    public Position getPosition() {
        return position;
    }


    public Orientation getOrientation() {
        return orientation;
    }


    public Field getField() {
        return field;
    } 

    public void executeInstructions(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            executeInstruction(instruction);
        }
    }
    
    private void executeInstruction(Instruction instruction) {
        switch (instruction) {
            case G:
                orientation = orientation.turnLeft();
                break;
            case D:
                orientation = orientation.turnRight();
                break;
            case A:
                moveForward();
                break;
        }
    }

    private void moveForward() {
        Position newPosition = new Position(
            position.getX() + orientation.getXMovement(),
            position.getY() + orientation.getYMovement()
        );
            position = newPosition;
    }

}
