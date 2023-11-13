package me.surendra.leetcode.string;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/sort-vowels-in-a-string/">Sort Vowels in a String</a>
 */
public class VowelsSorter {

    public String sortVowels(final String s) {
        final char[] sChars = s.toCharArray();
        final Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        final List<Character> vowels = new ArrayList<>();
        for (char ch: sChars) {
            if (vowelSet.contains(ch)) {
                vowels.add(ch);
            }
        }

        Collections.sort(vowels);

        int vowelIdx = 0;
        final StringBuilder sb = new StringBuilder();
        for (char ch: sChars) {
            if (vowelSet.contains(ch)) {
                sb.append(vowels.get(vowelIdx++));
            } else {
                sb.append(ch);
            }
        }


        return sb.toString();
    }

}
