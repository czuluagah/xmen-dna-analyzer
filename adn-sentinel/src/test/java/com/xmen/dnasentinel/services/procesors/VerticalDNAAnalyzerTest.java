package com.xmen.dnasentinel.services.procesors;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.procesors.impl.VerticalDNAAnalyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VerticalDNAAnalyzerTest {

    VerticalDNAAnalyzer dnaAnalyzer = new VerticalDNAAnalyzer();

    private static final List<String> SEQUENCE_WITH_MUTANT_DNA = Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG");
    private static final List<String> SEQUENCE_WITHOUT_MUTANT_DNA = Arrays.asList("GTGCAA","CAGTGC","TTATGT","AGAAGG","CACCTA","TCACTG");

    @Test
    void whenIsVerticalAnalysisAndFountMutantDNA(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(SEQUENCE_WITH_MUTANT_DNA);
        BigDecimal actual = dnaAnalyzer.analyze(dnaSequence);
        assertEquals(BigDecimal.valueOf(1),actual);
    }

    @Test
    void whenIsVerticalAnalysisAndNotFoundMutantDNA(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(SEQUENCE_WITHOUT_MUTANT_DNA);
        BigDecimal actual = dnaAnalyzer.analyze(dnaSequence);
        assertEquals(BigDecimal.ZERO,actual);
    }
}
