package me.surendra.leetcode.binary_search;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BadVersionFinderTest {

    private final BadVersionFinder badVersionFinder = new BadVersionFinder();

    private int callMethod(final int n) {
        return badVersionFinder.firstBadVersion(n);
    }

    @Test
    public void test1() {
        assertThat(callMethod(5), equalTo(4));
        assertThat(callMethod(1), equalTo(1));
    }

}
