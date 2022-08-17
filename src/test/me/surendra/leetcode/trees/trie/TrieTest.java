package me.surendra.leetcode.trees.trie;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TrieTest {

    @Test
    public void test() {
        final Trie trie = new Trie();

        trie.insert("apple");
        assertThat(trie.search("apple"), equalTo(true));
        assertThat(trie.search("app"), equalTo(false));
        assertThat(trie.startsWith("app"), equalTo(true));

        trie.insert("app");
        assertThat(trie.search("app"), equalTo(true));

        assertThat(trie.search("apples"), equalTo(false));
        trie.insert("apples");
        assertThat(trie.search("apples"), equalTo(true));
    }
}
