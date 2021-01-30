package com.xmen.dnasentinel.services;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.xmen.dnasentinel.exceptions.ContaminatedDnaSampleException;
import com.xmen.dnasentinel.model.AnalysisResult;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.impl.DNAAnalyzerServiceImpl;
import com.xmen.dnasentinel.services.procesors.DNASequenceAnalyzer;
import com.xmen.dnasentinel.services.types.DNAAnalysisType;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.isA;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DNAAnalyzerServiceImplTest  {

    @Mock
    private DNASequenceAnalyzer dnaSequenceAnalyzer;

    private DNAAnalyzerServiceImpl service;
    private DNASequence dnaSequence;

    public DNAAnalyzerServiceImplTest() {
        MockitoAnnotations.initMocks(this);
        service = new DNAAnalyzerServiceImpl(dnaSequenceAnalyzer);
        dnaSequence = new DNASequence();
        dnaSequence.setSequences(Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTX"));
    }

    @Test
    public void testAnalysis() {
        when(dnaSequenceAnalyzer.executeAnalysis(isA(DNAAnalysisType.class),
                isA(DNASequence.class))).thenReturn(BigDecimal.ONE);
        AnalysisResult result = service.isMutant(dnaSequence);
        AnalysisResult expected = AnalysisResult.builder()
                .isMutant(true).numberOfMatches(BigDecimal.valueOf(3)).build();
        assertNotNull(result);
        assertEquals(expected.isMutant(), result.isMutant());
    }

    @Test
    public void testAnalysisNotMutant() {
        when(dnaSequenceAnalyzer.executeAnalysis(isA(DNAAnalysisType.class),
                isA(DNASequence.class))).thenReturn(BigDecimal.ZERO);
        AnalysisResult result = service.isMutant(dnaSequence);
        AnalysisResult expected = AnalysisResult.builder()
                .isMutant(false).numberOfMatches(BigDecimal.ZERO).build();
        assertNotNull(result);
        assertEquals(expected.isMutant(), result.isMutant());
    }
}
