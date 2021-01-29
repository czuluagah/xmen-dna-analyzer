package com.xmen.dnasentinel.services.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xmen.dnasentinel.model.DNAAnalysisStats;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.repositories.DNARespository;
import com.xmen.dnasentinel.repositories.dcouments.DnaDcoument;
import com.xmen.dnasentinel.services.DNAAnalysisStorageService;

import static com.xmen.dnasentinel.utils.Constants.HUMAN;
import static com.xmen.dnasentinel.utils.Constants.MUTANT;

@Component
public class DNAAnalysisStorageServiceImpl implements DNAAnalysisStorageService {

    @Autowired private DNARespository repository;

    @Override
    public void storageDNASequence(DNASequence dnaSequence, BigDecimal numberOfMatches, Boolean isMutant) {
        repository.save(DnaDcoument.builder().dnaSecuence(dnaSequence.getSequences())
                .id(UUID.randomUUID().toString())
                .type(isMutant ? MUTANT: HUMAN)
                .numberOfMatches(numberOfMatches)
                .build());
    }

    @Override
    public DNAAnalysisStats getStats() {
        List<DnaDcoument> dnaAnalysis = repository.findAll();
        if (!dnaAnalysis.isEmpty()) {
            Map<String, List<DnaDcoument>> analysisGrouping = dnaAnalysis.stream().collect(Collectors.groupingBy(DnaDcoument::getType));
            Integer mutants = analysisGrouping.getOrDefault(MUTANT, Collections.emptyList()).size();
            Integer numberOfAnalysis = dnaAnalysis.size();
            double ration = (mutants * 100) / numberOfAnalysis;
            return DNAAnalysisStats.builder()
                    .humans(analysisGrouping.getOrDefault(HUMAN, Collections.emptyList()).size())
                    .mutants(mutants)
                    .ratio(ration / 100)
                    .numberOfAnalusis(dnaAnalysis.size()).build();
        }

        return DNAAnalysisStats.builder().mutants(0).humans(0).numberOfAnalusis(0).build();
    }
}
