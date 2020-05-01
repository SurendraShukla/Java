package me.surendra.learning.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;


public class StreamTest {

    @Test
    public void shouldCreate() {
        int[] result = IntStream.of(18, 87, 97, 43, 121, 20)
            .flatMap(Stream::factorize)
            .distinct()
            .sorted()
            .toArray();
        System.out.println(Arrays.toString(result));
    }

}
