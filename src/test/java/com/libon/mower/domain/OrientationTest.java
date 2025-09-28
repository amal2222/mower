package com.libon.mower.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrientationTest {
    
    @Test
    void testTurnLeft() {
        assertEquals(Orientation.W, Orientation.N.turnLeft());
        assertEquals(Orientation.N, Orientation.E.turnLeft());
        assertEquals(Orientation.E, Orientation.S.turnLeft());
        assertEquals(Orientation.S, Orientation.W.turnLeft());
    }
    
    @Test
    void testTurnRight() {
        assertEquals(Orientation.E, Orientation.N.turnRight());
        assertEquals(Orientation.S, Orientation.E.turnRight());
        assertEquals(Orientation.W, Orientation.S.turnRight());
        assertEquals(Orientation.N, Orientation.W.turnRight());
    }
    
    @Test
void testMovements() {
    assertEquals(0, Orientation.N.getXMovement());
    assertEquals(1, Orientation.N.getYMovement());
    
    assertEquals(1, Orientation.E.getXMovement());  
    assertEquals(0, Orientation.E.getYMovement());
    
    assertEquals(0, Orientation.S.getXMovement());
    assertEquals(-1, Orientation.S.getYMovement());
    
    assertEquals(-1, Orientation.W.getXMovement());
    assertEquals(0, Orientation.W.getYMovement());
}
}
