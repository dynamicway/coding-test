package me.study.solvedac;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2744Test {

    @ParameterizedTest
    @CsvSource({"WrongAnswer, wRONGaNSWER",
                "aBcD, AbCd",
                "aAAa, AaaA",
                "AAA, aaa",
                "aaa, AAA",
                "aBa, AbA"})
    void test(String source, String expectedResult) {
        assertThat(Problem2744.changeCase(source)).isEqualTo(expectedResult);
    }

}
