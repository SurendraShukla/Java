package me.surendra.leetcode.string.anagram;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PermutationInStringTest {

    PermutationInString permutationInString;

    @Before
    public void setUp() throws Exception {
        permutationInString = new PermutationInString();
    }

    @Test
    public void strContainsPermutation() {
        assertThat(permutationInString.checkInclusion("ab", "eidbaooo"), equalTo(true));
        assertThat(permutationInString.checkInclusion("adc", "dcda"), equalTo(true));
    }

    @Test
    public void strDoesNotContainsPermutation() {
        assertThat(permutationInString.checkInclusion("ab", "eidboaoo"), equalTo(false));
    }


}
