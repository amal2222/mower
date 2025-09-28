package com.libon.mower.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.libon.mower.domain.Instruction;
import com.libon.mower.domain.Orientation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class MowerRequest {
    @NotBlank
    private String id;

    @Valid
    @NotNull
    @JsonProperty("start_position")
    private PositionDto startPosition;
    
    @NotNull
    private Orientation orientation;

    @NotEmpty
    private List<Instruction> instructions;
    
    public MowerRequest(String id, PositionDto startPosition, Orientation orientation, List<Instruction> instructions) {
        this.id = id;
        this.startPosition = startPosition;
        this.orientation = orientation;
        this.instructions = instructions;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public PositionDto getStartPosition() {
        return startPosition;
    }
    public void setStartPosition(PositionDto startPosition) {
        this.startPosition = startPosition;
    }
    public Orientation getOrientation() {
        return orientation;
    }
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
    public List<Instruction> getInstructions() {
        return instructions;
    }
    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

}
