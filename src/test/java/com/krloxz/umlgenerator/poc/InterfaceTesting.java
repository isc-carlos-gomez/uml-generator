package com.krloxz.umlgenerator.poc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class InterfaceTesting {

    interface IterableTest {

        Iterable<?> newInstance();

        @Test
        default void hasNext() {
            assertThat(newInstance().iterator().hasNext(), is(false));
        }

    }

    interface CollectionTest {

        Collection<?> newInstance();

        @Test
        default void empty() {
            assertThat(newInstance().isEmpty(), is(true));
        }
    }

    static class HashSetTest implements IterableTest, CollectionTest {

        @Test
        void test() {

        }

        @Override
        public HashSet<?> newInstance() {
            return new HashSet<>();
        }
    }
}
