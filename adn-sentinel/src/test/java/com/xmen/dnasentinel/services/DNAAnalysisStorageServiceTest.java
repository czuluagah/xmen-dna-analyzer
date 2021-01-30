package com.xmen.dnasentinel.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.xmen.dnasentinel.model.DNAAnalysisStats;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.repositories.DNARespository;
import com.xmen.dnasentinel.repositories.dcouments.DnaDcoument;
import com.xmen.dnasentinel.services.impl.DNAAnalysisStorageServiceImpl;
import com.xmen.dnasentinel.utils.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class DNAAnalysisStorageServiceTest {
    @Mock
    private final DNARespository respository = null;

    private DNAAnalysisStorageServiceImpl storageService = null;

    private DNASequence dnaSequence;

    public DNAAnalysisStorageServiceTest(){
        MockitoAnnotations.initMocks(this);
        storageService = new DNAAnalysisStorageServiceImpl(respository);
        dnaSequence = new DNASequence();
        dnaSequence.setSequences(Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTX"));
    }

    @Test
    public void saveMutantDNA(){
        storageService.storageDNASequence(dnaSequence, BigDecimal.valueOf(3), Boolean.TRUE);
    }

    @Test
    public void saveHumanDNA(){
        storageService.storageDNASequence(dnaSequence, BigDecimal.valueOf(1), Boolean.FALSE);
    }

    @Test
    public void testGetStats(){
        List<DnaDcoument> documents = Arrays.asList(
                DnaDcoument.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Constants.MUTANT)
                        .numberOfMatches(BigDecimal.valueOf(2))
                        .build(),
                DnaDcoument.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Constants.HUMAN)
                        .numberOfMatches(BigDecimal.ONE)
                        .build()
        );
        when(respository.findAll()).thenReturn(documents);
        DNAAnalysisStats expected = DNAAnalysisStats.builder()
                .humans(1)
                .mutants(1)
                .ratio(0.5)
                .numberOfAnalusis(2).build();

        DNAAnalysisStats stats = storageService.getStats();
        assertEquals(expected, stats);
    }

    @Test
    public void testGetStatsWhenNotAnalysisExecuted(){
        List<DnaDcoument> documents = Collections.emptyList();
        when(respository.findAll()).thenReturn(documents);
        DNAAnalysisStats expected = DNAAnalysisStats.builder()
                .humans(0)
                .mutants(0)
                .ratio(0)
                .numberOfAnalusis(0).build();

        DNAAnalysisStats stats = storageService.getStats();
        assertEquals(expected, stats);
    }
}
