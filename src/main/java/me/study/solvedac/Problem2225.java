package me.study.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2225 {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] source = reader.readLine().split(" ");
        int n = Integer.parseInt(source[0]);
        int k = Integer.parseInt(source[1]);
        writer.write(solve(n, k) + "");
        writer.flush();
        writer.close();
        reader.close();
    }

    static long solve(int n, int k) {
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                }
            }
        }
        return dp[k][n];
    }

}
