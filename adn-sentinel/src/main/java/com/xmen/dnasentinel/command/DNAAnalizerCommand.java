package com.xmen.dnasentinel.command;

public interface DNAAnalizerCommand<R,T> {

    T analyze(R request);
}
