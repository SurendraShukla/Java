package me.surendra.leetcode.string;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class UniqueMorseCodeWordsFinderTest {

    private final UniqueMorseCodeWordsFinder uniqueMorseCodeWordsFinder = new UniqueMorseCodeWordsFinder();

    private int callMethod(final String[] words) {
        return uniqueMorseCodeWordsFinder.uniqueMorseRepresentations(words);
    }

    @Test
    public void test() {
        assertThat(callMethod(new String[]{"gin", "zen", "gig", "msg"}), equalTo(2));
        assertThat(callMethod(new String[]{"a"}), equalTo(1));
    }

}
