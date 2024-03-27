package me.study.solvedac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem14888Test {

    @Test
    void test1() {
        assertThat(Problem14888.solve(
                List.of(5, 6),
                List.of(0, 0, 1, 0)))
                .isEqualTo(List.of(30, 30));
    }

    @Test
    void test2() {
        assertThat(Problem14888.solve(
                List.of(3, 4, 5),
                List.of(1, 0, 1, 0)))
                .isEqualTo(List.of(35, 17));
    }

    @Test
    void test3() {
        assertThat(Problem14888.solve(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 1, 1, 1)))
                .isEqualTo(List.of(54, -24));
    }

}
