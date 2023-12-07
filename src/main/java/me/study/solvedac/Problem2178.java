package me.study.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

class Problem2178 {
    private static List<List<Integer>> map;
    private static boolean[][] visitedLocations;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] metaData = reader.readLine().split(" ");
        int n = Integer.parseInt(metaData[0]);
        int m = Integer.parseInt(metaData[1]);
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = Arrays.stream(reader.readLine().split(""))
                                      .map(Integer::parseInt)
                                      .collect(toUnmodifiableList());
            map.add(row);
        }
        writer.write(String.valueOf(search(n, m, map)));
        writer.close();
        reader.close();
    }

    static int search(int n, int m, List<List<Integer>> mapParameter) {
        map = mapParameter;
        visitedLocations = new boolean[map.size()][map.get(0).size()];
        n = n - 1;
        m = m - 1;
        ArrayDeque<Location> locations = new ArrayDeque<>();
        locations.add(new Location(0, 0, 1));
        Location target = new Location(n, m, -1);

        while (!locations.isEmpty()) {
            Location location = locations.pop();
            if (location.equals(target))
                return location.distanceFromStartPoint;
            addNextLocations(location, locations);
        }
        return 0;
    }

    private static void addNextLocations(Location location, ArrayDeque<Location> locations) {
        int distanceFromStartPoint = location.distanceFromStartPoint + 1;
        int n = location.n;
        int m = location.m;
        addNextLocation(locations, n + 1, m, distanceFromStartPoint);
        addNextLocation(locations, n - 1, m, distanceFromStartPoint);
        addNextLocation(locations, n, m + 1, distanceFromStartPoint);
        addNextLocation(locations, n, m - 1, distanceFromStartPoint);
    }

    private static void addNextLocation(ArrayDeque<Location> locations, int n, int m, int distanceFromStartPoint) {
        Location location = new Location(n, m, distanceFromStartPoint);
        if (canAdd(location)) {
            locations.add(location);
            visit(location);
        }
    }

    private static boolean isVisited(Location location) {
        return visitedLocations[location.n][location.m];
    }

    private static boolean canAdd(Location location) {
        return location.n >= 0 &&
               location.m >= 0 &&
               location.n < map.size() &&
               location.m < map.get(0).size() &&
               map.get(location.n).get(location.m) == 1 &&
               !isVisited(location);
    }

    private static void visit(Location location) {
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
