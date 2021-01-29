package com.xmen.dnasentinel.services.procesors.impl;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.xmen.dnasentinel.command.DNAAnalizerCommand;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.utils.DNAAnalyzerValidator;

@Component("verticalDNAAnalyzer")
@Slf4j
public class VerticalDNAAnalyzer implements DNAAnalizerCommand<DNASequence, BigDecimal> {

    @Override
    public BigDecimal analyze(DNASequence dnaSequence) {
        Map<Integer, String> sequenceToVerticalAnalysis = new HashMap<>();
        dnaSequence.getSequences().stream()
                .forEach(sequence -> {
                    final int len = sequence.length();
                    for (int index = 0; index < len; index++) {
                        String part = sequenceToVerticalAnalysis.getOrDefault(index,"")
                                .concat(String.valueOf(sequence.charAt(index)));
                        sequenceToVerticalAnalysis.put(index,part);
                    }
                });

        int matches = sequenceToVerticalAnalysis.values()
                .stream()
                .filter(DNAAnalyzerValidator::isMutantDNA)
                .collect(Collectors.toList()).size();
        return BigDecimal.valueOf(matches);
    }
}
