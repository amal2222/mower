package com.libon.mower.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MowerTest {

    
    private Field field;
    
    @BeforeEach
    void setUp() {
        field = new Field(5, 5);
    }
    
    @Test
    void testMowerCreation() {
        Position start = new Position(1, 2);
        Mower mower = new Mower("test", start, Orientation.N, field);
        
        assertEquals("test", mower.getId());
        assertEquals(start, mower.getPosition());
        assertEquals(Orientation.N, mower.getOrientation());
    }
    
    @Test
    void testInvalidStartPosition() {
        Position invalidStart = new Position(-1, 2);
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Mower("test", invalidStart, Orientation.N, field);
        });
    }
    
    @Test
    void testTurnInstructions() {
        Mower mower = new Mower("test", new Position(1, 2), Orientation.N, field);
        
        mower.executeInstructions(Arrays.asList(Instruction.G));
        assertEquals(Orientation.W, mower.getOrientation());
        
        mower.executeInstructions(Arrays.asList(Instruction.D, Instruction.D));
        assertEquals(Orientation.E, mower.getOrientation());
    }
    
    @Test
    void testMovementWithinBounds() {
        Mower mower = new Mower("test", new Position(1, 2), Orientation.N, field);
        
        mower.executeInstructions(Arrays.asList(Instruction.A));
        assertEquals(new Position(1, 3), mower.getPosition());
    }
    
    @Test
    void testMovementOutOfBounds() {
        Mower mower = new Mower("test", new Position(0, 0), Orientation.W, field);
        Position originalPosition = mower.getPosition();
        
        mower.executeInstructions(Arrays.asList(Instruction.A));
        assertEquals(originalPosition, mower.getPosition()); // Should not move
    }
    
    @Test
    void testCompleteSequence() {
        // Test case from the exercise
        Mower mower = new Mower("mower1", new Position(1, 2), Orientation.N, field);
        
        mower.executeInstructions(Arrays.asList(
            Instruction.G, Instruction.A, Instruction.G, Instruction.A,
            Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.A
        ));
        
        assertEquals(new Position(1, 3), mower.getPosition());
        assertEquals(Orientation.N, mower.getOrientation());
    }
}
