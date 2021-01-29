package com.xmen.dnasentinel.services.procesors.impl;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.xmen.dnasentinel.command.DNAAnalizerCommand;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.services.types.DNAAnalysisType;
import com.xmen.dnasentinel.utils.DNAAnalyzerValidator;

@Component("diagonalDNAAnalyzer")
@Slf4j
public class DiagonalDNAAnalyzer implements DNAAnalizerCommand<DNASequence, BigDecimal> {

    @Override
    public BigDecimal analyze(DNASequence dnaSequence) {
        log.info("=============== Running DiagonalDNAAnalyzer ================");
        BigDecimal matches = BigDecimal.ZERO;
        DNAAnalysisType.getDiagonalMethod().forEach(dnaAnalysisType -> {
            matches.add(this.processDiagonalAnalysis(dnaSequence, dnaAnalysisType));
        });
        return matches;
    }

    public BigDecimal processDiagonalAnalysis(DNASequence dnaSequence, DNAAnalysisType type){
        BigDecimal sequenceDetected = Optional.ofNullable(
                dnaSequence.getSequences().stream().reduce("", (diagonal, sequence) ->
                    type.compareTo(DNAAnalysisType.DIAGONAL_STRAIT_ANALYSIS)  == 0?
                            diagonal.concat(String.valueOf(sequence.charAt(diagonal.length()))):
                            diagonal.concat(String.valueOf( sequence.charAt(sequence.length() - (diagonal.length() + 1))))
                )
        ).filter(DNAAnalyzerValidator::isMutantDNA).map(s -> BigDecimal.ONE).orElseGet(()-> BigDecimal.ZERO);

        return sequenceDetected;
    }
}
