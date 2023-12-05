package me.study.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RichestCustomerWealthTest {

    public static Stream<Arguments> maximum_wealth() {
        return Stream.of(arguments(new int[][]{{1, 2, 3}, {3, 2, 1}}, 6),
                         arguments(new int[][]{{1, 5}, {7, 3}, {3, 5}}, 10),
                         arguments(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}, 17),
                         arguments(new int[][]{{1}}, 1));
    }

    @ParameterizedTest
    @MethodSource
    void maximum_wealth(int[][] accounts, int result) {
        assertThat(RichestCustomerWealth.maximumWealth(accounts)).isEqualTo(result);
    }

}
