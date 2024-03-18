package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Problem15652 implements CodingTest {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] source = READER.readLine().split(" ");
        int n = Integer.parseInt(source[0]);
        int m = Integer.parseInt(source[1]);
        solve(n, m);
        READER.close();
        WRITER.flush();
        WRITER.close();
    }

    static void solve(int n, int m) {
        int[] memory = new int[m];
        Arrays.fill(memory, 1);

        while (true) {
            print(memory);
            if (!canIncreased(memory, n))
                break;
            increase(memory, n);
        }

    }

    private static boolean canIncreased(int[] memory, int threshold) {
        boolean canIncreased = false;
        for (int i : memory) {
            if (i < threshold) {
                canIncreased = true;
                break;
            }
        }
        return canIncreased;
    }

    private static void increase(int[] memory, int threshold) {
        boolean increased = false;
        for (int i = memory.length - 1; i >= 0; i--) {
            if (memory[i] == threshold) {
                increased = true;
            } else {
                memory[i] = memory[i] + 1;
                if (increased) {
                    for (int j = memory.length - 1; j > i; j--) {
                        memory[j] = memory[i];
                    }
                }
                break;
            }
        }
    }

    private static void print(int[] memory) {
        try {
            for (int i = 0; i < memory.length; i++) {
                if (i == memory.length - 1)
                    WRITER.write(Character.forDigit(memory[i], 10));
                else
                    WRITER.write(memory[i] + " ");
            }
            WRITER.write("\n");
        } catch (Throwable e) {

        }
    }

    @Override
    public String getTimeComplexity() {
        return "";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(M)";
    }

    @Override
    public String getPage() {
        return "https://www.acmicpc.net/problem/15652";
    }
}
