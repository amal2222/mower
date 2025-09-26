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


@Service
public class MowerSimulationService {

    public List<MowerResult> simulate(MowerSimulationRequest request) {
        Field field = createField(request.getField());
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

    private MowerResult simulateMower(MowerRequest mowerRequest, Field field) {
        Position startPosition = new Position(
            mowerRequest.getStartPosition().getX(),
            mowerRequest.getStartPosition().getY()
        );
        
        Mower mower = new Mower(
            mowerRequest.getId(),
            startPosition,
            mowerRequest.getOrientation(),
            field
        );
        
        mower.executeInstructions(mowerRequest.getInstructions());
        
        return new MowerResult(
            mower.getId(),
            new PositionDto(mower.getPosition().getX(), mower.getPosition().getY()),
            mower.getOrientation()
        );
    }

}
