package me.study.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RunningSumOf1DArrayTest {

    public static Stream<Arguments> running_sum() {
        return Stream.of(arguments(new int[]{1, 2, 3, 4}, new int[]{1, 3, 6, 10}),
                         arguments(new int[]{1, 1, 1, 1, 1}, new int[]{1, 2, 3, 4, 5}),
                         arguments(new int[]{3, 1, 2, 10, 1}, new int[]{3, 4, 6, 16, 17}),
                         arguments(new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}),
                         arguments(new int[]{1, -1, 1, -1}, new int[]{1, 0, 1, 0}),
                         arguments(new int[]{1, -1, -1, -1}, new int[]{1, 0, -1, -2}),
                         arguments(new int[]{}, new int[]{}));
    }

    @ParameterizedTest
    @MethodSource
    void running_sum(int[] nums, int[] result) {
        assertThat(RunningSumOf1DArray.runningSum(nums)).containsExactly(result);
    }

}
