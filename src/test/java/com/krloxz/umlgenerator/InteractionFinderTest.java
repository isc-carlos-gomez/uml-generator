package com.krloxz.umlgenerator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

class InteractionFinderTest {

    @Test
    void shouldFindInteractionWhenOperationIsValid() {
        final InteractionFinder finder = new InteractionFinder();
        final Operation operation = new Operation();
        final Interaction expected = new Interaction(operation);

        assertThat(finder.find(operation), is(expected));
    }

    @Test
    void shouldFindSynchCallMessagesWhenOperationContainsMethodCalls() {

    }

    @Test
    void shouldFindReplyMessagesWhenOperationContainsMethodCalls() {

    }

    @Test
    void shouldFindCreationlMessagesWhenOperationContainsConstructorCalls() {

    }

    void shouldFailWhenOperationTypeIsNotSupported() {

    }

    void shouldFailWhenOperationIsNotFound() {

    }

    @Test
    void test() {
        System.out.println(Integer.toBinaryString(64));
        System.out.println((64 >> 2) + ": " + Integer.toBinaryString(64 >> 2));
        System.out.println((64 << 2) + ": " + Integer.toBinaryString(64 << 2));
        System.out.println((64 >>> 2) + ": " + Integer.toBinaryString(64 >>> 2));
        System.out.println(Integer.toBinaryString(-64));
        System.out.println((-64 >> 2) + ": " + Integer.toBinaryString(-64 >> 2));
        System.out.println((-64 << 2) + ": " + Integer.toBinaryString(-64 << 2));
        System.out.println((-64 >>> 2) + ": " + Integer.toBinaryString(-64 >>> 2));
    }

}
