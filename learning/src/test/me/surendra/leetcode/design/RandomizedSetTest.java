package me.surendra.leetcode.design;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RandomizedSetTest {

    @Test
    public void smallSet() {
        final RandomizedSet randomizedSet = new RandomizedSet();
        assertTrue(randomizedSet.insert(10));
        assertFalse(randomizedSet.remove(20));
        assertTrue(randomizedSet.insert(20));

        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());

        assertTrue(randomizedSet.remove(10));
        assertFalse(randomizedSet.insert(20));

        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());
    }

    @Test
    public void allTrue() {
        final RandomizedSet randomizedSet = new RandomizedSet();
        assertTrue(randomizedSet.insert(0));
        assertTrue(randomizedSet.insert(1));
        assertTrue(randomizedSet.remove(0));
        assertTrue(randomizedSet.insert(2));
        assertTrue(randomizedSet.remove(2));

        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());
    }

    @Test
    public void allTrue2() {
        final RandomizedSet randomizedSet = new RandomizedSet();
        assertTrue(randomizedSet.insert(3));
        assertTrue(randomizedSet.insert(-2));
        assertTrue(randomizedSet.insert(1));
        assertTrue(randomizedSet.insert(-3));
        assertTrue(randomizedSet.remove(-2));
        assertTrue(randomizedSet.remove(3));
        assertTrue(randomizedSet.insert(-2));
    }

    @Test
    public void biggerSet() {
        final RandomizedSet randomizedSet = new RandomizedSet();
        assertTrue(randomizedSet.insert(3));
        assertTrue(randomizedSet.insert(-2));
        assertFalse(randomizedSet.remove(2));
        assertTrue(randomizedSet.insert(1));
        assertTrue(randomizedSet.insert(-3));
        assertFalse(randomizedSet.insert(-2));
        assertTrue(randomizedSet.remove(-2));
        assertTrue(randomizedSet.remove(3));
        assertTrue(randomizedSet.insert(-1));
        assertTrue(randomizedSet.remove(-3));
        assertFalse(randomizedSet.insert(1));
        assertTrue(randomizedSet.insert(-2));
        assertFalse(randomizedSet.insert(-2));
        assertFalse(randomizedSet.insert(-2));
        assertFalse(randomizedSet.insert(1));

        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());

        assertFalse(randomizedSet.insert(-2));
        assertFalse(randomizedSet.remove(0));
        assertTrue(randomizedSet.insert(-3));
        assertFalse(randomizedSet.insert(1));
    }

    @Test
    public void randomMethodCheck() {
        final RandomizedSet randomizedSet = new RandomizedSet();
        assertTrue(randomizedSet.insert(0));
        assertTrue(randomizedSet.remove(0));
        assertTrue(randomizedSet.insert(-1));
        assertFalse(randomizedSet.remove(-0));

        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());
        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());
        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());
        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());
        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());
        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());
        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());
        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());
        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());
        assertThat(randomizedSet.list).contains(randomizedSet.getRandom());
    }

}
