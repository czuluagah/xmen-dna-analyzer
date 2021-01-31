package com.xmen.dnasentinel.services.procesors;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.ObjectFactory;

import com.xmen.dnasentinel.command.DNAAnalizerCommand;
import com.xmen.dnasentinel.services.procesors.impl.DiagonalDNAAnalyzer;
import com.xmen.dnasentinel.services.procesors.impl.HorizontalDNAAnalyzer;
import com.xmen.dnasentinel.services.procesors.impl.VerticalDNAAnalyzer;
import com.xmen.dnasentinel.services.types.DNAAnalysisType;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DNAAnalyzerFactoryTest {

    private DNAAnalyzerFactory factory = null;

    @Mock
    private ObjectFactory horizontalDNAAnalyzerObjectFactory;

    @Mock
    private ObjectFactory verticalDNAAnalyzerObjectFactory;

    @Mock
    private ObjectFactory diagonalDNAAnalyzerObjectFactory;

    public DNAAnalyzerFactoryTest() {
        MockitoAnnotations.initMocks(this);
        factory = new DNAAnalyzerFactory(horizontalDNAAnalyzerObjectFactory,
                verticalDNAAnalyzerObjectFactory,
                diagonalDNAAnalyzerObjectFactory);
    }

    @Test
    void getHorizontalTest(){
        when(horizontalDNAAnalyzerObjectFactory.getObject()).thenReturn(new HorizontalDNAAnalyzer());
        DNAAnalizerCommand comand = factory.getAnalizer(DNAAnalysisType.HORIZONTAL_ANALYSIS);
        assertNotNull(comand);
    }

    @Test
    void getVeticalTest(){
        when(verticalDNAAnalyzerObjectFactory.getObject()).thenReturn(new VerticalDNAAnalyzer());
        DNAAnalizerCommand comand = factory.getAnalizer(DNAAnalysisType.VERTICAL_ANALYSIS);
        assertNotNull(comand);
    }

    @Test
    void getDiagonalTest(){
        when(diagonalDNAAnalyzerObjectFactory.getObject()).thenReturn(new DiagonalDNAAnalyzer());
        DNAAnalizerCommand comand = factory.getAnalizer(DNAAnalysisType.DIAGONAL_ANALYSIS);
        assertNotNull(comand);
    }

}
