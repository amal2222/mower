package com.libon.mower.dto;

import java.util.List;

public class MowerSimulationRequest {

    private FieldDto field;
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
