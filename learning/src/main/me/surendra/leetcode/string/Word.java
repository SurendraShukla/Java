package me.surendra.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class Word {

    /**
     *
     * @param pattern
     * @param str
     * @return boolean
     * @see <a href="https://leetcode.com/problems/word-pattern/">Word Pattern - Easy</a>
     */
    public static boolean wordPattern(final String pattern, final String str) {
        final String[] words = str.split(" ");
        final char[] chars = pattern.toCharArray();

        if (words.length != chars.length) {
            return false;
        }

        final Map<String, Character> charStringMap = new HashMap<>();
        final Map<Character, String> stringCharMap = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            final Character c = chars[i];
            final String word  = words[i];

            if (charStringMap.containsKey(word)) {
                final Character mappedChar = charStringMap.get(word);
                if(!mappedChar.equals(c)) {
                    return false;
                }
            }else if (stringCharMap.containsKey(c)) {
                final String mappedWord = stringCharMap.get(c);
                if(!mappedWord.equals(word)) {
                    return false;
                }
            }else{
                charStringMap.put(word, c);
                stringCharMap.put(c, word);
            }

        }
        return true;
    }
}
