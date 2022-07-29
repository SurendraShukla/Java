package me.surendra.leetcode.string;


import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PatternMatchersTest {

    private List<String> callMethod(final String[] words, final String abb) {
        return new PatternMatchers().findAndReplacePatternIdentifyPatternFirst(words, abb);
//        return new PatternMatchers().findAndReplacePatternIdentifyPatternFirst(words, abb);
    }

    @Test
    public void wordsWithMoreThanOneCharacters() {
        final String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};

        // execute
        final List<String> actual = callMethod(words, "abb");

        final List<String> expected = Lists.newArrayList("mee", "aqq");
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void wordsWithOneCharacter() {
        final String[] words = {"a", "b", "c"};

        // execute
        final List<String> actual = callMethod(words, "a");

        final List<String> expected = Lists.newArrayList("a", "b", "c");
        assertThat(actual, equalTo(expected));
    }

}
