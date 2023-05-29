package me.surendra.leetcode.trees.trie;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-pairs/">Palindrome Pairs</a>
 */
public class PalindromePairsFinder {

    class TrieNode {
        TrieNode[] trieNodes = new TrieNode[26];
        boolean wordEnd = false;
        Integer wordIndex;

        TrieNode() {
        }

        void put(final char aChar, final TrieNode trieNode) {
            trieNodes[aChar - 'a'] = trieNode;
        }

        TrieNode get(final char aChar) {
            return trieNodes[aChar - 'a'];
        }

        boolean contains(final char aChar) {
            return trieNodes[aChar - 'a'] != null;
        }

        void setWordEnd() {
            wordEnd = true;
        }

        boolean isWordEnd() {
            return wordEnd;
        }

        void setWordIndex(final int index) {
            wordIndex = index;
        }

        Integer getWordIndex() {
            return wordIndex;
        }
    }
    class Trie {
        TrieNode trieNode;
        Trie() {
            trieNode = new TrieNode();
        }

        void add(final String str, final int indexPosition) {
            TrieNode currentTrieNode = trieNode;
            for (char aChar: str.toCharArray()) {
                if (!currentTrieNode.contains(aChar)) {
                    currentTrieNode.put(aChar, new TrieNode());
                }
                currentTrieNode = currentTrieNode.get(aChar);
            }
            currentTrieNode.setWordEnd();
            currentTrieNode.setWordIndex(indexPosition);
        }

        Integer contains(final char[] chars) {
            TrieNode currentTrieNode = trieNode;
            for (char aChar: chars) {
                if (currentTrieNode.contains(aChar)) {
                    currentTrieNode = currentTrieNode.get(aChar);
                } else {
                    return null;
                }
            }
            return currentTrieNode.getWordIndex();
        }

    }

    public List<List<Integer>> palindromePairs(final String[] words) {
        final Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.add(words[i], i);
        }

        final List<List<Integer>> returnDistinctIndicesList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            final Integer wordIndex = getPalindromeWordIndex(words[i], trie);
            if (wordIndex == null || wordIndex == i) {
            } else {
                returnDistinctIndicesList.add(Arrays.asList(i, wordIndex));
            }
        }

        return returnDistinctIndicesList;
    }

    private Integer getPalindromeWordIndex(final String word, final Trie trie) {
        int lastIndex = word.length();

        int idx1 = 0;
        final char[] chars = new char[lastIndex];
        lastIndex--;
        chars[idx1] = word.charAt(lastIndex);

        int idx2 = -1;
        final char[] charsExceptLastCharacter = new char[lastIndex];

        while (lastIndex > 0) {
            lastIndex--;
            idx1++;
            idx2++;
            chars[idx1] = word.charAt(lastIndex);
            charsExceptLastCharacter[idx2] = word.charAt(lastIndex);
        }

        final Integer wordIndex = trie.contains(chars);
        if (wordIndex != null) {
            return wordIndex;
        }

        return trie.contains(charsExceptLastCharacter);
    }

}
