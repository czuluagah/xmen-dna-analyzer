package com.xmen.dnasentinel.resources.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.resources.MuntantResource;
import com.xmen.dnasentinel.services.DNASentinelService;

import static com.xmen.dnasentinel.utils.Constants.MUTANT_RESOURCE;

@Api(
        value = "DNA Mutant Analyzer",
        tags = "controller",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)

@RestController
public class MutantResourceImpl implements MuntantResource {

    private final DNASentinelService sentinelService;

    public MutantResourceImpl(DNASentinelService sentinelService) {
        this.sentinelService = sentinelService;
    }

    @ApiOperation(
            value = "Resource to analyze an DNA sequence",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "POST"
    )

    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful - Mutant DNA Found"),
            @ApiResponse(code = 403, message = "Forbidden - Not Human or Mutant DNA Sequence maybe Alien"),
            @ApiResponse(code = 400, message = "Bad Request - DNA Sample Contamined please contact Charles Francis Xavier - Professor X"),
            @ApiResponse(code = 500, message = "Please contact Charles Francis Xavier - Professor X")
    })

    @Override
    @PostMapping(MUTANT_RESOURCE)
    public ResponseEntity<Object> isMutant(@RequestBody @Valid DNASequence dnaSequence) {
        boolean isMutant = sentinelService.isMutant(dnaSequence);
        return isMutant ? ResponseEntity.ok().build() :
                ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
