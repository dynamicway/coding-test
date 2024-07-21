package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem11057 implements CodingTest {
    private static final int MOD = 10007;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int target = Integer.parseInt(reader.readLine());
            writer.write(String.valueOf(solve(target)));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static long solve(int target) {
        long[][] memory = new long[target + 1][10];
        for (int i = 0; i < 10; i++) {
            memory[1][i] = 1;
        }
        for (int i = 0; i <= target; i++) {
            memory[i][0] = 1;
        }
        for (int index = 2; index <= target; index++) {
            for (int digitIndex = 1; digitIndex < 10; digitIndex++) {
                int previousIndex = index - 1;
                memory[index][digitIndex] = (memory[index][digitIndex - 1] + memory[previousIndex][digitIndex]) % MOD;
            }
        }
        return Arrays.stream(memory[target]).sum() % MOD;
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
        return "https://www.acmicpc.net/problem/11057";
    }
}
