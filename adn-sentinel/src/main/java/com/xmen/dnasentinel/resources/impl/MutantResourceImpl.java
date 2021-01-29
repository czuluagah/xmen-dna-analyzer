package com.xmen.dnasentinel.resources.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xmen.dnasentinel.model.AnalysisResult;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.resources.MuntantResource;
import com.xmen.dnasentinel.services.DNASentinelService;

import static com.xmen.dnasentinel.utils.Constants.MUTANT_RESOURCE;

@Api(
        value = "DNA Mutant Analyzer",
        tags = "controller",
        description = "Mutant controller",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)

@RestController
public class MutantResourceImpl implements MuntantResource {

    @Autowired
    private DNASentinelService sentinelService;

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
    @PostMapping(MUTANT_RESOURCE)
    public ResponseEntity isMutant(@RequestBody @Valid DNASequence dnaSequence) {
        boolean isMutant = sentinelService.isMutant(dnaSequence);
        return isMutant ? ResponseEntity.ok().build() :
                ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
