package me.surendra.leetcode.string;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class FindAndReplacerTest {

    FindAndReplacer findAndReplacer;

    @Before
    public void setUp() throws Exception {
        findAndReplacer = new FindAndReplacer();
    }

    @Test
    public void shouldFindAndReplace1() {
        int[] indexes = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};

        final String replacedString = findAndReplacer.findReplaceString("abcd", indexes, sources, targets);

        assertThat(replacedString, equalTo("eeebffff"));
    }

    @Test
    public void shouldFindAndReplace2() {
        int[] indexes = {0, 2};
        String[] sources = {"ab", "ec"};
        String[] targets = {"eee", "ffff"};

        final String replacedString = findAndReplacer.findReplaceString("abcd", indexes, sources, targets);

        assertThat(replacedString, equalTo("eeecd"));
    }

}
