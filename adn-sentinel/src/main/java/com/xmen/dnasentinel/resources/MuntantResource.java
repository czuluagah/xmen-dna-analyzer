package com.xmen.dnasentinel.resources;

import org.springframework.http.ResponseEntity;

import com.xmen.dnasentinel.model.DNASequence;

public interface MuntantResource {

    public ResponseEntity isMutant(DNASequence dnaSequence);

}
