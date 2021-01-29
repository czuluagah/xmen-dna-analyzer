package com.xmen.dnasentinel.repositories.dcouments;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "dna_analysis")
@Data
@Builder
public class DnaDcoument {

    @Id
    private String id;
    private List<String> dnaSecuence;
    private BigDecimal numberOfMatches;
    private boolean isMutant;
}
