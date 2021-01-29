package com.xmen.dnasentinel.services.impl;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmen.dnasentinel.exceptions.ContaminatedDnaSampleException;
import com.xmen.dnasentinel.model.AnalysisResult;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.DNAAnalyzerService;
import com.xmen.dnasentinel.services.procesors.DNASequenceAnalyzer;
import com.xmen.dnasentinel.services.types.DNAAnalysisType;

import static com.xmen.dnasentinel.utils.DNAAnalyzerValidator.IS_MUTANT_DNA;

@Service
@Slf4j
public class DNAAnalyzerServiceImpl implements DNAAnalyzerService {

    @Autowired private DNASequenceAnalyzer dnaSequenceAnalyzer;

    @Override
    public AnalysisResult isMutant(DNASequence dnaSequence) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        try {
            List<BigDecimal> findings = forkJoinPool.submit(() ->
                    Arrays.asList(DNAAnalysisType.values()).parallelStream()
                    .map(dnaAnalysisType -> dnaSequenceAnalyzer.executeAnalysis(dnaAnalysisType, dnaSequence))
                    .collect(Collectors.toList())
            ).get();

            BigDecimal numberOfDNAMutantFound = findings.stream()
                    .filter(Objects::nonNull)
                    .reduce(BigDecimal::add)
                    .orElseGet(()->BigDecimal.ZERO);

            return AnalysisResult.builder()
                    .isMutant(IS_MUTANT_DNA.apply(numberOfDNAMutantFound))
                    .numberOfMatches(numberOfDNAMutantFound)
                    .build();

        }catch(Exception e){
            throw new ContaminatedDnaSampleException("DNA Sample Contaminated");
        }
    }
}
