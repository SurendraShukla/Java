package me.surendra.data_structures;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListPerformanceTest {

    @Test
    public void test() {
        final int n = 100_000_000;
        ListPerformance.createList(new ArrayList<>(n), n);
        ListPerformance.createList(new ArrayList<>(), n);
        ListPerformance.createList(new LinkedList<>(), n);
    }

}
