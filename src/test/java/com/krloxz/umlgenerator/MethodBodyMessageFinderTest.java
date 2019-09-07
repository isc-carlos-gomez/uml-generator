package com.krloxz.umlgenerator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javassist.CannotCompileException;
import javassist.expr.MethodCall;

class MethodBodyMessageFinderTest {

    @Test
    void shouldFindSyncCallAndReplyMessagesOnMethodCall() throws CannotCompileException {
        final MethodCall methodCall = mock(MethodCall.class);
        final Message syncMessage = mock(Message.class);
        final Message replyMessage = mock(Message.class);
        final MessageFactory messageFactory = mock(MessageFactory.class);
        when(messageFactory.createSyncMessage(methodCall)).thenReturn(syncMessage);
        when(messageFactory.createReplyMessage(methodCall)).thenReturn(replyMessage);

        final Predicate<Message> filter = mock(Predicate.class);

        final MethodBodyMessageFinder finder = new MethodBodyMessageFinder(filter, messageFactory);
        finder.edit(methodCall);
        assertThat(finder.getFoundMessages(), contains(syncMessage, replyMessage));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void shouldFilterMessagesOnMethodCall() throws CannotCompileException {
        final MethodCall methodCall = mock(MethodCall.class);
        final Message syncMessage = mock(Message.class);
        final Message replyMessage = mock(Message.class);
        final MessageFactory messageFactory = mock(MessageFactory.class);
        when(messageFactory.createSyncMessage(methodCall)).thenReturn(syncMessage);
        when(messageFactory.createReplyMessage(methodCall)).thenReturn(replyMessage);

        final Predicate<Message> filter = mock(Predicate.class);
        when(filter.test(syncMessage)).thenReturn(true);

        final MethodBodyMessageFinder finder = new MethodBodyMessageFinder(filter, messageFactory);
        finder.edit(methodCall);
        assertThat(finder.getFoundMessages(), is(empty()));
    }

    public void shouldFindMessagesInCalledMethodBody() throws CannotCompileException {
        final MethodCall methodCall = mock(MethodCall.class);
        final Message syncMessage = mock(Message.class);
        final Message replyMessage = mock(Message.class);
        final MessageFactory messageFactory = mock(MessageFactory.class);
        // when(messageFactory.createSyncMessage(methodCall)).thenReturn(syncMessage);
        // when(messageFactory.createReplyMessage(methodCall)).thenReturn(replyMessage);

        final Predicate<Message> filter = mock(Predicate.class);

        final MethodBodyMessageFinderFactory finderFactory = mock(MethodBodyMessageFinderFactory.class);

        final MethodBodyMessageFinder finder = new MethodBodyMessageFinder(filter, messageFactory);
        finder.edit(methodCall);
        assertThat(finder.getFoundMessages(), contains(syncMessage, replyMessage));

    }

}
