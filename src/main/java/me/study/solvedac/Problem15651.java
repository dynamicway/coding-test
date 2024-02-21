package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem15651 implements CodingTest {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] source = reader.readLine().split(" ");

        for (String result : solve(Integer.parseInt(source[0]), Integer.parseInt(source[1]))) {
            writer.write(result + "\n");
        }

        writer.close();
        reader.close();
    }

    static List<String> solve(int n, int r) {
        int[] number = new int[r];
        Arrays.fill(number, 1);

        List<String> result = new ArrayList<>();

        while (true) {
            result.add(toString(number));
            increase1stDigit(number);
            if (hasReachedThreshold(n + 1, number)) {
                int increasedPlace = increasesPossibleDigitAndInitializesPreviousDigitTo1(n, number);
                if (increasedPlace == -1) {
                    break;
                }
            }
        }
        return result;
    }

    private static int increasesPossibleDigitAndInitializesPreviousDigitTo1(int n, int[] number) {
        int digit = number.length - 2; // starting from the 2nd digit

        while (digit != -1) {
            if (number[digit] == n) { // If the current digit is equal to n, move to the next digit.
                digit--;
            } else { // If it is less than n, increase by 1 and break.
                number[digit]++;
                for (int i = number.length - 1; i > digit; i--) {
                    number[i] = 1;
                }
                break;
            }
        }

        return digit;
    }

    private static boolean hasReachedThreshold(int threshold, int[] number) {
        return number[number.length - 1] == threshold;
    }

    private static void increase1stDigit(int[] number) {
        number[number.length - 1]++;
    }

    private static String toString(int[] number) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length; i++) {
            sb.append(number[i]);
            if (i != number.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    @Override
    public String getTimeComplexity() {
        // 중복 순열을 모두 구하는 문제임
        return "O(N^M)";
    }

    @Override
    public String getSpaceComplexity() {
        // number 배열은 M개의 공간을 차지함.
        return "O(M)";
    }

    @Override
    public String getPage() {
        return "https://www.acmicpc.net/problem/15651";
    }
}
