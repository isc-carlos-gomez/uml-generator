package com.krloxz.umlgenerator;

public class InteractionFinder {

    public Interaction find(final Operation operation) {
        return new Interaction(operation);
    }

}
