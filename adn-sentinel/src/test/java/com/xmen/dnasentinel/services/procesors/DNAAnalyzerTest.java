package com.xmen.dnasentinel.services.procesors;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.xmen.dnasentinel.command.DNAAnalizerCommand;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.types.DNAAnalysisType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DNAAnalyzerTest {

    @Mock
    private DNAAnalyzerFactory factory;

    @Mock DNAAnalizerCommand command;

    private DNASequenceAnalyzer analyzer;

    public DNAAnalyzerTest() {
        MockitoAnnotations.initMocks(this);
        analyzer = new DNASequenceAnalyzer(factory);
    }

    @Test
    void getHorizontalTest(){
        DNASequence dnaSequence = new DNASequence();
        DNAAnalysisType type = DNAAnalysisType.VERTICAL_ANALYSIS;
        when(factory.getAnalizer(type)).thenReturn(command);
        when(command.analyze(dnaSequence)).thenReturn(BigDecimal.ONE);
        BigDecimal matches = analyzer.executeAnalysis(type, dnaSequence);
        assertEquals(BigDecimal.ONE, matches);
    }

}
