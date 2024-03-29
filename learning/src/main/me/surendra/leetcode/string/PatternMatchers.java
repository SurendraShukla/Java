package me.surendra.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/find-and-replace-pattern/">Find and Replace Pattern</a>
 */
public class PatternMatchers {

    /**
        Time Complexity - O(n * k) N is the number of words, and K is the length of each word.
        Space Complexity - O(n * k)

        Character count for current index should match in both string
     */
    public static List<String> findAndReplacePatternByCheckingCharacterCountAtPosition(final String[] words, final String pattern) {
        final List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (checkPattern(words[i], pattern)) {
                list.add(words[i]);
            }
        }
        return list;
    }

    /*
         Character count for current index should match in both string
     */
    private static boolean checkPattern(final String word, final String pattern) {
        for (int i = 0; i < word.length(); i++) {
            if (word.indexOf(word.charAt(i)) != pattern.indexOf(pattern.charAt(i)))
                return false;
        }
        return  true;
    }


    /**
         Time Complexity - O(n * k) N is the number of words, and K is the length of each word.
         Space Complexity - O(n * k)

         2 Maps for mapping pattern and word character
             HashMap<PatternCharacter, WordCharacter>
             HashMap<WordCharacter, PatternCharacter>
     */
    public List<String> findAndReplacePatternByMappingWordAndPatternCharacters(final String[] words, final String pattern) {
        final List<String> result = new ArrayList<>();
        for (String word: words) {
            if (match(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    /*
        2 Maps for mapping pattern and word character
            HashMap<PatternCharacter, WordCharacter>
            HashMap<WordCharacter, PatternCharacter>

        Search for word character should give pattern charcter and vice versa
     */
    public boolean match(final String pattern, final String word) {
        final Map<Character, Character> m1 = new HashMap();
        final Map<Character, Character> m2 = new HashMap();

        for (int i = 0; i < word.length(); ++i) {
            final char w = word.charAt(i);
            final char p = pattern.charAt(i);

            if (!m1.containsKey(w)) {
                m1.put(w, p);
            }
            if (!m2.containsKey(p)) {
                m2.put(p, w);
            }

            if (m1.get(w) != p || m2.get(p) != w) {
                return false;
            }
        }
        return true;
    }


    /**
        Time Complexity - O(n * k) N is the number of words, and K is the length of each word.
        Space Complexity - O(n * k)

        HashMap to store character and its first index
            HashMap<Character, CharacterFirstIndex>
        int[] to store pattern
            "abba" => [0110]
     */
    private int[] characterAppearancePattern;
    private int patternCharLength;
    public List<String> findAndReplacePatternIdentifyPatternFirst(final String[] words, final String pattern) {
        patternCharLength = pattern.length();
        characterAppearancePattern = getPattern(pattern);

        final List<String> matchedStringList = new ArrayList<>();
        for (String word: words) {
            if (wordMatchesToPattern(word)) {
                matchedStringList.add(word);
            }
        }
        return matchedStringList;
    }

    private boolean wordMatchesToPattern(final String word) {
        final int[] characterPattern = getPattern(word);
        for (int i = 0; i < patternCharLength; i++) {
            if (characterAppearancePattern[i] != characterPattern[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getPattern(final String str) {
        final Map<Character, Integer> characterFirstIndexMap = new HashMap<>();
        final int[] charactersAppearingSequence = new int[patternCharLength];

        for (int idx = 0; idx < patternCharLength; idx++) {
            final char aChar = str.charAt(idx);
            int charFirstIndex = idx;
            if (characterFirstIndexMap.containsKey(aChar)) {
                charFirstIndex = characterFirstIndexMap.get(aChar);
            } else {
                characterFirstIndexMap.put(aChar, charFirstIndex);
            }
            charactersAppearingSequence[idx] = charFirstIndex;
        }

        return charactersAppearingSequence;
    }

}
