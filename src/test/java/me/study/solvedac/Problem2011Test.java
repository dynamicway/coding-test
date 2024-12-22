package me.study.solvedac;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2011Test {

    @Test
    void test1() {
        assertThat(Problem2011.solve("1")).isEqualTo(1);
    }

    @Test
    void test2() {
        assertThat(Problem2011.solve("11")).isEqualTo(2);
    }

    @Test
    void test3() {
        assertThat(Problem2011.solve("0")).isEqualTo(0);
    }

    @Test
    void test4() {
        assertThat(Problem2011.solve("25114")).isEqualTo(6);
    }

    @Test
    void test5() {
        assertThat(Problem2011.solve("1111111111")).isEqualTo(89);
    }

    @Test
    void test7() {
        assertThat(Problem2011.solve("333")).isEqualTo(1);
    }

    @Test
    void test8() {
        assertThat(Problem2011.solve("331")).isEqualTo(1);
    }

    @Test
    void test9() {
        assertThat(Problem2011.solve("313")).isEqualTo(2);
    }

    @Test
    void test10() {
        assertThat(Problem2011.solve("999")).isEqualTo(1);
    }

    @Test
    void test11() {
        assertThat(Problem2011.solve("2121")).isEqualTo(5);
    }

    @Test
    void test12() {
        assertThat(Problem2011.solve("1010")).isEqualTo(1);
    }

    @Test
    void test13() {
        assertThat(Problem2011.solve("100")).isEqualTo(0);
    }

    @Test
    void test14() {
        assertThat(Problem2011.solve("3010")).isEqualTo(0);
    }

    @Test
    void test15() {
        assertThat(Problem2011.solve("00")).isEqualTo(0);
    }

    @Test
    void test16() {
        assertThat(Problem2011.solve("01")).isEqualTo(0);
    }

    @Test
    void test17() {
        assertThat(Problem2011.solve("1010101010")).isEqualTo(1);
    }

    @Test
    void test18() {
        assertThat(Problem2011.solve("202020")).isEqualTo(1);
    }

    @Test
    void test19() {
        assertThat(Problem2011.solve("30")).isEqualTo(0);
    }

    @Test
    void test20() {
        assertThat(Problem2011.solve("20")).isEqualTo(1);
    }

    @Test
    void test21() {
        assertThat(Problem2011.solve("21")).isEqualTo(2);
    }

    @Test
    void test22() {
        assertThat(Problem2011.solve("1090")).isEqualTo(0);
    }

    @Test
    void test23() {
        assertThat(Problem2011.solve("1110")).isEqualTo(2);
    }

    @Test
    void test6() {
        String n = "";
        for (int i = 0; i < 5000; i++) {
            n += "1";
        }

        assertThat(Problem2011.solve(n)).isEqualTo(470626);
    }

}