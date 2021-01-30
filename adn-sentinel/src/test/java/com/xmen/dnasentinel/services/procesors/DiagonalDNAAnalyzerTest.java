package com.xmen.dnasentinel.services.procesors;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.procesors.impl.DiagonalDNAAnalyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagonalDNAAnalyzerTest {

    DiagonalDNAAnalyzer dnaAnalyzer = new DiagonalDNAAnalyzer();

    @Test
    public void whenIsDiagonlAnalysisAndFountMutantDNA(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"));
        BigDecimal actual = dnaAnalyzer.analyze(dnaSequence);
        assertEquals(BigDecimal.valueOf(1),actual);
    }

    @Test
    public void whenIsDiagonlAnalysisAndNotFoundMutantDNA(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(Arrays.asList("GTGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"));
        BigDecimal actual = dnaAnalyzer.analyze(dnaSequence);
        assertEquals(BigDecimal.ZERO,actual);
    }

}
