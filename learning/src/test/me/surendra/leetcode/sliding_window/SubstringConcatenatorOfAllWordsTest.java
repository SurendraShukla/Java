package me.surendra.leetcode.sliding_window;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SubstringConcatenatorOfAllWordsTest {

    private final SubstringConcatenatorOfAllWords substringConcatenatorOfAllWords = new SubstringConcatenatorOfAllWords();

    private List<Integer> callMethod(final String str, final String[] words) {
        return substringConcatenatorOfAllWords.findSubstring(str, words);
    }

    @Test
    public void test1() {
        final String[] words = {"foo", "bar"};

        final List<Integer> actual = callMethod("barfoothefoobarman", words);

        final List<Integer> expected = Lists.newArrayList(0, 9);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        final String[] words = {"word", "good", "best", "word"};

        final List<Integer> actual = callMethod("wordgoodgoodgoodbestword", words);

        final List<Integer> expected = Lists.newArrayList();
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test3() {
        final String[] words = {"bar", "foo", "the"};

        final List<Integer> actual = callMethod("barfoofoobarthefoobarman", words);

        final List<Integer> expected = Lists.newArrayList(6, 9, 12);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test4() {
        final String[] words = {"a", "c", "b"};

        final List<Integer> actual = callMethod("abc", words);

        final List<Integer> expected = Lists.newArrayList(0);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test5() {
        final String[] words = {"fooo", "barr", "wing", "ding", "wing"};

        final List<Integer> actual = callMethod("lingmindraboofooowingdingbarrwingmonkeypoundcake", words);

        final List<Integer> expected = Lists.newArrayList(13);
        assertThat(actual, equalTo(expected));
    }



}
