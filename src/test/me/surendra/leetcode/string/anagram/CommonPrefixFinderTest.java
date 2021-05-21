package me.surendra.leetcode.string.anagram;

import org.junit.Test;

import static me.surendra.leetcode.string.anagram.CommonPrefixFinder.longestCommonPrefix;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CommonPrefixFinderTest {

    @Test
    public void getLongestCommonPrefix() {
        assertThat(longestCommonPrefix(new String[]{"flower","flow","flight"}), equalTo("fl"));
        assertThat(longestCommonPrefix(new String[]{"dog","racecar","car"}), equalTo(""));
        assertThat(longestCommonPrefix(new String[]{"dog"}), equalTo("dog"));
        assertThat(longestCommonPrefix(new String[]{"aca","cba"}), equalTo(""));
        assertThat(longestCommonPrefix(new String[]{}), equalTo(""));
    }

}
