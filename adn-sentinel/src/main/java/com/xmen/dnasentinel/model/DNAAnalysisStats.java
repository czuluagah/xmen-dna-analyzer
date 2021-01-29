package com.xmen.dnasentinel.model;

import lombok.Data;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class DNAAnalysisStats {
    @JsonProperty("count_mutant_dna")
    private BigDecimal mutants;

    @JsonProperty("count_human_dna")
    private BigDecimal humans;

    private BigDecimal ratio;
}
