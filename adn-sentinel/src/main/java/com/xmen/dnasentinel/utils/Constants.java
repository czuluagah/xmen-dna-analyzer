package com.xmen.dnasentinel.utils;

import java.util.regex.Pattern;

public final class Constants {

    private Constants(){}

    public static final String MUTANT_RESOURCE = "/mutant";
    public static final String STATS_RESOURCE = "/stats";
    public static final String HUMAN = "HUMAN";
    public static final String MUTANT = "MUTANT";
    public static final String MUTANT_VALID_SEQUENCE_LETTERS = "^[ATGC]+$";
    public static final Pattern DNA_SEQUENCE_PATTERN = Pattern.compile(MUTANT_VALID_SEQUENCE_LETTERS);
}
