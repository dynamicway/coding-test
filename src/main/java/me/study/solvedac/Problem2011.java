package me.study.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2011 {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            String n = reader.readLine();
            writer.write(solve(n) + "");
            writer.flush();
        }
    }

    static long solve(String n) {
        int digitCount = n.length();
        if (getDigit(n, 0) == 0) {
            return 0;
        }
        if (digitCount < 2) {
            return 1;
        }

        int[] dp = new int[digitCount];
        dp[0] = 1;
        if (getDigit(n, 1) == 0) {
            if (getDigit(n, 0) > 2) {
                return 0;
            } else {
                dp[1] = 1;
            }
        } else {
            if ((getDigit(n, 0) * 10) + getDigit(n, 1) < 27) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }
        for (int i = 2; i < digitCount; i++) {
            if (getDigit(n, i) == 0) {
                if (getDigit(n, i - 1) > 2 || getDigit(n, i - 1) == 0) {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            } else {
                if (getDigit(n, i - 1) == 0) {
                    dp[i] = dp[i - 1];
                } else if ((getDigit(n, i - 1) * 10) + getDigit(n, i) < 27) {
                    dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[digitCount - 1];
    }

    private static int getDigit(String n, int index) {
        return n.charAt(index) - '0';
    }

}
