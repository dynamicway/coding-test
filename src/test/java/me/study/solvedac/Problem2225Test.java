package me.study.solvedac;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2225Test {

    @Test
    void test1() {
        assertThat(Problem2225.solve(20, 2)).isEqualTo(21);
    }

    @Test
    void test2() {
        assertThat(Problem2225.solve(6, 4)).isEqualTo(84);
    }

    @Test
    void test3() {
        assertThat(Problem2225.solve(200, 200)).isEqualTo(753387060);
    }

}