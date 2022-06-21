package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class EggDrop2EggsTest {

    @Test
    public void test() {
        final EggDrop2Eggs eggDrop2Eggs = new EggDrop2Eggs();
        int no = 100000;
        for (int i = 0; i < no; i++) {
            int actual = eggDrop2Eggs.twoEggDrop(i);
            int expected = (int)Math.round(Math.sqrt(i*2));

            assertThat(actual, equalTo(expected));
        }
    }
}
