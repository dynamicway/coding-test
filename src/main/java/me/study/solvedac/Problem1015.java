package me.study.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

class Problem1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        reader.readLine();
        String[] stringSource = reader.readLine().split(" ");
        int[] source = new int[stringSource.length];
        for (int i = 0; i < stringSource.length; i++) {
            source[i] = Integer.parseInt(stringSource[i]);
        }
        for (int result : solve(source)) {
            writer.write(result + " ");
        }
        writer.flush();
        writer.close();
        reader.close();
    }

    static int[] solve(int[] source) {
        TreeSet<Value> values = new TreeSet<>();
        for (int i = 0; i < source.length; i++) {
            values.add(new Value(source[i], i));
        }
        int currentIndex = 0;
        int[] result = new int[source.length];
        for (Value value : values) {
            result[value.index] = currentIndex++;
        }
        return result;
    }

    private static class Value implements Comparable<Value> {
        private final int value;
        private final int index;

        Value(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Value o) {
            if (value != o.value) return value - o.value;
            return index - o.index;
        }

    }

}
