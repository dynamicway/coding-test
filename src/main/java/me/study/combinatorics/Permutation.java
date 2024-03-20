package me.study.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permutation<T> {
    private final List<T> elements;
    private final List<List<T>> generatedPermutations = new ArrayList<>();

    Permutation(List<T> elements) {
        this.elements = elements;
    }

    List<List<T>> permute() {
        for (int i = 0; i < elements.size(); i++) {
            boolean[] visitedIndexes = new boolean[elements.size()];
            visitedIndexes[i] = true;
            recursive(List.of(elements.get(i)), visitedIndexes);
        }
        return generatedPermutations;
    }

    private void recursive(List<T> currentElements, boolean[] visitedIndexes) {
        if (currentElements.size() == elements.size()) {
            generatedPermutations.add(currentElements);
        } else {
            for (int i = 0; i < visitedIndexes.length; i++) {
                if (!visitedIndexes[i]) {
                    boolean[] nextVisitedIndexes = Arrays.copyOf(visitedIndexes, visitedIndexes.length);
                    nextVisitedIndexes[i] = true;
                    ArrayList<T> nextElements = new ArrayList<>(currentElements);
                    nextElements.add(elements.get(i));
                    recursive(nextElements, nextVisitedIndexes);
                }
            }
        }
    }

}
