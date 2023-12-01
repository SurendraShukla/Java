package me.surendra.leetcode.string;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class TwoStringArraysAreEquivalentTest {

    private final TwoStringArraysAreEquivalent twoStringArraysAreEquivalent = new TwoStringArraysAreEquivalent();

    private boolean callMethod(final String[] word1, final String[] word2) {
        return twoStringArraysAreEquivalent.arrayStringsAreEqual(word1, word2);
    }

    @Test
    public void shouldReturnTrue() {
        assertThat(
            callMethod(new String[]{"ab", "c"}, new String[]{"a", "bc"}),
            equalTo(true)
        );

        assertThat(
            callMethod(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}),
            equalTo(true)
        );
    }

    @Test
    public void shouldReturnFalse() {
        assertThat(
            callMethod(new String[]{"a", "cb"}, new String[]{"ab", "c"}),
            equalTo(false)
        );

        assertThat(
            callMethod(new String[]{"abc", "d", "defg"}, new String[]{"abcddef"}),
            equalTo(false)
        );
    }

}
