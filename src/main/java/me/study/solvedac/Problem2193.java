package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem2193 implements CodingTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(solve(n)));
        writer.flush();
    }

    static long solve(int n) {
        long[][] memory = new long[n + 1][2];
        memory[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            memory[i][0] = memory[i - 1][0] + memory[i - 1][1];
            memory[i][1] = memory[i - 1][0];
        }
        return Arrays.stream(memory[n]).sum();
    }

    @Override
    public String getTimeComplexity() {
        return "N";
    }

    @Override
    public String getSpaceComplexity() {
        return "N";
    }

    @Override
    public String getPage() {
        return "https://www.acmicpc.net/problem/2193";
    }
}
