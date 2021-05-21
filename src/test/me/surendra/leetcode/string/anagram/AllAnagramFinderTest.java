package me.surendra.leetcode.string.anagram;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class AllAnagramFinderTest {

    private List<Integer> callMethod(final String str1, final String str2) {
        return new AllAnagramFinder().findAnagramsUsingSlidingWindow(str1, str2);
    }

    @Test
    public void test1() {
        final List<Integer> output = Lists.newArrayList(0, 6);

        assertThat(callMethod("cbaebabacd", "abc"), equalTo(output));
    }

    @Test
    public void test2() {
        final List<Integer> output = Lists.newArrayList(0, 1, 2);

        assertThat(callMethod("abab", "ab"), equalTo(output));
    }

}
