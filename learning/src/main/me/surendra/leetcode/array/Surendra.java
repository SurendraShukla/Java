package me.surendra.leetcode.array;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Surendra {

    public static void main(final String[] args) {
        final long startTime = System.nanoTime();

        final List<Integer> list = IntStream.range(1, 7000000).boxed().collect(Collectors.toList());

        System.out.println(list);

        final long endTime = System.nanoTime();
        final long seconds = TimeUnit.SECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS);
        System.out.println(seconds);
    }

}
