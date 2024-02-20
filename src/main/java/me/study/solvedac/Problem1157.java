package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Problem1157 implements CodingTest {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String source = reader.readLine();
        writer.write(solve(source));
        writer.close();
        reader.close();
    }


    static String solve(String source) {
        int[] charCount = getCharCount(source);
        int maxIndex = getLargestIndex(charCount);

        return maxIndex != -1 ? String.valueOf((char) ('A' + maxIndex)) : "?";
    }

    private static int getLargestIndex(int[] charCount) {
        int maxIndex = 0;
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[maxIndex] < charCount[i])
                maxIndex = i;
        }

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[maxIndex] == charCount[i] && maxIndex != i) {
                maxIndex = -1;
                break;
            }
        }
        return maxIndex;
    }

    private static int[] getCharCount(String source) {
        int[] charCount = new int[26];

        for (char c : source.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                charCount[c - 'a']++;
            } else
                charCount[c - 'A']++;
        }
        return charCount;
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
        return "https://www.acmicpc.net/problem/1157";
    }
}
