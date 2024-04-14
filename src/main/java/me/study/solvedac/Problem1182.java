package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Problem1182 implements CodingTest {
    static int s;
    static int n;
    static int[] source;
    private static int[] memory;
    static int result = 0;
    private static final int EMPTY_VALUE = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] source1 = reader.readLine().split(" ");
        n = Integer.parseInt(source1[0]);
        s = Integer.parseInt(source1[1]);
        source = new int[n];

        String[] source2 = reader.readLine().split(" ");
        for (int i = 0; i < source2.length; i++) {
            source[i] = Integer.parseInt(source2[i]);
        }

        writer.write(String.valueOf(solve()));
        writer.close();
        reader.close();
    }

    static int solve() {
        memory = new int[n];
        Arrays.fill(memory, EMPTY_VALUE);
        recursive(-1);
        return result;
    }

    private static void recursive(int currentIndex) {
        if (currentIndex == n - 1) {
            if (sum() == s) {
                result++;
            }
        } else {
            int nextIndex = currentIndex + 1;
            memory[nextIndex] = source[nextIndex];
            recursive(nextIndex);
            memory[nextIndex] = EMPTY_VALUE;
            recursive(nextIndex);
        }
    }

    private static int sum() {
        int result = EMPTY_VALUE;
        for (int i : memory) {
            if (i != EMPTY_VALUE) {
                if (result == EMPTY_VALUE) {
                    result = 0;
                }
                result += i;
            }
        }
        return result;
    }

    @Override
    public String getTimeComplexity() {
        // 완전 탐색이기 때문에 주어진 순열의 부분순열 개수와 같음
        return "O(2^N)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N)";
    }

    @Override
    public String getPage() {
        return "https://www.acmicpc.net/problem/1182";
    }
}
