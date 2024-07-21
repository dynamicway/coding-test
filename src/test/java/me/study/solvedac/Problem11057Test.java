package me.study.solvedac;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem11057Test {

    @Test
    void test1() {
        assertThat(Problem11057.solve(1)).isEqualTo(10);
    }

    @Test
    void test2() {
        assertThat(Problem11057.solve(2)).isEqualTo(55);
    }

    @Test
    void test3() {
        assertThat(Problem11057.solve(3)).isEqualTo(31485);
    }

    @Test
    void test10() {
        assertThat(Problem11057.solve(1000)).isEqualTo(1464);
    }

}