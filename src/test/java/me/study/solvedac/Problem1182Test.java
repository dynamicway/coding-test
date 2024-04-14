package me.study.solvedac;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1182Test {

    @Test
    void test1() {
        Problem1182.n = 5;
        Problem1182.s = 0;
        Problem1182.source = new int[]{-7, -3, -2, 5, 8};

        assertThat(Problem1182.solve()).isOne();
    }

    @Test
    void test2() {
        Problem1182.n = 3;
        Problem1182.s = 3;
        Problem1182.source = new int[]{-1, 4, 0};

        assertThat(Problem1182.solve()).isEqualTo(2);
    }

}
