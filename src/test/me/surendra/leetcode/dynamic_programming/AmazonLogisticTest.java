package me.surendra.leetcode.dynamic_programming;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class AmazonLogisticTest {

    @Test
    public void shouldReturn0ForOddNumberWheels() {
        final List<Integer> wheels = new ArrayList<>();
        for (int i = 1; i <= 36; i+=2) {
            wheels.add(i);
        }

        // execute
        final List<Integer> integers = AmazonLogistic.chooseFleets(wheels);
        for (final Integer integer : integers) {
            assertThat(integer, equalTo(0));
        }
    }

    @Test
    public void shouldReturn1For2Wheels() {
        final List<Integer> list = Lists.newArrayList(2);

        final List<Integer> integers = AmazonLogistic.chooseFleets(list);

        for (final Integer integer : integers) {
            assertThat(integer, equalTo(1));
        }
    }

    @Test
    public void shouldReturnQuotientPlusOneForEvenNumberWheels() {
        int noOfWays = 1;
        for(int noOfWheels=4; noOfWheels<=36; noOfWheels+=4) {
            final List<Integer> list = new ArrayList<>();
            for(int wheels=noOfWheels; wheels<noOfWheels+4; wheels+=2) {
                list.add(wheels);
            }

            // execute
            final List<Integer> integers = AmazonLogistic.chooseFleets(list);

            noOfWays = noOfWays + 1;
            for (final Integer integer : integers) {
                assertThat(integer, equalTo(noOfWays));
            }
        }
    }

}
