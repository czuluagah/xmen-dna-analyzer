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

    private final ObjectFactory<DNAAnalizerCommand> horizontalDNAAnalyzerObjectFactory;

    private final ObjectFactory<DNAAnalizerCommand> verticalDNAAnalyzerObjectFactory;

    private final ObjectFactory<DNAAnalizerCommand> diagonalDNAAnalyzerObjectFactory;

    public DNAAnalyzerFactory(@Qualifier("horizontalDNAAnalyzer") ObjectFactory<DNAAnalizerCommand> horizontalDNAAnalyzerObjectFactory,
                              @Qualifier("verticalDNAAnalyzer") ObjectFactory<DNAAnalizerCommand> verticalDNAAnalyzerObjectFactory,
                              @Qualifier("diagonalDNAAnalyzer") ObjectFactory<DNAAnalizerCommand> diagonalDNAAnalyzerObjectFactory) {
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
        }
        return null;
    }
}
