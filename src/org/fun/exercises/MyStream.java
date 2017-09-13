package org.fun.exercises;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class MyStream {

    public static void main(String[] args) {
//        Stream stream = Stream.of(1,2,3,4,5);
//        System.out.println(stream);
        Stream.of(1,2,3,4,5)
                .filter(e -> e%2 == 0)
                .map(e -> e*e)
                .forEach(e -> System.out.println(e));

//        IntStream

        IntStream intStream = IntStream.of(1,2,3);

        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
        integerStream
                .map(x-> x*x)
                .filter(x-> x%2 != 0)
                .forEach(e -> System.out.println(e));
//				.forEach(System.out::println);
//				.forEach(this::display);

        // ForEach is a terminal operation
    }

    private void display(Integer integer) {
        System.out.println(integer);
    }


}
