package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Problem20291 implements CodingTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(reader.readLine());
        List<String> source = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            source.add(reader.readLine());
        }
        for (Map.Entry<String, AtomicInteger> entry : solve(source).entrySet()) {
            writer.write(entry.getKey() + " " + entry.getValue().get());
            writer.write("\n");
        }
        writer.flush();
        writer.close();
        reader.close();
    }

    static Map<String, AtomicInteger> solve(List<String> source) {
        TreeMap<String, AtomicInteger> result = new TreeMap<>();
        for (final String s : source) {
            result.computeIfAbsent(s.substring(s.indexOf(".") + 1), k -> new AtomicInteger()).incrementAndGet();
        }
        return result;
    }

    @Override
    public String getTimeComplexity() {
        return "O(N log N)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N)";
    }

    @Override
    public String getPage() {
        return "https://www.acmicpc.net/problem/20291";
    }
}
