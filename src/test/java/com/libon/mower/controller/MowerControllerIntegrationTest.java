package com.libon.mower.controller;

import com.libon.mower.domain.Instruction;
import com.libon.mower.domain.Orientation;
import com.libon.mower.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MowerControllerIntegrationTest {
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    void testExerciseCase() {
        // Create the test request
        FieldDto field = new FieldDto(5, 5);
        
        MowerRequest mower1 = new MowerRequest(
            "mower1",
            new PositionDto(1, 2),
            Orientation.N,
            Arrays.asList(Instruction.G, Instruction.A, Instruction.G, Instruction.A,
                         Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.A)
        );
        
        MowerRequest mower2 = new MowerRequest(
            "mower2",
            new PositionDto(3, 3),
            Orientation.E,
            Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.A,
                         Instruction.A, Instruction.D, Instruction.A, Instruction.D,
                         Instruction.D, Instruction.A)
        );
        
        MowerSimulationRequest request = new MowerSimulationRequest(field, Arrays.asList(mower1, mower2));
        
        // Make the HTTP call
        ResponseEntity<MowerResult[]> response = restTemplate.postForEntity(
            "/api/mowers/simulate", 
            request, 
            MowerResult[].class
        );
        
        // Check the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().length);
        
        // Check mower1 result: should be at (1,3) facing N
        assertEquals("mower1", response.getBody()[0].getId());
        assertEquals(1, response.getBody()[0].getPosition().getX());
        assertEquals(3, response.getBody()[0].getPosition().getY());
        assertEquals(Orientation.N, response.getBody()[0].getOrientation());
        
        // Check mower2 result: should be at (5,1) facing E  
        assertEquals("mower2", response.getBody()[1].getId());
        assertEquals(5, response.getBody()[1].getPosition().getX());
        assertEquals(1, response.getBody()[1].getPosition().getY());
        assertEquals(Orientation.E, response.getBody()[1].getOrientation());
    }
}