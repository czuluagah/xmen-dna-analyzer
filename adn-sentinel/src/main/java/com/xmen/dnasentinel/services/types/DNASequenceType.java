package com.xmen.dnasentinel.services.types;

import lombok.Getter;

public enum DNASequenceType {
    A_SEQUENCE("AAAA"),
    C_SEQUENCE("CCCC"),
    T_SEQUENCE("TTTT"),
    G_SEQUENCE("GGGG");

    @Getter
    private String type;

    private DNASequenceType(String type){
        this.type = type;
    }

}
