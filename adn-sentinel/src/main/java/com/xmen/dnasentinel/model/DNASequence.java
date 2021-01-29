package com.xmen.dnasentinel.model;

import lombok.Data;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xmen.dnasentinel.validator.DNASequenceValid;

@Data
@DNASequenceValid
public class DNASequence {

    @JsonProperty("dna")
    @Valid
    @NotNull
    private List<String> sequences;
}
