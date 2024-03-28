package me.study.solvedac;

import java.util.ArrayList;
import java.util.List;

class Problem9663_2 {
    private final int n;
    private final List<Integer> coordinates = new ArrayList<>();
    private int ans = 0;

    Problem9663_2(int n) {
        this.n = n;
    }

    int solve() {
        for (int i = 0; i < n; i++) {
            coordinates.add(i);
            recursive(0);
            coordinates.remove(coordinates.size() - 1);
        }
        return ans;
    }

    private void recursive(int row) {
        if (row == n - 1) {
            ans++;
        } else {
            for (int i = 0; i < n; i++) {
                if (canPlacedOnCoordinate(i, row + 1)) {
                    coordinates.add(i);
                    recursive(row + 1);
                    coordinates.remove(coordinates.size() - 1);
                }
            }
        }
    }

    private boolean canPlacedOnCoordinate(int column, int row) {
        for (int r = 0; r < coordinates.size(); r++) {
            Integer c = coordinates.get(r);
            if (c == column)
                return false;
            if (c + r == column + row)
                return false;
            if (c - r == column - row)
                return false;
        }
        return true;
    }
}
