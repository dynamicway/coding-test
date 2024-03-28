package me.study.solvedac;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem9663Test {

    @Test
    void test1() {
        assertThat(Problem9663.solve(1)).isOne();
    }

    @Test
    void test2() {
        assertThat(Problem9663.solve(2)).isZero();
    }

    @Test
    void test3() {
        assertThat(Problem9663.solve(3)).isZero();
    }

    @Test
    void test4() {
        assertThat(Problem9663.solve(4)).isEqualTo(2);
    }

    @Test
    void test5() {
        assertThat(Problem9663.solve(8)).isEqualTo(92);
    }

}
