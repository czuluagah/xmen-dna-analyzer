package com.xmen.dnasentinel.utils;

import java.util.regex.Pattern;

public final class Constants {

    public final static String MUTANT_RESOURCE = "/mutant";
    public final static String MUTANT_VALID_SEQUENCE_LETTERS = "^[ATGC]+$";
    public final static Pattern DNA_SEQUENCE_PATTERN = Pattern.compile(MUTANT_VALID_SEQUENCE_LETTERS);
}
