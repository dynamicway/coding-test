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
            int[] ints = new int[m];
            ints[0] = i;
            recursion(ints, 1, m, n);
        }
    }

    private static void recursion(int[] result, int cursor, int cursorThreshold, int n) {
        if (cursor == cursorThreshold) {
            print(result);
        } else {
            for (int i = 1; i <= n; i++) {
                boolean flag = true;
                for (int j = 0; j < cursor; j++) {
                    if (result[j] == i) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    int[] copyOf = Arrays.copyOf(result, cursorThreshold);
                    copyOf[cursor] = i;
                    recursion(copyOf, cursor + 1, cursorThreshold, n);
                }
            }
        }
    }

    private static void print(int[] result) {
        try {
            for (int i = 0; i < result.length; i++) {
                if (i == result.length - 1)
                    writer.write(Character.forDigit(result[i], 10));
                else
                    writer.write(result[i] + " ");
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
