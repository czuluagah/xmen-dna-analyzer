package com.xmen.dnasentinel.services.procesors.impl;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.xmen.dnasentinel.command.DNAAnalizerCommand;
import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.utils.DNAAnalyzerValidator;

@Component("horizontalDNAAnalyzer")
@Slf4j
public class HorizontalDNAAnalyzer implements DNAAnalizerCommand<DNASequence, BigDecimal> {

    @Override
    public BigDecimal analyze(DNASequence dnaSequence) {
        log.info("=============== Running HorizontalDNAAnalyzer ================");
        int size = dnaSequence.getSequences().stream()
                .filter(DNAAnalyzerValidator::isMutantDNA)
                .collect(Collectors.toList())
                .size();
        return BigDecimal.valueOf(size);
    }
}
