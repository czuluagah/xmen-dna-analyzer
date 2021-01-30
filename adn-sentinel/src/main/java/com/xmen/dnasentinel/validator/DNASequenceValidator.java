package com.xmen.dnasentinel.validator;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.xmen.dnasentinel.model.DNASequence;

import static com.xmen.dnasentinel.utils.Constants.DNA_SEQUENCE_PATTERN;

public class DNASequenceValidator implements ConstraintValidator<DNASequenceValid, DNASequence> {

    @Override
    public boolean isValid(DNASequence dnaSequence, ConstraintValidatorContext context) {

        String flatAdnSequence =
                Optional.ofNullable(dnaSequence.getSequences())
                .orElse(new ArrayList<>())
                .stream().reduce(String::concat).orElseGet(()->"INVALID_SEQUENCE");

        return DNA_SEQUENCE_PATTERN.matcher(flatAdnSequence).matches();
    }
}
