package me.study.solvedac;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem1015Test {

    @Test
    void test1() {
        assertThat(Problem1015.solve(new int[]{2, 3, 1}))
                .containsExactly(1, 2, 0);
    }

    @Test
    void test2() {
        assertThat(Problem1015.solve(new int[]{2, 1, 3, 1}))
                .containsExactly(2, 0, 3, 1);
    }

    @Test
    void test3() {
        assertThat(Problem1015.solve(new int[]{4, 1, 6, 1, 3, 6, 1, 4}))
                .containsExactly(4, 0, 6, 1, 3, 7, 2, 5);
    }

    @Test
    void test4() {
        assertThat(Problem1015.solve(new int[]{1, 2, 3, 4, 4, 3, 2, 1}))
                .containsExactly(0, 2, 4, 6, 7, 5, 3, 1);
    }

}