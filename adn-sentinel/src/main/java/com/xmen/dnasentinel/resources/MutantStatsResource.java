package com.xmen.dnasentinel.resources;

import org.springframework.http.ResponseEntity;

import com.xmen.dnasentinel.model.DNAAnalysisStats;

public interface MutantStatsResource {

    ResponseEntity<DNAAnalysisStats> stats();
}
