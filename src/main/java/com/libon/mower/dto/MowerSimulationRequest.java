package com.libon.mower.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class MowerSimulationRequest {

    @Valid
    @NotNull
    private FieldDto field;

    @Valid
    @NotEmpty
    private List<MowerRequest> mowers;
    
    public MowerSimulationRequest(FieldDto field, List<MowerRequest> mowers) {
        this.field = field;
        this.mowers = mowers;
    }

    public FieldDto getField() {
        return field;
    }

    public void setField(FieldDto field) {
        this.field = field;
    }

    public List<MowerRequest> getMowers() {
        return mowers;
    }

    public void setMowers(List<MowerRequest> mowers) {
        this.mowers = mowers;
    }
    
}
