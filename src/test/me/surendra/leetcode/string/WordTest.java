package me.surendra.leetcode.string;

import junit.framework.TestCase;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class WordTest extends TestCase {

    public void testForPatterns() {
        assertThat(Word.wordPattern("abba", "dog cat cat dog"), equalTo(true));
        assertThat(Word.wordPattern("abba", "dog cat cat fish"), equalTo(false));
        assertThat(Word.wordPattern("aaaa", "dog cat cat dog"), equalTo(false));
        assertThat(Word.wordPattern("abba", "dog dog dog dog"), equalTo(false));
    }

    public void lengthIsNotSame() {
        assertThat(Word.wordPattern("aaa", "aa aa aa aa"), equalTo(false));
    }

}
