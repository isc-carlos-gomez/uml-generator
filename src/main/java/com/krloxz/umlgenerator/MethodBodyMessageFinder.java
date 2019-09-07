package com.krloxz.umlgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class MethodBodyMessageFinder extends ExprEditor {

    private final Predicate<Message> filter;
    private final MessageFactory messageFactory;
    private final List<Message> foundMessages;

    public MethodBodyMessageFinder(final Predicate<Message> filter, final MessageFactory messageFactory) {
        this.filter = filter;
        this.messageFactory = messageFactory;
        this.foundMessages = new ArrayList<>();
    }

    @Override
    public void edit(final MethodCall methodCall) throws CannotCompileException {
        final Message syncMessage = this.messageFactory.createSyncMessage(methodCall);
        if (!this.filter.test(syncMessage)) {
            // build sync message
            // filter sync message
            // add sync message
            // find messages in called method
            // add found messages
            // build reply message
            // add reply message
            this.foundMessages.add(syncMessage);
            this.foundMessages.add(this.messageFactory.createReplyMessage(methodCall));
        }
    }

    public List<Message> getFoundMessages() {
        return this.foundMessages;
    }

}
