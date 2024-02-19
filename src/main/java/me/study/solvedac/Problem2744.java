package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Problem2744 implements CodingTest {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String source = reader.readLine();
        writer.write(changeCase(source));
        writer.close();
        reader.close();
    }

    static String changeCase(String source) {
        StringBuilder result = new StringBuilder();

        for (char c : source.toCharArray()) {
            if (Character.isUpperCase(c))
                result.append(Character.toLowerCase(c));
            else
                result.append(Character.toUpperCase(c));
        }

        return result.toString();
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
        return "https://www.acmicpc.net/problem/2744";
    }
}
