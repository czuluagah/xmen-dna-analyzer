package com.xmen.dnasentinel.services.procesors.impl;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.xmen.dnasentinel.command.DNAAnalizerCommand;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.utils.DNAAnalyzerValidator;

@Component("verticalDNAAnalyzer")
@Slf4j
public class VerticalDNAAnalyzer implements DNAAnalizerCommand<DNASequence, BigDecimal> {
    private Map<Integer, StringBuilder> sequenceToVerticalAnalysis = null;
    @Override
    public BigDecimal analyze(DNASequence dnaSequence) {
        log.info("VerticalDNAAnalyzer");
        try {
            sequenceToVerticalAnalysis = new HashMap<>();
            dnaSequence.getSequences().stream()
                    .forEach(sequence -> {
                        final int len = sequence.length();
                        for (int index = 0; index < len; index++) {
                            StringBuilder part = sequenceToVerticalAnalysis.getOrDefault(index, new StringBuilder(""))
                                    .append(sequence.charAt(index));
                            sequenceToVerticalAnalysis.put(index, part);
                        }
                    });

            return BigDecimal.valueOf(sequenceToVerticalAnalysis.values()
                    .stream()
                    .map(StringBuilder::toString)
                    .filter(DNAAnalyzerValidator::isMutantDNA).count());
        } finally {
            sequenceToVerticalAnalysis = null;
        }
    }
}
