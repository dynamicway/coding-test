package me.study.sort;

import java.util.ArrayList;
import java.util.List;

class QuickSort {
    private QuickSort() {
    }

    public static List<Long> sort(List<Long> source) {
        if (source.size() < 4) {
            return selectionSort(new ArrayList<>(source));
        }
        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();
        long pivot = source.get(0);
        for (int i = 1; i < source.size(); i++) {
            if (pivot > source.get(i)) {
                left.add(source.get(i));
            } else {
                right.add(source.get(i));
            }
        }
        List<Long> result = new ArrayList<>();
        result.addAll(sort(left));
        result.add(pivot);
        result.addAll(sort(right));
        return result;
    }

    private static List<Long> selectionSort(List<Long> source) {
        int size = source.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (source.get(i) > source.get(j)) {
                    long temp = source.get(i);
                    source.set(i, source.get(j));
                    source.set(j, temp);
                }
            }
        }
        return source;
    }
}
