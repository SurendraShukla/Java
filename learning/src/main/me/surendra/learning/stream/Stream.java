package me.surendra.learning.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Stream {
    public static IntStream factorize(int value) {
        List<Integer> factors = new ArrayList<>();
        for(int i=2; i< value; i++) {
            while (value % i == 0) {
                factors.add(i);
                value /= i;
            }
        }
        return factors.stream().mapToInt(Integer::intValue);
    }
}
