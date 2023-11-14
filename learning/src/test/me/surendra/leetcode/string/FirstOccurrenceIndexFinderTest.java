package me.surendra.leetcode.string;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class FirstOccurrenceIndexFinderTest {

    private final FirstOccurrenceIndexFinder firstOccurrenceIndexFinder = new FirstOccurrenceIndexFinder();

    private int callMethod(final String haystack, final String needle) {
        return firstOccurrenceIndexFinder.strStr(haystack, needle);
    }

    @Test
    public void test() {
        assertThat(callMethod("a", "a"), equalTo(0));
        assertThat(callMethod("aaa", "a"), equalTo(0));
        assertThat(callMethod("hello", "ll"), equalTo(2));
        assertThat(callMethod("sadbutsad", "sad"), equalTo(0));
        assertThat(callMethod("leetcode", "leeto"), equalTo(-1));
    }

}
