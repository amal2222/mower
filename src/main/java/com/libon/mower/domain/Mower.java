package com.libon.mower.domain;

import java.util.List;
/**
 * Represents an autonomous lawn mower that can navigate a rectangular field.
 * 
 * A mower has:
 * - A unique identifier
 * - A current position on the field
 * - An orientation
 * - The ability to execute movement instructions
 * 
 * Business rules:
 * - Mowers cannot move outside field boundaries
 * - Instructions are executed sequentially
 * - Invalid moves are ignored (mower stays in place)
 * - Turning always succeeds regardless of position
 */
public class Mower {
    private final String id;
    private Position position;
    private Orientation orientation;
    private final Field field;

    public Mower(String id, Position startPosition, Orientation orientation, Field field) {
        if (!field.isValidPosition(startPosition)) {
            throw new IllegalArgumentException("Starting position is outside field boundaries");
        }
        this.id = id;
        this.position = startPosition;
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
    /**
     * Executes a sequence of instructions in order.
     * 
     * Each instruction is processed sequentially. If any instruction
     * cannot be executed (movement would go outside boundaries),
     * it's ignored and processing continues with the next instruction.
     * 
     * @param instructions list of instructions to execute
     */
    public void executeInstructions(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            executeInstruction(instruction);
        }
    }
    
    /**
     * Executes a single instruction.
     * 
     * @param instruction the instruction to execute (G, D, or A)
     */
    private void executeInstruction(Instruction instruction) {
        switch (instruction) {
            case G:
                // Turn left: always succeeds
                orientation = orientation.turnLeft();
                break;
            case D:
                // Turn right: always succeeds
                orientation = orientation.turnRight();
                break;
            case A:
                // Move forward: only if destination is valid
                moveForward();
                break;
        }
    }

    /**
     * Moves the mower forward in its current orientation.
     * 
     * The movement only occurs if the destination position is within
     * the field boundaries. If the move would take the mower outside
     * the field, the mower stays in its current position.
     */
    private void moveForward() {
        // Calculate the potential new position
        Position newPosition = new Position(
            position.getX() + orientation.getXMovement(),
            position.getY() + orientation.getYMovement()
        );
        // Only move if the new position is valid
        if (field.isValidPosition(newPosition)) {
            position = newPosition;
        }
    }

}
