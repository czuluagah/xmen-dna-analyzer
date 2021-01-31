package com.xmen.dnasentinel.services.procesors;

import java.math.BigDecimal;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.xmen.dnasentinel.command.DNAAnalizerCommand;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.types.DNAAnalysisType;

@Component
public class DNAAnalyzerFactory {

    private final ObjectFactory<DNAAnalizerCommand<DNASequence, BigDecimal>> horizontalDNAAnalyzerObjectFactory;

    private final ObjectFactory<DNAAnalizerCommand<DNASequence, BigDecimal>> verticalDNAAnalyzerObjectFactory;

    private final ObjectFactory<DNAAnalizerCommand<DNASequence, BigDecimal>> diagonalDNAAnalyzerObjectFactory;

    public DNAAnalyzerFactory(@Qualifier("horizontalDNAAnalyzer") ObjectFactory<DNAAnalizerCommand<DNASequence, BigDecimal>> horizontalDNAAnalyzerObjectFactory, @Qualifier("verticalDNAAnalyzer") ObjectFactory<DNAAnalizerCommand<DNASequence, BigDecimal>> verticalDNAAnalyzerObjectFactory, @Qualifier("diagonalDNAAnalyzer") ObjectFactory<DNAAnalizerCommand<DNASequence, BigDecimal>> diagonalDNAAnalyzerObjectFactory) {
        this.horizontalDNAAnalyzerObjectFactory = horizontalDNAAnalyzerObjectFactory;
        this.verticalDNAAnalyzerObjectFactory = verticalDNAAnalyzerObjectFactory;
        this.diagonalDNAAnalyzerObjectFactory = diagonalDNAAnalyzerObjectFactory;
    }

    public DNAAnalizerCommand<DNASequence, BigDecimal> getAnalizer(DNAAnalysisType dnaAnalysisType){
        switch (dnaAnalysisType){
            case VERTICAL_ANALYSIS:
                return verticalDNAAnalyzerObjectFactory.getObject();
            case HORIZONTAL_ANALYSIS:
                return horizontalDNAAnalyzerObjectFactory.getObject();
            case DIAGONAL_ANALYSIS:
                return diagonalDNAAnalyzerObjectFactory.getObject();
            default: return null;
        }

    }
}
