package me.surendra.leetcode.string.anagram;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class PermutationInStringTest {

    PermutationInString permutationInString = new PermutationInString();

    private boolean callMethod(final String ab, final String eidbaooo) {
        return permutationInString.checkInclusionByUsingIntArray(ab, eidbaooo);
//        return permutationInString.checkInclusionByUsingCharArray(ab, eidbaooo);
    }

    @Test
    public void test() {
        assertThat(callMethod("ab", "eidbaooo"), equalTo(true));
        assertThat(callMethod("adc", "dcda"), equalTo(true));
        assertThat(callMethod("ab", "eidboaoo"), equalTo(false));
        assertThat(callMethod("ab", "eidboaoo"), equalTo(false));
    }

}
