package me.study.solvedac;

import me.study.CodingTest;

import java.util.HashSet;
import java.util.Set;

class Problem9663 implements CodingTest {
    static Set<Set<Coordinate>> results = new HashSet<>();

    static int solve(int n) {
        Set<Coordinate> board = createBoard(n);

        for (final Coordinate coordinate : board) {
            Set<Coordinate> remaining = new HashSet<>(board);
            remaining.remove(coordinate);
            Set<Coordinate> current = new HashSet<>();
            current.add(coordinate);
            recursive(n, remaining, coordinate, current);
        }

        return results.size();
    }

    private static void recursive(int n, Set<Coordinate> remaining, Coordinate cursor, Set<Coordinate> current) {
        if (current.size() == n) {
            results.add(current);
        } else {
            removeNotAvailableCoordinates(n, cursor, remaining);

            for (final Coordinate coordinate : remaining) {
                Set<Coordinate> nextRemaining = new HashSet<>(remaining);
                nextRemaining.remove(coordinate);
                Set<Coordinate> nextCurrent = new HashSet<>(current);
                nextCurrent.add(coordinate);
                recursive(n, nextRemaining, coordinate, nextCurrent);
            }
        }
    }

    private static void removeNotAvailableCoordinates(int n, Coordinate cursor, Set<Coordinate> nextRemaining) {
        for (int i = 0; i < n; i++) {
            nextRemaining.remove(new Coordinate(cursor.x, i));
            nextRemaining.remove(new Coordinate(i, cursor.y));
            nextRemaining.remove(new Coordinate(cursor.x - i, cursor.y - i));
            nextRemaining.remove(new Coordinate(cursor.x - i, cursor.y + i));
            nextRemaining.remove(new Coordinate(cursor.x + i, cursor.y - i));
            nextRemaining.remove(new Coordinate(cursor.x + i, cursor.y + i));
        }
    }

    private static Set<Coordinate> createBoard(int n) {
        Set<Coordinate> board = new HashSet<>();
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                board.add(new Coordinate(x, y));
            }
        }
        return board;
    }

    static class Coordinate {
        private final int x;
        private final int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof final Coordinate that)) return false;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return x * 31 * y * 29;
        }

    }

    @Override
    public String getTimeComplexity() {
        return null;
    }

    @Override
    public String getSpaceComplexity() {
        return null;
    }

    @Override
    public String getPage() {
        return "https://www.acmicpc.net/problem/9663";
    }

}
