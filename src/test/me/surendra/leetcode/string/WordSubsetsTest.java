package me.surendra.leetcode.string;


import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.PriorityQueue;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class WordSubsetsTest {

    private List<String> callMethod(final String[] words1, final String[] words2) {
        final List<String> actual = new WordSubsets().wordSubsets(words1, words2);
        return actual;
    }

    @Test
    public void test1() {
        final String[] words1 = {"warrior", "world"};
        final String[] words2 = {"wrr"};

        final List<String> actual = callMethod(words1, words2);

        final List<String> expected = Lists.newArrayList("warrior");
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        final String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        final String[] words2 = {"e", "o"};

        final List<String> actual = callMethod(words1, words2);

        final List<String> expected = Lists.newArrayList("facebook", "google", "leetcode");
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test3() {
        final String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        final String[] words2 = {"l", "e"};

        final List<String> actual = callMethod(words1, words2);

        final List<String> expected = Lists.newArrayList("apple", "google", "leetcode");
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test4() {
        final String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        final String[] words2 = {"oo", "o"};

        final List<String> actual = callMethod(words1, words2);

        final List<String> expected = Lists.newArrayList( "facebook", "google");
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test5() {
        final String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        final String[] words2 = {"ooo", "o"};

        final List<String> actual = callMethod(words1, words2);

        final List<String> expected = Lists.newArrayList();
        assertThat(actual, equalTo(expected));
    }

}
