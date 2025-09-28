package com.libon.mower.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.libon.mower.domain.Instruction;
import com.libon.mower.domain.Orientation;
import com.libon.mower.dto.FieldDto;
import com.libon.mower.dto.MowerRequest;
import com.libon.mower.dto.MowerResult;
import com.libon.mower.dto.MowerSimulationRequest;
import com.libon.mower.dto.PositionDto;

public class MowerSimulationServiceTest {
private MowerSimulationService service;
    
    @BeforeEach
    void setUp() {
        service = new MowerSimulationService();
    }
    
    @Test
    void testSimulateWithProvidedTestCase() {
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
        
        List<MowerResult> results = service.simulate(request);
        
        assertEquals(2, results.size());
        
        MowerResult result1 = results.get(0);
        assertEquals("mower1", result1.getId());
        assertEquals(1, result1.getPosition().getX());
        assertEquals(3, result1.getPosition().getY());
        assertEquals(Orientation.N, result1.getOrientation());
        
        MowerResult result2 = results.get(1);
        assertEquals("mower2", result2.getId());
        assertEquals(5, result2.getPosition().getX());
        assertEquals(1, result2.getPosition().getY());
        assertEquals(Orientation.E, result2.getOrientation());
    }
}
