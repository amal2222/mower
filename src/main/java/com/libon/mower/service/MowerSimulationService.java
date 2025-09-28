package com.libon.mower.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.libon.mower.dto.FieldDto;
import com.libon.mower.dto.MowerRequest;
import com.libon.mower.dto.MowerResult;
import com.libon.mower.dto.MowerSimulationRequest;
import com.libon.mower.dto.PositionDto;
import com.libon.mower.domain.Field;
import com.libon.mower.domain.Mower;
import com.libon.mower.domain.Position;
/**
 * This service coordinates the simulation of multiple mowers on a field,
 * ensuring they execute their instructions sequentially.
 */
@Service
public class MowerSimulationService {

    public List<MowerResult> simulate(MowerSimulationRequest request) {
        // Create the field from the request
        Field field = createField(request.getField());
        // Process each mower sequentially and collect results
        List<MowerResult> results = new ArrayList<>();
        
        for (MowerRequest mowerRequest : request.getMowers()) {
            MowerResult result = simulateMower(mowerRequest, field);
            results.add(result);
        }
        
        return results;
    }

    private Field createField(FieldDto fieldDto) {
        return new Field(fieldDto.getMaxX(), fieldDto.getMaxY());
    }

    /**
     * Simulates a single mower's movement on the field.
     * @param mowerRequest the mower configuration and instructions
     * @param field the field the mower operates on
     * @return the final state of the mower after executing all instructions
     */
    private MowerResult simulateMower(MowerRequest mowerRequest, Field field) {
        Position startPosition = new Position(
            mowerRequest.getStartPosition().getX(),
            mowerRequest.getStartPosition().getY()
        );
        // Create the mower with initial configuration
        Mower mower = new Mower(
            mowerRequest.getId(),
            startPosition,
            mowerRequest.getOrientation(),
            field
        );
        // Execute all instructions sequentially
        mower.executeInstructions(mowerRequest.getInstructions());
        // Convert final state back to DTO format
        return new MowerResult(
            mower.getId(),
            new PositionDto(mower.getPosition().getX(), mower.getPosition().getY()),
            mower.getOrientation()
        );
    }

}
