package com.xmen.dnasentinel.resources;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.xmen.dnasentinel.model.DNAAnalysisStats;
import com.xmen.dnasentinel.resources.impl.MutantStatsResourceImpl;
import com.xmen.dnasentinel.services.DNASentinelService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


public class MutantStatsResourceTest {

    private MutantStatsResourceImpl rest;

    @Mock
    private DNASentinelService service;

    public MutantStatsResourceTest(){
        service = Mockito.mock(DNASentinelService.class);
        rest = new MutantStatsResourceImpl(service);
    }

    @Test
    public void testAnalysisStats(){
        DNAAnalysisStats expected = DNAAnalysisStats.builder()
                .humans(0)
                .mutants(10)
                .numberOfAnalusis(10)
                .ratio(100).build();

        when(service.getStats()).thenReturn(DNAAnalysisStats.builder()
                .humans(0)
                .mutants(10)
                .numberOfAnalusis(10)
                .ratio(100).build());
        ResponseEntity<DNAAnalysisStats> actual = rest.stats();
        assertNotNull(actual);
        assertEquals(expected,actual.getBody());
    }

}
