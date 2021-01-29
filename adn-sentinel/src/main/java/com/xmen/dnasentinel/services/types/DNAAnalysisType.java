package com.xmen.dnasentinel.services.types;

import java.util.Arrays;
import java.util.List;

public enum DNAAnalysisType {
    VERTICAL_ANALYSIS,
    HORIZONTAL_ANALYSIS,
    DIAGONAL_ANALYSIS,
    DIAGONAL_STRAIT_ANALYSIS,
    DIAGONAL_INVERSE_ANALYSIS;

    public static List<DNAAnalysisType> getDiagonalMethod() {
        return Arrays.asList(DIAGONAL_STRAIT_ANALYSIS,DIAGONAL_INVERSE_ANALYSIS);
    }

    public static List<DNAAnalysisType> getAnalysisMethods() {
        return Arrays.asList(VERTICAL_ANALYSIS,
                HORIZONTAL_ANALYSIS,
                DIAGONAL_ANALYSIS);
    }
}
