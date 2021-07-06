package me.surendra.leetcode.binary_search;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BadVersionFinderTest {

    @Test
    public void test1() {
        assertThat(new BadVersionFinder().firstBadVersion(5), equalTo(4));
    }

    @Test
    public void test2() {
        assertThat(new BadVersionFinder().firstBadVersion(1), equalTo(1));
    }
}
