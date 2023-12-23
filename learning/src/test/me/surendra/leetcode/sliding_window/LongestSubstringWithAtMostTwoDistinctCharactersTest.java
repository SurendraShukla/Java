package me.surendra.leetcode.sliding_window;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LongestSubstringWithAtMostTwoDistinctCharactersTest {

    @Test
    public void test() {
        final LongestSubstringWithAtMostTwoDistinctCharacters unit = new LongestSubstringWithAtMostTwoDistinctCharacters();

        assertThat(unit.lengthOfLongestSubstringTwoDistinct("eceba"), equalTo(3));
        assertThat(unit.lengthOfLongestSubstringTwoDistinct("ccaabbb"), equalTo(5));
    }
}
