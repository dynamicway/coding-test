package me.study.solvedac;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1157Test {

    @ParameterizedTest
    @CsvSource({"Mississipi, ?",
                "zZa, Z",
                "z, Z",
                "baaa, A",
                "'', ?"})
    void test(String source, String result) {
        assertThat(Problem1157.solve(source)).isEqualTo(result);
    }

}
