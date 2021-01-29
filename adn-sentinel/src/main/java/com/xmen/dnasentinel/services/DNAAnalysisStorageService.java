package com.xmen.dnasentinel.services;

import java.math.BigDecimal;

import com.xmen.dnasentinel.model.DNAAnalysisStats;
import com.xmen.dnasentinel.model.DNASequence;

public interface DNAAnalysisStorageService {

    public void storageDNASequence(DNASequence dnaSequence, BigDecimal numberOfMatches, Boolean isMutant);

    public DNAAnalysisStats getStats();

}
