package me.surendra.leetcode.string.anagram;

import org.junit.Test;

import static me.surendra.leetcode.string.anagram.InclusionFinder.checkInclusion;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class InclusionFinderTest {

    @Test
    public void isPermutationInString() {
        assertThat(checkInclusion("ab", "eidbaooo"), equalTo(true));
        assertThat(checkInclusion("ab", "eidboaoo"), equalTo(false));
    }

}
