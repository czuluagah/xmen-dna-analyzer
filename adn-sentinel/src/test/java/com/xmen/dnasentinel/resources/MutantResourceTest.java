package com.xmen.dnasentinel.resources;


import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.xmen.dnasentinel.model.DNASequence;
import com.xmen.dnasentinel.resources.impl.MutantResourceImpl;
import com.xmen.dnasentinel.services.DNASentinelService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class MutantResourceTest {

    private MutantResourceImpl rest;

    @Mock
    private DNASentinelService service;

    public MutantResourceTest(){
        service = Mockito.mock(DNASentinelService.class);
        rest = new MutantResourceImpl(service);
    }

    @Test
    public void whenIsAMutantDNA(){
        DNASequence dnaSequence = new DNASequence();
        ResponseEntity expected = ResponseEntity.ok().build();
        dnaSequence.setSequences(Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"));
        when(service.isMutant(dnaSequence)).thenReturn(Boolean.TRUE);
        ResponseEntity actual = rest.isMutant(dnaSequence);
        assertEquals(expected,actual);
    }

    @Test
    public void whenIsNotAMutantDNA(){
        DNASequence dnaSequence = new DNASequence();
        ResponseEntity expected = ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        dnaSequence.setSequences(Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"));
        when(service.isMutant(dnaSequence)).thenReturn(Boolean.FALSE);
        ResponseEntity actual = rest.isMutant(dnaSequence);
        assertEquals(expected,actual);
    }

    @Test
    public void whenIsAnAlienDNA(){
        DNASequence dnaSequence = new DNASequence();
        ResponseEntity expected = ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        dnaSequence.setSequences(Arrays.asList("ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTX"));
        ResponseEntity actual = rest.isMutant(dnaSequence);
        assertEquals(expected,actual);
    }
}
