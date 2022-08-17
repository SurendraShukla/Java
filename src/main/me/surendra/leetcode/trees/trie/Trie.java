package me.surendra.leetcode.trees.trie;

public class Trie {
    TrieNode trieNode;

    public Trie() {
        trieNode = new TrieNode();
    }

    /**
     * Initialize: cur = root
     * for each char c in target string S:
     *      if cur does not have a child c:
     *          cur.children[c] = new Trie node
     *      cur = cur.children[c]
     * cur is the node which represents the string S
     */
    public void insert(final String word) {
        TrieNode currentTrieNode = trieNode;
        for (int i = 0; i < word.length(); i++) {
            if (!currentTrieNode.containsKey(word.charAt(i))) {
                currentTrieNode.put(word.charAt(i), new TrieNode());
            }
            currentTrieNode = currentTrieNode.get(word.charAt(i));
        }
        currentTrieNode.setEnd();
    }

    /**
     * Initialize: cur = root
     * for each char c in target string S:
     *   if cur does not have a child c:
     *     search fails
     *   cur = cur.children[c]
     * search successes
     */
    public TrieNode startsPrefix(final String prefix) {
        TrieNode currentTrieNode = trieNode;
        for (int i = 0; i < prefix.length(); i++) {
            if (!currentTrieNode.containsKey(prefix.charAt(i))) {
                return null;
            }
            currentTrieNode = currentTrieNode.get(prefix.charAt(i));
        }
        return currentTrieNode;
    }

    public boolean search(final String word) {
        final TrieNode currentTrieNode = startsPrefix(word);
        return currentTrieNode != null && currentTrieNode.isEnd();
    }

    public boolean startsWith(final String prefix) {
        final TrieNode currentTrieNode = startsPrefix(prefix);
        return currentTrieNode != null;
    }

}
