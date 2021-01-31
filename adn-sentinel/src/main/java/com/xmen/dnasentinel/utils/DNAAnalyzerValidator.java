package com.xmen.dnasentinel.utils;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.function.Predicate;


import static com.xmen.dnasentinel.services.types.DNASequenceType.A_SEQUENCE;
import static com.xmen.dnasentinel.services.types.DNASequenceType.C_SEQUENCE;
import static com.xmen.dnasentinel.services.types.DNASequenceType.G_SEQUENCE;
import static com.xmen.dnasentinel.services.types.DNASequenceType.T_SEQUENCE;

@UtilityClass
public class DNAAnalyzerValidator {

    public static final Predicate<String> IS_MUTANT_A_SEQUENCE = sequence ->
            sequence.contains(A_SEQUENCE.getType());

    public static final Predicate<String> IS_MUTANT_C_SEQUENCE = sequence ->
            sequence.contains(C_SEQUENCE.getType());

    public static final Predicate<String> IS_MUTANT_T_SEQUENCE = sequence ->
            sequence.contains(T_SEQUENCE.getType());

    public static final Predicate<String> IS_MUTANT_G_SEQUENCE = sequence ->
            sequence.contains(G_SEQUENCE.getType());


    public static final Predicate<BigDecimal> IS_MUTANT_DNA = numberOfSequencesFound ->
            BigDecimal.ONE.compareTo(numberOfSequencesFound) < 0;


    public static boolean isMutantDNA(final String sequence) {
        return IS_MUTANT_A_SEQUENCE.or(IS_MUTANT_C_SEQUENCE)
                .or(IS_MUTANT_G_SEQUENCE)
                .or(IS_MUTANT_T_SEQUENCE)
                .test(sequence);
    }
}
