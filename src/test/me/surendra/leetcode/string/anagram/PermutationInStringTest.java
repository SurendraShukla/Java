package me.surendra.leetcode.string.anagram;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PermutationInStringTest {

    PermutationInString permutationInString;

    @Before
    public void setUp() {
        permutationInString = new PermutationInString();
    }

    @Test
    public void strContainsPermutationForCheckInclusionByUsingIntArray() {
        assertThat(permutationInString.checkInclusionByUsingIntArray("ab", "eidbaooo"), equalTo(true));
        assertThat(permutationInString.checkInclusionByUsingIntArray("adc", "dcda"), equalTo(true));
    }

    @Test
    public void strDoesNotContainsPermutationForCheckInclusionByUsingIntArray() {
        assertThat(permutationInString.checkInclusionByUsingIntArray("ab", "eidboaoo"), equalTo(false));
        assertThat(permutationInString.checkInclusionByUsingIntArray("ab", "eidboaoo"), equalTo(false));
    }

    @Test
    public void strContainsPermutationForCheckInclusionByUsingString() {
        assertThat(permutationInString.checkInclusionByUsingString("ab", "eidbaooo"), equalTo(true));
        assertThat(permutationInString.checkInclusionByUsingString("adc", "dcda"), equalTo(true));
    }

    @Test
    public void strDoesNotContainsPermutationForCheckInclusionByUsingString() {
        assertThat(permutationInString.checkInclusionByUsingString("ab", "eidboaoo"), equalTo(false));
        assertThat(permutationInString.checkInclusionByUsingString("ab", "eidboaoo"), equalTo(false));
    }

    @Test
    public void strContainsPermutationForCheckInclusionByUsingCharArray() {
        assertThat(permutationInString.checkInclusionByUsingCharArray("ab", "eidbaooo"), equalTo(true));
        assertThat(permutationInString.checkInclusionByUsingCharArray("adc", "dcda"), equalTo(true));
    }

    @Test
    public void strDoesNotContainsPermutationForCheckInclusionByUsingCharArray() {
        assertThat(permutationInString.checkInclusionByUsingCharArray("ab", "eidboaoo"), equalTo(false));
        assertThat(permutationInString.checkInclusionByUsingCharArray("ab", "eidboaoo"), equalTo(false));
    }

}
