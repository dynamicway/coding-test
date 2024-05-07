package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem11652 implements CodingTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(reader.readLine());

        long[] source = new long[length];
        for (int i = 0; i < length; i++) {
            source[i] = Long.parseLong(reader.readLine());
        }
        writer.write(String.valueOf(solve(source)));
        writer.flush();
        writer.close();
        reader.close();
    }

    static long solve(long[] source) {
        Map<Long, Value> values = new HashMap<>();
        for (long v : source) {
            values.computeIfAbsent(v, k -> new Value(v, 0)).increase();
        }

        List<Value> values2 = new ArrayList<>();
        values.forEach((k, v) -> values2.add(v));
        values2.sort((o1, o2) -> {
            if (o1.count == o2.count)
                return Long.compare(o1.value, o2.value);
            return -1 * Integer.compare(o1.count, o2.count);
        });
        return values2.get(0).value;
    }

    private static class Value {
        private final long value;
        private int count;

        private Value(long value, int count) {
            this.value = value;
            this.count = count;
        }

        void increase() {
            count++;
        }

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
        return "https://www.acmicpc.net/problem/11652";
    }
}
