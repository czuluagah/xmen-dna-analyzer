package com.xmen.dnasentinel.services.impl;

import org.springframework.stereotype.Service;

import com.xmen.dnasentinel.model.AnalysisResult;
import com.xmen.dnasentinel.model.DNAAnalysisStats;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.DNAAnalysisStorageService;
import com.xmen.dnasentinel.services.DNAAnalyzerService;
import com.xmen.dnasentinel.services.DNASentinelService;

@Service
public class DNASentinelServiceImpl implements DNASentinelService {

    private final DNAAnalyzerService dnaAnalyzerService;
    private final DNAAnalysisStorageService dnaAnalysisStorageService;

    public DNASentinelServiceImpl(DNAAnalyzerService dnaAnalyzerService, DNAAnalysisStorageService dnaAnalysisStorageService) {
        this.dnaAnalyzerService = dnaAnalyzerService;
        this.dnaAnalysisStorageService = dnaAnalysisStorageService;
    }

    public boolean isMutant(DNASequence dnaSequence){
        AnalysisResult analysisResult =  dnaAnalyzerService.isMutant(dnaSequence);
        dnaAnalysisStorageService.storageDNASequence(dnaSequence,
                analysisResult.getNumberOfMatches(),
                analysisResult.isMutant());
        return analysisResult.isMutant();
    }

    @Override
    public DNAAnalysisStats getStats() {
        return dnaAnalysisStorageService.getStats();
    }


}
