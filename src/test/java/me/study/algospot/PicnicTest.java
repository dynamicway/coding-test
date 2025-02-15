package me.study.algospot;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PicnicTest {

    @Test
    void if_even_a_child_has_no_friends_forming_a_pair_is_impossible() {
        Picnic.Child child0 = new Picnic.Child(0);
        Picnic.Child child1 = new Picnic.Child(1);
        Picnic.Child child2 = new Picnic.Child(2);
        Picnic.Child child3 = new Picnic.Child(3);

        child1.friends.add(child2);
        child1.friends.add(child3);
        child2.friends.add(child1);
        child2.friends.add(child3);
        child3.friends.add(child1);
        child3.friends.add(child2);

        List<Picnic.Child> children = new LinkedList<>(List.of(
                child0,
                child1,
                child2,
                child3));
        int numberOfPairCases = Picnic.solve(children);

        assertThat(numberOfPairCases).isZero();
    }

    @Test
    void test1() {
        Picnic.Child child0 = new Picnic.Child(0);
        Picnic.Child child1 = new Picnic.Child(1);

        child0.friends.add(child1);
        child1.friends.add(child0);

        List<Picnic.Child> children = new LinkedList<>(List.of(child0, child1));
        int numberOfPairCases = Picnic.solve(children);

        assertThat(numberOfPairCases).isOne();
    }

    @Test
    void test2() {
        Picnic.Child child0 = new Picnic.Child(0);
        Picnic.Child child1 = new Picnic.Child(1);
        Picnic.Child child2 = new Picnic.Child(2);
        Picnic.Child child3 = new Picnic.Child(3);

        child0.friends.add(child1);
        child0.friends.add(child2);
        child0.friends.add(child3);
        child1.friends.add(child0);
        child1.friends.add(child2);
        child1.friends.add(child3);
        child2.friends.add(child0);
        child2.friends.add(child1);
        child2.friends.add(child3);
        child3.friends.add(child0);
        child3.friends.add(child1);
        child3.friends.add(child2);

        List<Picnic.Child> children = new LinkedList<>(List.of(child0, child1, child2, child3));
        int numberOfPairCases = Picnic.solve(children);

        assertThat(numberOfPairCases).isEqualTo(3);
    }

}