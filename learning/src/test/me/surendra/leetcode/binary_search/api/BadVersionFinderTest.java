package me.surendra.leetcode.binary_search.api;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BadVersionFinderTest {

    private int getUnit(final int badVersion, final int no) {
        final BadVersionFinder badVersionFinder = new BadVersionFinder((num) -> num >= badVersion);
        return badVersionFinder.firstBadVersion(no);
    }

    @Test
    public void test() {
        final int badVersion1 = 4;
        assertThat(getUnit(badVersion1, 5), equalTo(badVersion1));

        final int badVersion2 = 1;
        assertThat(getUnit(badVersion2, 1), equalTo(badVersion2));

        final int badVersion3 = 1240808008;
        assertThat(getUnit(badVersion3, 1792997410), equalTo(badVersion3));
    }

}
