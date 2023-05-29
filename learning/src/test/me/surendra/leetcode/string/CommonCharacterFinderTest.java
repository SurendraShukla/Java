package me.surendra.leetcode.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static me.surendra.TestUtil.assertion;

public class CommonCharacterFinderTest {

    private List<String> callMethod(final String[] words) {
        return new CommonCharacterFinder().commonChars(words);
    }

    @Test
    public void test1() {
        final String[] words = {"bella","label","roller"};
        final List<String> expected = Arrays.asList("e", "l", "l");

        final List<String> actual = callMethod(words);

        assertion(actual, expected);
    }

    @Test
    public void test2() {
        final String[] words = {"cool","lock","cook"};
        final List<String> expected = Arrays.asList("c", "o");

        final List<String> actual = callMethod(words);

        assertion(actual, expected);
    }

}
