package me.surendra.leetcode.string.easy;


import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class DestinationCityTest {

    private final DestinationCity destinationCity = new DestinationCity();

    @Test
    public void test1() {
        final List<List<String>> paths = Lists.newArrayList(
            Lists.newArrayList("London", "New York"),
            Lists.newArrayList("New York", "Lima"),
            Lists.newArrayList("Lima", "Sao Paulo")
        );

        assertThat(destinationCity.destCity(paths), equalTo("Sao Paulo"));
    }

    @Test
    public void test2() {
        final List<List<String>> paths = Lists.newArrayList(
            Lists.newArrayList("B", "C"),
            Lists.newArrayList("D", "B"),
            Lists.newArrayList("C", "A")
        );

        assertThat(destinationCity.destCity(paths), equalTo("A"));
    }


    @Test
    public void test3() {
        final List<List<String>> paths = new ArrayList<>();
        paths.add(Lists.newArrayList("A", "Z"));

        assertThat(destinationCity.destCity(paths), equalTo("Z"));
    }

}
