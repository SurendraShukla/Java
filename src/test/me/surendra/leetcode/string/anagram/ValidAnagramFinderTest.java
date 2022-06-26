package me.surendra.leetcode.string.anagram;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ValidAnagramFinderTest {

    private boolean callMethod(final String str1, final String str2) {
//        return new ValidAnagram().isAnagramUsingSorting(str1, str2);
        return new ValidAnagramFinder().isAnagramUsingArrayForCharFrequency(str1, str2);
    }

    @Test
    public void validAnagramStrings() {
        assertThat(callMethod("rat", "tar"), equalTo(true));
        assertThat(callMethod("silent", "listen"), equalTo(true));
        assertThat(callMethod("anagram", "nagaram"), equalTo(true));
    }

    @Test
    public void inValidAnagramStrings() {
        assertThat(callMethod("rat", "ta"), equalTo(false));
        assertThat(callMethod("rat", "car"), equalTo(false));
    }

}
