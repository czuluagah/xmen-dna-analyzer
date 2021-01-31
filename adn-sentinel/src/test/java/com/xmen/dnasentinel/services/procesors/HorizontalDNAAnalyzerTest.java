package com.xmen.dnasentinel.services.procesors;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.procesors.impl.HorizontalDNAAnalyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HorizontalDNAAnalyzerTest {

    private static final List<String> SEQUENCE_WITH_MUTANT_DNA = Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG");
    private static final List<String> SEQUENCE_WITHOUT_MUTANT_DNA = Arrays.asList("GTGCAA","CAGTGC","TTATGT","AGAAGG","CACCTA","TCACTG");

    HorizontalDNAAnalyzer dnaAnalyzer = new HorizontalDNAAnalyzer();

    @Test
    void whenIsHorizontalAnalysisAndFountMutantDNA(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(SEQUENCE_WITH_MUTANT_DNA);
        BigDecimal actual = dnaAnalyzer.analyze(dnaSequence);
        assertEquals(BigDecimal.valueOf(1),actual);
    }

    @Test
    void whenIsHorizontalAnalysisAndNotFoundMutantDNA(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(SEQUENCE_WITHOUT_MUTANT_DNA);
        BigDecimal actual = dnaAnalyzer.analyze(dnaSequence);
        assertEquals(BigDecimal.ZERO,actual);
    }
}
