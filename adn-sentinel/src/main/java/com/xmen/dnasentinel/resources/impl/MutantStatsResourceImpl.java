package com.xmen.dnasentinel.resources.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmen.dnasentinel.model.DNAAnalysisStats;
import com.xmen.dnasentinel.resources.MutantStatsResource;
import com.xmen.dnasentinel.services.DNASentinelService;

import static com.xmen.dnasentinel.utils.Constants.STATS_RESOURCE;

@Api(
        value = "DNA Mutant Stats - Resource to visualize the stats from the dna analysis",
        tags = "controller",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)

@RestController
public class MutantStatsResourceImpl implements MutantStatsResource {

    private final DNASentinelService service;

    public MutantStatsResourceImpl(DNASentinelService service) {
        this.service = service;
    }

    @ApiOperation(
            value = "Resource to get stats from dna analysis",
            produces = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
    )

    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful Stats Online"),
            @ApiResponse(code = 500, message = "Please contact Charles Francis Xavier - Professor X")
    })

    @Override
    @GetMapping(STATS_RESOURCE)
    public ResponseEntity<DNAAnalysisStats> stats() {
        DNAAnalysisStats stats = service.getStats();
        return ResponseEntity.ok(stats);
    }
}
