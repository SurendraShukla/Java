package me.surendra.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Letter Combinations of a Phone Number</a>
 */
public class LetterCombinations {

    final private List<String> combinations = new ArrayList<>();
    final private Map<Character, String> letters = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    private String phoneDigits;

    /*
        Time complexity: O(4^n * n)
        Space complexity: O(n)
     */
    public List<String> letterCombinationsUsingBacktracking(String digits) {
        // If the input is empty, immediately return an empty answer array
        if (digits.length() == 0) {
            return combinations;
        }

        // Initiate backtracking with an empty path and starting index of 0
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private void backtrack(int index, StringBuilder path) {
        // If the path is the same length as digits, we have a complete combination
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return; // Backtrack
        }

        // Get the letters that the current digit maps to, and loop through them
        final String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (final char letter: possibleLetters.toCharArray()) {
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }

    /*
        Time complexity: O(4^n * n)
        Space complexity: O(n)
     */
    final static Map<Integer, List<Character>> phoneButtons = new HashMap<Integer, List<Character>>() {{
        put(2, Arrays.asList('a', 'b', 'c'));
        put(3, Arrays.asList('d', 'e', 'f'));
        put(4, Arrays.asList('g', 'h', 'i'));
        put(5, Arrays.asList('j', 'k', 'l'));
        put(6, Arrays.asList('m', 'n', 'o'));
        put(7, Arrays.asList('p', 'q', 'r','s'));
        put(8, Arrays.asList('t', 'u', 'v'));
        put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }};
    public List<String> letterCombinations(String digits) {
        if (digits.length() < 1) {
            return new ArrayList<>();
        }
        Set<String> letterCombination = getCharacters(digits.charAt(0))
            .stream()
            .parallel()
            .map(aChar -> Character.toString(aChar))
            .collect(Collectors.toSet());

        for (int i = 1; i < digits.length(); i++) {
            final List<Character> characterList = getCharacters(digits.charAt(i));
            final Set<String> tmpLetterCombination = new HashSet<>();
            for (final Character aChar : characterList) {
                for (String str : letterCombination) {
                    tmpLetterCombination.add(str + aChar);
                }
            }
            letterCombination = tmpLetterCombination;
        }

        List<String> returnList = letterCombination.stream().parallel().collect(Collectors.toList());
        return returnList;
    }

    private List<Character> getCharacters(final char ch) {
        final Integer key = Character.getNumericValue(ch);
        return phoneButtons.get(key);
    }


}
