package com.xmen.dnasentinel.services;

import com.xmen.dnasentinel.model.DNAAnalysisStats;
import com.xmen.dnasentinel.model.DNASequence;

public interface DNASentinelService {

    boolean isMutant(DNASequence dnaSequence);

    DNAAnalysisStats getStats();
}
