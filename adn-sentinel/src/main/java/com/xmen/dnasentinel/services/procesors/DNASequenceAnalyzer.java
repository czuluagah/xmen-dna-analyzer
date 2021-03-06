package com.xmen.dnasentinel.services.procesors;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.types.DNAAnalysisType;

@Component
@Slf4j
public class DNASequenceAnalyzer {

    private final DNAAnalyzerFactory factory;

    public DNASequenceAnalyzer(DNAAnalyzerFactory factory) {
        this.factory = factory;
    }

    public BigDecimal executeAnalysis(DNAAnalysisType dnaAnalysisType, DNASequence dnaSequence){
        return factory.getAnalizer(dnaAnalysisType)
                .analyze(dnaSequence);
    }
}
