package me.study.solvedac;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2193Test {

    @Test
    void test1() {
        assertThat(Problem2193.solve(3)).isEqualTo(2);
    }

    @Test
    void test2() {
        assertThat(Problem2193.solve(1)).isEqualTo(1);
    }

    @Test
    void test3() {
        assertThat(Problem2193.solve(2)).isEqualTo(1);
    }

    @Test
    void test4() {
        assertThat(Problem2193.solve(4)).isEqualTo(3);
    }

    @Test
    void test5() {
        assertThat(Problem2193.solve(5)).isEqualTo(5);
    }

}