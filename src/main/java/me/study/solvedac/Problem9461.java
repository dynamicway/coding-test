package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem9461 implements CodingTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCaseCount; i++) {
            int n = Integer.parseInt(reader.readLine());
            writer.write(solve(n) + "\n");
        }
        writer.flush();
        writer.close();
        reader.close();
    }

    static long solve(int n) {
        if (n == 1) {
            return 1;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        return dp[n];
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
        return "https://www.acmicpc.net/problem/9461";
    }
}
