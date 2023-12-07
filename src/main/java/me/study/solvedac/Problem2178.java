package me.study.solvedac;

import java.util.ArrayDeque;
import java.util.List;

class Problem2178 {
    private final List<List<Integer>> map;
    private final boolean[][] visitedLocations;

    Problem2178(List<List<Integer>> map) {
        this.map = map;
        visitedLocations = new boolean[map.size()][map.get(0).size()];
    }

    int search(int n, int m) {
        n = n - 1;
        m = m - 1;
        ArrayDeque<Location> locations = new ArrayDeque<>();
        locations.add(new Location(0, 0, 1));
        Location target = new Location(n, m, -1);

        while (!locations.isEmpty()) {
            Location location = locations.pop();
            if (location.equals(target))
                return location.distanceFromStartPoint;
            visit(location);
            addNextLocations(location, locations);
        }
        return 0;
    }

    private void addNextLocations(Location location, ArrayDeque<Location> locations) {
        int distanceFromStartPoint = location.distanceFromStartPoint + 1;
        int n = location.n;
        int m = location.m;
        addNextLocation(locations, n + 1, m, distanceFromStartPoint);
        addNextLocation(locations, n - 1, m, distanceFromStartPoint);
        addNextLocation(locations, n, m + 1, distanceFromStartPoint);
        addNextLocation(locations, n, m - 1, distanceFromStartPoint);
    }

    private void addNextLocation(ArrayDeque<Location> locations, int n, int m, int distanceFromStartPoint) {
        Location location = new Location(n, m, distanceFromStartPoint);
        if (canAdd(location)) {
            locations.add(location);
        }
    }

    private boolean isVisited(Location location) {
        return visitedLocations[location.n][location.m];
    }

    private boolean canAdd(Location location) {
        return location.n >= 0 &&
               location.m >= 0 &&
               location.n < map.size() &&
               location.m < map.get(0).size() &&
               map.get(location.n).get(location.m) == 1 &&
               !isVisited(location);
    }

    private void visit(Location location) {
        visitedLocations[location.n][location.m] = true;
    }

    private static class Location {
        private final int n;
        private final int m;
        private final int distanceFromStartPoint;

        public boolean equals(Location location) {
            return n == location.n && m == location.m;
        }

        private Location(int n, int m, int distanceFromStartPoint) {
            this.n = n;
            this.m = m;
            this.distanceFromStartPoint = distanceFromStartPoint;
        }

    }


}
