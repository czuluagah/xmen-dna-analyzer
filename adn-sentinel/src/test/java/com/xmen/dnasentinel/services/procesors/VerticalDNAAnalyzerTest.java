package com.xmen.dnasentinel.services.procesors;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.procesors.impl.VerticalDNAAnalyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerticalDNAAnalyzerTest {

    VerticalDNAAnalyzer dnaAnalyzer = new VerticalDNAAnalyzer();

    @Test
    public void whenIsVerticalAnalysisAndFountMutantDNA(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"));
        BigDecimal actual = dnaAnalyzer.analyze(dnaSequence);
        assertEquals(BigDecimal.valueOf(1),actual);
    }

    @Test
    public void whenIsVerticalAnalysisAndNotFoundMutantDNA(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(Arrays.asList("GTGCAA","CAGTGC","TTATGT","AGAAGG","CACCTA","TCACTG"));
        BigDecimal actual = dnaAnalyzer.analyze(dnaSequence);
        assertEquals(BigDecimal.ZERO,actual);
    }
}
