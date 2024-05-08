package me.study.solvedac;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class Problem20291Test {

    @Test
    void test1() {
        assertThat(Problem20291.solve(List.of("sbrus.txt",
                                              "spc.spc",
                                              "acm.icpc",
                                              "korea.icpc",
                                              "sample.txt",
                                              "hello.world",
                                              "sogang.spc",
                                              "example.txt")))
                .containsExactly(new Entry("icpc", new AtomicInteger(2)),
                                 new Entry("spc", new AtomicInteger(2)),
                                 new Entry("txt", new AtomicInteger(3)),
                                 new Entry("world", new AtomicInteger(1)));
    }

    private static class Entry implements Map.Entry<String, AtomicInteger> {
        private final String key;
        private final AtomicInteger value;

        private Entry(String key, AtomicInteger value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public AtomicInteger getValue() {
            return value;
        }

        @Override
        public AtomicInteger setValue(AtomicInteger value) {
            return null;
        }
    }

}
