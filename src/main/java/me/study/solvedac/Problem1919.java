package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Problem1919 implements CodingTest {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String source1 = reader.readLine();
        String source2 = reader.readLine();

        writer.write(String.valueOf(solve(source1, source2)));
        writer.close();
        reader.close();
    }

    static int solve(String source1, String source2) {

        int[] source1EachCharCount = getEachCharCount(source1);
        int[] source2EachCharCount = getEachCharCount(source2);

        return GetSumOfDifferencesInEachIndex(source1EachCharCount, source2EachCharCount);
    }

    private static int GetSumOfDifferencesInEachIndex(int[] source1EachCharCount, int[] source2EachCharCount) {
        int result = 0;
        for (int i = 0; i < 26; i++) {
            int diff = source1EachCharCount[i] - source2EachCharCount[i];
            if (diff < 0)
                diff *= -1;
            result += diff;
        }
        return result;
    }

    private static int[] getEachCharCount(String source1) {
        int[] source1Numbers = new int[26];
        for (char c : source1.toCharArray()) {
            source1Numbers[c - 'a']++;
        }
        return source1Numbers;
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
        return "https://www.acmicpc.net/problem/1919";
    }
}
