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
        value = "DNA Mutant Analyzer",
        tags = "controller",
        description = "Mutant controller",
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
            value = "Get the Confirm Page information",
            notes = "Get the necessary information for the Confirm Page"
    )

    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful Mutant DNA Found",
                    response = ResponseEntity.class),
            @ApiResponse(code = 403, message = "Forbidden Mutant DNA Not Found",
                    response = ResponseEntity.class)
    })

    @Override
    @GetMapping(STATS_RESOURCE)
    public ResponseEntity<DNAAnalysisStats> stats() {
        DNAAnalysisStats stats = service.getStats();
        return ResponseEntity.ok(stats);
    }
}
