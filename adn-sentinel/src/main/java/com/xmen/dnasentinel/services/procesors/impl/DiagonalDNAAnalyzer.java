package com.xmen.dnasentinel.services.procesors.impl;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.xmen.dnasentinel.command.DNAAnalizerCommand;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.types.DNAAnalysisType;
import com.xmen.dnasentinel.utils.DNAAnalyzerValidator;
import static java.lang.String.valueOf;

@Component("diagonalDNAAnalyzer")
@Slf4j
public class DiagonalDNAAnalyzer implements DNAAnalizerCommand<DNASequence, BigDecimal> {

    @Override
    public BigDecimal analyze(DNASequence dnaSequence) {
        log.info("=============== Running DiagonalDNAAnalyzer ================");
        BigDecimal numberOfMatches = BigDecimal.ZERO;
        for(DNAAnalysisType dnaAnalysisType : DNAAnalysisType.getDiagonalMethod()) {
            numberOfMatches = numberOfMatches.add(this.processDiagonalAnalysis(dnaSequence, dnaAnalysisType));
        }
        return numberOfMatches;
    }

    public BigDecimal processDiagonalAnalysis(DNASequence dnaSequence, DNAAnalysisType type){
        return Optional.ofNullable(
                dnaSequence.getSequences().stream().reduce("", (diagonal, sequence) ->
                    type.compareTo(DNAAnalysisType.DIAGONAL_STRAIT_ANALYSIS) == 0 ?
                            diagonal.concat(valueOf(sequence.charAt(diagonal.length()))):
                            diagonal.concat(valueOf(sequence.charAt(sequence.length() - (diagonal.length() + 1))))
                )).filter(DNAAnalyzerValidator::isMutantDNA).map(s -> BigDecimal.ONE).orElseGet(()-> BigDecimal.ZERO);
    }
}
