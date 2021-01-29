package com.xmen.dnasentinel.services.procesors;

import java.math.BigDecimal;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.xmen.dnasentinel.command.DNAAnalizerCommand;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.types.DNAAnalysisType;

@Component
public class DNAAnalyzerFactory {

    @Autowired
    @Qualifier("horizontalDNAAnalyzer")
    private ObjectFactory<DNAAnalizerCommand> horizontalDNAAnalyzerObjectFactory;

    @Autowired
    @Qualifier("verticalDNAAnalyzer")
    private ObjectFactory<DNAAnalizerCommand> verticalDNAAnalyzerObjectFactory;

    @Autowired
    @Qualifier("diagonalDNAAnalyzer")
    private ObjectFactory<DNAAnalizerCommand> diagonalDNAAnalyzerObjectFactory;

    public DNAAnalizerCommand<DNASequence, BigDecimal> getAnalizer(DNAAnalysisType dnaAnalysisType){
        switch (dnaAnalysisType){
            case VERTICAL_ANALYSIS:
                return verticalDNAAnalyzerObjectFactory.getObject();
            case HORIZONTAL_ANALYSIS:
                return horizontalDNAAnalyzerObjectFactory.getObject();
            case DIAGONAL_STRAIT_ANALYSIS:
                return diagonalDNAAnalyzerObjectFactory.getObject();
            case DIAGONAL_INVERSE_ANALYSIS:
                return diagonalDNAAnalyzerObjectFactory.getObject();
        }
        return null;
    }
}
