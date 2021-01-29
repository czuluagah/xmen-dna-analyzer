package com.xmen.dnasentinel.command;

public interface DNAAnalizerCommand<REQUEST,RESPONSE> {

    public RESPONSE analyze(REQUEST request);
}
