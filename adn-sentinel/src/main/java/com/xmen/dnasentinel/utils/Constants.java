package com.xmen.dnasentinel.utils;

import java.util.regex.Pattern;

public final class Constants {

    public final static String MUTANT_RESOURCE = "/mutant";
    public final static String STATS_RESOURCE = "/stats";
    public final static String HUMAN = "HUMAN";
    public final static String MUTANT = "MUTANT";
    public final static String MUTANT_VALID_SEQUENCE_LETTERS = "^[ATGC]+$";
    public final static Pattern DNA_SEQUENCE_PATTERN = Pattern.compile(MUTANT_VALID_SEQUENCE_LETTERS);
}
