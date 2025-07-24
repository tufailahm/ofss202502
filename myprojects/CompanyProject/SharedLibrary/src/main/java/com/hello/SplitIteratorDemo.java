package com.hello;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.Arrays;

public class SplitIteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        Spliterator<Integer> splitIterator = numbers.spliterator();

        // Split the iterator
        Spliterator<Integer> splitIterator2 = splitIterator.trySplit();

        // Process the first half (using tryAdvance)
        System.out.println("First half:");
        while (splitIterator.tryAdvance(System.out::println));

        // Process the second half (using forEachRemaining)
        System.out.println("\nSecond half:");
        if (splitIterator2 != null) {
            splitIterator2.forEachRemaining(System.out::println);
        }
    }
}