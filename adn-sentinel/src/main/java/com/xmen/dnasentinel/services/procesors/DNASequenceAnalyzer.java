package com.xmen.dnasentinel.services.procesors;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.types.DNAAnalysisType;

@Component
@Slf4j
public class DNASequenceAnalyzer {

    @Autowired
    private DNAAnalyzerFactory factory;

    public BigDecimal executeAnalysis(DNAAnalysisType dnaAnalysisType, DNASequence dnaSequence){
        return factory.getAnalizer(dnaAnalysisType)
                .analyze(dnaSequence);
    }
}
