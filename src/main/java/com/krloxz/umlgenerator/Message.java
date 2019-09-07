package com.krloxz.umlgenerator;

public class Message {

    private Participant sender;
    private Participant receiver;
    private String name;
    private Type type;

    public enum Type {
        SYNCH_CALL, CREATE_MESSAGE, REPLY
    }

}
