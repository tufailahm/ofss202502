package com.training.finance;

import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        Stream.of("ONE","TWO","THREE","FOUR")
                .mapToInt(s->s.length())
                .peek(i->System.out.println(i))
                .filter(i->i>3)
                .sum();

        Stream.of("A","C","B","D","B","D")
                .distinct()
                .sorted()
                .skip(2)
                .forEach(System.out::println);

    }
}
