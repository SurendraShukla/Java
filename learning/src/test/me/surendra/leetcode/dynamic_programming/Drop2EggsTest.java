package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class Drop2EggsTest {

    @Test
    public void test() {
        final Drop2Eggs drop2Eggs = new Drop2Eggs();
        int no = 100;
        for (int i = 0; i < no; i++) {
            int actual = drop2Eggs.twoEggDrop(i);
            int expected = (int)Math.round(Math.sqrt(i*2));

            System.out.println("No=[" + i + "]\t =[" + actual + "]");
            assertThat(actual, equalTo(expected));
        }
    }
}
