package com.xmen.dnasentinel.services.impl;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmen.dnasentinel.model.DNAAnalysisStats;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.repositories.DNARespository;
import com.xmen.dnasentinel.repositories.dcouments.DnaDcoument;
import com.xmen.dnasentinel.services.DNAAnalysisStorageService;

@Service
public class DNAAnalysisStorageServiceImpl implements DNAAnalysisStorageService {

    @Autowired private DNARespository repository;

    @Override
    public void storageDNASequence(DNASequence dnaSequence, BigDecimal numberOfMatches, Boolean isMutant) {
        repository.save(DnaDcoument.builder().dnaSecuence(dnaSequence.getSequences())
                .id(UUID.randomUUID().toString())
                .isMutant(isMutant)
                .numberOfMatches(numberOfMatches)
                .build());
    }

    @Override
    public DNAAnalysisStats getStats() {
        return null;
    }
}
