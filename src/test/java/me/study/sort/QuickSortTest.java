package me.study.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

class QuickSortTest {

    @Test
    void test1() {
        assertThat(QuickSort.sort(List.of(1L))).isEqualTo(List.of(1L));
    }

    @Test
    void test2() {
        assertThat(QuickSort.sort(List.of(1L, 2L, 3L))).isEqualTo(List.of(1L, 2L, 3L));
    }

    @Test
    void test3() {
        assertThat(QuickSort.sort(List.of(3L, 2L, 1L))).isEqualTo(List.of(1L, 2L, 3L));
    }

    @Test
    void test4() {
        assertThat(QuickSort.sort(List.of(4L, 3L, 2L, 1L))).isEqualTo(List.of(1L, 2L, 3L, 4L));
    }

    @Test
    void test5() {
        assertThat(QuickSort.sort(List.of(4L, 3L, 5L, 2L, 1L))).isEqualTo(List.of(1L, 2L, 3L, 4L, 5L));
    }

    @Test
    void test6() {
        List<Long> expected = LongStream.range(1, 1000000)
                .boxed()
                .toList();
        ArrayList<Long> source = new ArrayList<>(expected);
        Collections.shuffle(source);

        assertThat(QuickSort.sort(source)).isEqualTo(expected);
    }


}