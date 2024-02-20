package me.study.solvedac;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1919Test {

    @ParameterizedTest
    @CsvSource({"aabbcc, xxyybb, 8",
                "dared, bread, 2," +
                "abc, cba, 0," +
                "aaa, a, 2"})
    void test(String source1, String source2, int expectedResult) {
        assertThat(Problem1919.solve(source1, source2)).isEqualTo(expectedResult);
    }

}
