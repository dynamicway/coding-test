package me.study.solvedac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem15651Test {

    @Test
    void test1() {
        assertThat(Problem15651.solve(1, 1))
                .isEqualTo(List.of("1"));
    }

    @Test
    void test2() {
        assertThat(Problem15651.solve(2, 1))
                .isEqualTo(List.of("1", "2"));
    }

    @Test
    void test3() {
        assertThat(Problem15651.solve(3, 1))
                .isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void test4() {
        assertThat(Problem15651.solve(2, 2))
                .isEqualTo(List.of("1 1", "1 2", "2 1", "2 2"));
    }

    @Test
    void test5() {
        assertThat(Problem15651.solve(4, 2))
                .isEqualTo(List.of(
                        "1 1",
                        "1 2",
                        "1 3",
                        "1 4",
                        "2 1",
                        "2 2",
                        "2 3",
                        "2 4",
                        "3 1",
                        "3 2",
                        "3 3",
                        "3 4",
                        "4 1",
                        "4 2",
                        "4 3",
                        "4 4"
                                  ));
    }

}
