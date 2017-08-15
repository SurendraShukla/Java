package org.fun.exercises;

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
    }
}
