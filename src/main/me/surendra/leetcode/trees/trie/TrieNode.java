package me.surendra.leetcode.trees.trie;


public class TrieNode {

    private static final int CHAR_ARR_LEN = 26;
    private TrieNode[] trieNodes;
    private boolean isEnd;

    public TrieNode() {
        trieNodes = new TrieNode[CHAR_ARR_LEN];
    }

    public boolean containsKey(final char ch) {
        return trieNodes[ch - 'a'] != null;
    }

    public TrieNode get(final char ch) {
        return trieNodes[ch - 'a'];
    }

    public void put(final char ch, final TrieNode trieNode) {
        this.trieNodes[ch - 'a'] = trieNode;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }

}
