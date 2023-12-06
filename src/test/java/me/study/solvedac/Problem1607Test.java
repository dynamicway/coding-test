package me.study.solvedac;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1607Test {

    @Test
    void it_takes_the_difference_between_n_and_k_when_n_is_bigger_than_k() {
        assertThat(Problem1607.find(100, 10)).isEqualTo(90);
    }

    @Test
    void it_takes_zero_when_n_is_equal_to_k() {
        assertThat(Problem1607.find(1, 1)).isZero();
    }

    @ParameterizedTest
    @CsvSource({"5, 17, 4",
                "2, 4, 1",
                "3, 4, 1",
                "4, 10, 2",
                "1, 100000, 21",
                "10, 30, 5",
    })
    void find(int n, int k, int result) {
        assertThat(Problem1607.find(n, k)).isEqualTo(result);
    }

}
