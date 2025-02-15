package me.study.algospot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Picnic {

    private static int numberOfPairCases = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < caseCount; i++) {
            String[] childrenCountAndPairCount = reader.readLine().split(" ");
            int childrenCount = Integer.parseInt(childrenCountAndPairCount[0]);

            Map<Integer, Child> children = IntStream.range(0, childrenCount)
                    .boxed()
                    .map(Child::new)
                    .collect(Collectors.toMap(child -> child.id, child -> child));

            String[] friendsSource = reader.readLine().split(" ");
            for (int j = 0; j < friendsSource.length; j += 2) {
                int childId0 = Integer.parseInt(friendsSource[j]);
                int childId1 = Integer.parseInt(friendsSource[j + 1]);

                children.get(childId0).friends.add(children.get(childId1));
                children.get(childId1).friends.add(children.get(childId0));
            }

            LinkedList<Child> childrenList = new LinkedList<>(children.values());
            writer.write(solve(childrenList) + "\n");
            numberOfPairCases = 0;
        }
        writer.flush();
        writer.close();
        reader.close();
    }

    static int solve(List<Child> children) {
        recursive(children);
        return numberOfPairCases;
    }

    private static void recursive(List<Child> children) {
        if (children.isEmpty()) {
            numberOfPairCases++;
            return;
        }
        Child child = children.removeFirst();
        if (child.friends.isEmpty()) {
            return;
        }
        for (Child friend : child.friends) {
            boolean removed = children.remove(friend);
            if (removed) {
                recursive(children);
                children.add(friend);
            }
        }
        children.add(child);
    }

    static class Child {
        final int id;
        final List<Child> friends;

        public Child(int id) {
            this.id = id;
            this.friends = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Child child = (Child) o;
            return id == child.id && Objects.equals(friends, child.friends);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, friends);
        }
    }

}
