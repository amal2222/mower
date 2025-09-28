package com.libon.mower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libon.mower.dto.MowerResult;
import com.libon.mower.dto.MowerSimulationRequest;
import com.libon.mower.service.MowerSimulationService;

import jakarta.validation.Valid;
/**
 * REST controller providing HTTP endpoints for mower simulation operations.
 * Base URL: /api/mowers
 */
@RestController
@RequestMapping("/api/mowers")
public class MowerController {
    private final MowerSimulationService simulationService;
    
    @Autowired
    public MowerController(MowerSimulationService simulationService) {
        this.simulationService = simulationService;
    }
    
    /**
     * Simulates mower movements based on provided instructions.
     * 
     * This endpoint accepts a JSON payload describing a field and multiple
     * mowers with their starting positions and instruction sequences.
     * Each mower executes its instructions completely before the next begins.
     */
    @PostMapping("/simulate")
    public ResponseEntity<List<MowerResult>> simulate(
            @Valid @RequestBody MowerSimulationRequest request) {
        
        List<MowerResult> results = simulationService.simulate(request);
        return ResponseEntity.ok(results);
    }

}
