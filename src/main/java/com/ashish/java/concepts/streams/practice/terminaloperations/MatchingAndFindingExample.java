package com.ashish.java.concepts.streams.practice.terminaloperations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MatchingAndFindingExample {

    static void main() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        boolean anyEven = nums.stream().anyMatch(n->n%2==0);
        boolean allPositive = nums.stream().allMatch(n->n>0);
        boolean noneGreaterThan10 = nums.stream().noneMatch(n->n>10);

        Optional<Integer> firstEven = nums.stream().filter(n -> n % 2 == 0).findFirst();
        Optional<Integer> anyEvenParallel = nums.parallelStream().filter(n -> n % 2 == 0).findAny();

        System.out.println("anyMatch even: " + anyEven);
        System.out.println("allMatch > 0: " + allPositive);
        System.out.println("noneMatch > 10: " + noneGreaterThan10);
        System.out.println("findFirst even: " + firstEven.orElse(null));
        System.out.println("findAny even (parallel): " + anyEvenParallel.orElse(null));

        //edge case: empty stream
        System.out.println("findFirst on empty stream: " + Stream.<Integer>empty().findFirst().orElse(null));
    }
}
