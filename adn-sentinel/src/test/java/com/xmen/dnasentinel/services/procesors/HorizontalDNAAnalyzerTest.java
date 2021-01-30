package com.xmen.dnasentinel.services.procesors;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.procesors.impl.HorizontalDNAAnalyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorizontalDNAAnalyzerTest {
    HorizontalDNAAnalyzer dnaAnalyzer = new HorizontalDNAAnalyzer();

    @Test
    public void whenIsHorizontalAnalysisAndFountMutantDNA(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"));
        BigDecimal actual = dnaAnalyzer.analyze(dnaSequence);
        assertEquals(BigDecimal.valueOf(1),actual);
    }

    @Test
    public void whenIsHorizontalAnalysisAndNotFoundMutantDNA(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(Arrays.asList("GTGCGA","CAGTGC","TTATGT","AGAAGG","CACCTA","TCACTG"));
        BigDecimal actual = dnaAnalyzer.analyze(dnaSequence);
        assertEquals(BigDecimal.ZERO,actual);
    }
}
