package com.xmen.dnasentinel.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
public class DNAAnalysisStats {

    @JsonProperty("numberOfAnalysis")
    private Integer numberOfAnalusis;

    @JsonProperty("count_mutant_dna")
    private Integer mutants;

    @JsonProperty("count_human_dna")
    private Integer humans;

    private double ratio;
}
