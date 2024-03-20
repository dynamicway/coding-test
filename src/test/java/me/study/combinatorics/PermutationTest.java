package me.study.combinatorics;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PermutationTest {

    @Test
    void when_there_are_no_element() {
        Permutation<Integer> sut = new Permutation<>(List.of());

        assertThat(sut.permute()).isEmpty();
    }

    @Test
    void when_there_is_only_one_element() {
        Permutation<Integer> sut = new Permutation<>(List.of(1));

        assertThat(sut.permute())
                .containsExactlyInAnyOrder(List.of(1));
    }

    @Test
    void when_there_are_two_elements() {
        Permutation<Integer> sut = new Permutation<>(List.of(1, 2));

        assertThat(sut.permute())
                .containsExactlyInAnyOrder(List.of(1, 2), List.of(2, 1));
    }

    @Test
    void when_there_are_three_elements() {
        Permutation<Integer> sut = new Permutation<>(List.of(1, 2, 3));

        assertThat(sut.permute())
                .containsExactlyInAnyOrder(List.of(1, 2, 3),
                                           List.of(1, 3, 2),
                                           List.of(2, 1, 3),
                                           List.of(2, 3, 1),
                                           List.of(3, 1, 2),
                                           List.of(3, 2, 1));
    }

}
