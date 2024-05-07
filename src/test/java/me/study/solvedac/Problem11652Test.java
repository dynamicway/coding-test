package me.study.solvedac;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem11652Test {

    @Test
    void test1() {
        assertThat(Problem11652.solve(new long[]{1, 2, 1, 2, 1}))
                .isEqualTo(1);
    }

    @Test
    void test2() {
        assertThat(Problem11652.solve(new long[]{1, 2, 1, 2, 1, 2}))
                .isEqualTo(1);
    }

    @Test
    void test3() {
        assertThat(Problem11652.solve(new long[]{1, 2, 1, 2, 1, 2}))
                .isEqualTo(1);
    }

    @Test
    void test4() {
        assertThat(Problem11652.solve(new long[]{1, 2, 3, 4, 5, 5}))
                .isEqualTo(5);
    }

    @Test
    void test5() {
        assertThat(Problem11652.solve(new long[]{1, 1, 2, 2, 3, 4, 5, 5}))
                .isEqualTo(1);
    }

    @Test
    void test6() {
        assertThat(Problem11652.solve(new long[]{1, 1, 2, 3, 4, 5, 5}))
                .isEqualTo(1);
    }

    @Test
    void test7() {
        assertThat(Problem11652.solve(new long[]{Long.MIN_VALUE, Long.MIN_VALUE, 1, 2, 3, 4, 5, Long.MAX_VALUE, Long.MAX_VALUE}))
                .isEqualTo(Long.MIN_VALUE);
    }

    @Test
    void test8() {
        assertThat(Problem11652.solve(new long[]{Long.MIN_VALUE, Long.MIN_VALUE, Long.MAX_VALUE, Long.MAX_VALUE}))
                .isEqualTo(Long.MIN_VALUE);
    }

    @Test
    void test9() {
        assertThat(Problem11652.solve(new long[]{Long.MIN_VALUE}))
                .isEqualTo(Long.MIN_VALUE);
    }

    @Test
    void test10() {
        assertThat(Problem11652.solve(new long[]{0, 0, 0, 0, 1}))
                .isEqualTo(0);
    }

    @Test
    void test11() {
        assertThat(Problem11652.solve(new long[]{-5, -5, -2, -12, -2}))
                .isEqualTo(-5);
    }

    @Test
    void test12() {
        assertThat(Problem11652.solve(new long[]{1, 1, 1, 1, 2, 3, 3, 3, 3, 3}))
                .isEqualTo(3);
    }

}
