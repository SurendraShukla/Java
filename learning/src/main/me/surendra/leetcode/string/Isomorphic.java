package me.surendra.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/isomorphic-strings/">Isomorphic Strings</a>
 */
public class Isomorphic {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public boolean isIsomorphic(String s, String t) {
        /*
            Key => Char from 1st String
            Val => Char from 2nd String

            If key (char from 1st string) is getting repeated,
                Val (char from 2nd string) should be repeated.
         */
        final Map<Character, Character> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char keyChar = s.charAt(i);
            char valChar = t.charAt(i);
            if(characterMap.containsKey(keyChar)) {
                final char expectedChar = characterMap.get(keyChar);
                if (valChar != expectedChar) {
                    return false;
                }
            }else{
                characterMap.put(keyChar, valChar);
            }
        }

        /*
            Val (Char from 2nd string) should not have multiple
            KEy (Char from 1st string)
         */
        final Set<Character> characters = new HashSet<>();
        for (final Map.Entry<Character, Character> characterEntry : characterMap.entrySet()) {
            final char aChar = characterEntry.getValue();
            if (characters.contains(aChar)) {
                return false;
            }
            characters.add(aChar);
        }

        return true;
    }
}
