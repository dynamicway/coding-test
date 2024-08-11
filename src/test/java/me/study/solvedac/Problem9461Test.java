package me.study.solvedac;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Problem9461Test {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 1",
            "6, 3",
            "12, 16",
            "100, 888855064897"})
    void test1(int n, long expected) {
        assertThat(Problem9461.solve(n)).isEqualTo(expected);
    }


}