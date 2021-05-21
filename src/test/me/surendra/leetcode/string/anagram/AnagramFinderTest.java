package me.surendra.leetcode.string.anagram;

import com.google.common.collect.Lists;
import org.junit.Test;

import static me.surendra.leetcode.string.anagram.AnagramFinder.findAnagrams;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class AnagramFinderTest {

    @Test
    public void findAllAnagramsInAString() {
        assertThat(findAnagrams("cbaebabacd", "abc"), equalTo(Lists.newArrayList(0, 6)));
        assertThat(findAnagrams("abab", "ab"), equalTo(Lists.newArrayList(0, 1, 2)));
        assertThat(findAnagrams("abab", "aba"), equalTo(Lists.newArrayList(0)));
    }

}
