package com.xmen.dnasentinel.services;

import com.xmen.dnasentinel.model.AnalysisResult;
import com.xmen.dnasentinel.model.DNASequence;

public interface DNAAnalyzerService {

    AnalysisResult isMutant(DNASequence adnSequences);
}
