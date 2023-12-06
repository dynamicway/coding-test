package me.study.solvedac;

import me.study.CodingTest;

import java.util.ArrayDeque;

class Problem1607 implements CodingTest {

    static int find(int n, int k) {
        if (n > k)
            return n - k;

        boolean[] visits = new boolean[100001];
        int currentStep = 0;
        ArrayDeque<Integer> locationHolder = new ArrayDeque<>();
        ArrayDeque<Integer> nextStepLocationHolder = new ArrayDeque<>();
        locationHolder.add(n);
        while (true) {
            for (final Integer location : locationHolder) {
                if (visits[location])
                    continue;
                if (location == k)
                    return currentStep;
                visits[location] = true;
                addToNextStepLocationHolder(location, visits, nextStepLocationHolder);
            }
            currentStep++;
            locationHolder = nextStepLocationHolder;
            nextStepLocationHolder = new ArrayDeque<>();
        }
    }

    private static void addToNextStepLocationHolder(Integer location, boolean[] visits, ArrayDeque<Integer> nextStepLocationHolder) {
        int plus = location + 1;
        if (plus <= 100000 && !visits[plus]) {
            nextStepLocationHolder.add(plus);
        }
        int multiple = location * 2;
        if (multiple <= 100000 && !visits[multiple]) {
            nextStepLocationHolder.add(multiple);
        }
        int minus = location - 1;
        if (minus >= 0 && !visits[minus]) {
            nextStepLocationHolder.add(minus);
        }
    }

    @Override
    public String getTimeComplexity() {
        return "O(N)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N)";
    }

    @Override
    public String getPage() {
        return "https://www.acmicpc.net/problem/1697";
    }
}
