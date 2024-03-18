package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Problem15649 implements CodingTest {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] source = reader.readLine().split(" ");
        int n = Integer.parseInt(source[0]);
        int m = Integer.parseInt(source[1]);
        solve(n, m);
        reader.close();
        writer.close();
    }

    static void solve(int n, int m) {
        for (int i = 1; i <= n; i++) {
            int[] memory = new int[m];
            memory[0] = i;
            recursion(memory, 1, m, n);
        }
    }

    private static void recursion(int[] memory, int cursor, int cursorThreshold, int n) {
        if (cursor == cursorThreshold) {
            print(memory);
        } else {
            for (int i = 1; i <= n; i++) {
                boolean used = true;
                for (int j = 0; j < cursor; j++) {
                    if (memory[j] == i) {
                        used = false;
                        break;
                    }
                }
                if (used) {
                    int[] nextMemory = Arrays.copyOf(memory, cursorThreshold);
                    nextMemory[cursor] = i;
                    recursion(nextMemory, cursor + 1, cursorThreshold, n);
                }
            }
        }
    }

    private static void print(int[] memory) {
        try {
            for (int i = 0; i < memory.length; i++) {
                if (i == memory.length - 1)
                    writer.write(Character.forDigit(memory[i], 10));
                else
                    writer.write(memory[i] + " ");
            }
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {

        }
    }

    @Override
    public String getTimeComplexity() {
        return "O(N!)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(M)";
    }

    @Override
    public String getPage() {
        return "https://www.acmicpc.net/problem/15649";
    }
}
