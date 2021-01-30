package com.xmen.dnasentinel.validator;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.xmen.dnasentinel.model.DNASequence;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DNASequenceValidatorTest {

    @Test
    public void whenDNASequenceIsInvalid(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTX"));
        DNASequenceValidator validator = new DNASequenceValidator();
        Boolean actual = validator.isValid(dnaSequence, null);
        assertEquals(false, actual);
    }

    @Test
    public void whenDNASequenceIsValid(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"));
        DNASequenceValidator validator = new DNASequenceValidator();
        Boolean actual = validator.isValid(dnaSequence, null);
        assertEquals(true, actual);
    }

    @Test
    public void whenDNASequenceIsNull(){
        DNASequence dnaSequence = new DNASequence();
        dnaSequence.setSequences(null);
        DNASequenceValidator validator = new DNASequenceValidator();
        Boolean actual = validator.isValid(dnaSequence, null);
        assertEquals(false, actual);
    }
}
