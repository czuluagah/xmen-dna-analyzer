package com.xmen.dnasentinel.services;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.xmen.dnasentinel.model.AnalysisResult;
import com.xmen.dnasentinel.model.DNAAnalysisStats;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.impl.DNASentinelServiceImpl;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class DNASentinelServiceImplTest {

    @Mock
    private final DNAAnalyzerService dnaAnalyzerService = null;

    @Mock
    private final DNAAnalysisStorageService dnaAnalysisStorageService = null;

    private DNASentinelServiceImpl dnaSentinelService = null;
    private DNASequence dnaSequence;

    public DNASentinelServiceImplTest(){
        MockitoAnnotations.initMocks(this);
        dnaSentinelService = new DNASentinelServiceImpl(dnaAnalyzerService, dnaAnalysisStorageService);
        dnaSequence = new DNASequence();
        dnaSequence.setSequences(Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTX"));
    }

    @Test
    void testAnalysis(){
        AnalysisResult result = AnalysisResult.builder()
                .isMutant(true)
                .numberOfMatches(BigDecimal.valueOf(3)).build();
        when(dnaAnalyzerService.isMutant(dnaSequence)).thenReturn(result);
        Boolean isMutant =  dnaSentinelService.isMutant(dnaSequence);
        assertEquals(result.isMutant(), isMutant);
    }

    @Test
    void testStats(){
        DNAAnalysisStats stats = DNAAnalysisStats.builder().mutants(10)
                .humans(5)
                .ratio(0.5)
                .numberOfAnalusis(15).build();
        when(dnaAnalysisStorageService.getStats()).thenReturn(stats);
        DNAAnalysisStats actual =  dnaSentinelService.getStats();
        assertEquals(stats, actual);
    }


}
