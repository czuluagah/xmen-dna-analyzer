package com.xmen.dnasentinel.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class AnalysisResult {

    private boolean isMutant;
    private BigDecimal numberOfMatches;
}
