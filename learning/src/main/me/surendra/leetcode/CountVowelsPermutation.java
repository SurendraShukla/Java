package me.surendra.leetcode;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a herf="https://leetcode.com/problems/count-vowels-permutation/">Count Vowels Permutation</a>
 */
public class CountVowelsPermutation {

    private static int mod = 1000000007;
    final Map<String, Long> cache = new HashMap<>();
    public int countVowelPermutation(final int n) {
        final List<Character> chars = Arrays.asList('a', 'e', 'i', 'o', 'u');

        long total = 0;
        for (final Character ch: chars) {
            total = (total + countVowelPermutation(ch, n)) % mod;
        }
        return (int)total;
    }

    private Map<Character, List<Character>> getCharacterRules() {
        final Map<Character, List<Character>> characterRules = new HashMap<>();
        characterRules.put('a', Lists.newArrayList('e'));
        characterRules.put('e', Lists.newArrayList('a', 'i'));
        characterRules.put('i', Lists.newArrayList('a', 'e', 'o', 'u'));
        characterRules.put('o', Lists.newArrayList('i', 'u'));
        characterRules.put('u', Lists.newArrayList('a'));
        return characterRules;
    }

    private long countVowelPermutation(final char ch, final int n) {
        if (n == 1) {
            return 1;
        }
        final String key = ch + "_" + n;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        switch (ch) {
            case 'a':
                cache.put(key, countVowelPermutation('e', n - 1) % mod);
                break;
            case 'e':
                cache.put(key, (countVowelPermutation('a', n - 1)
                    + countVowelPermutation('i', n - 1))  % mod);
                break;
            case 'i':
                cache.put(key, (countVowelPermutation('a', n - 1)
                    + countVowelPermutation('e', n - 1)
                    + countVowelPermutation('o', n - 1)
                    + countVowelPermutation('u', n - 1)) % mod);
                break;
            case 'o':
                cache.put(key,
                    (countVowelPermutation('i', n - 1)
                        + countVowelPermutation('u', n - 1)) % mod);
                break;
            case 'u':
                cache.put(key,
                    countVowelPermutation('a', n - 1) % mod);
                break;
        }
        return cache.get(key);
    }

    private int[] getFirstAndLastIndexOfConsequetiveOne(final int nums[]) {
        int maxOneCount = 0;
        Integer lastPreviousIndex = -1;

        int currentOneCount = 0;
        Integer currentPreviousIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currentPreviousIndex = -1;
                currentOneCount = 0;
                continue;
            }
            if (currentPreviousIndex == -1) {
                currentPreviousIndex = i;
                currentOneCount = 1;
            } else {
                currentOneCount++;
            }

            if (currentOneCount > maxOneCount) {
                lastPreviousIndex = currentPreviousIndex;
                maxOneCount = currentOneCount;
            }
        }
        if (currentOneCount > maxOneCount) {
            lastPreviousIndex = currentPreviousIndex;
            maxOneCount = currentOneCount;
        }

        final int[] returnArr = new int[2];
        if (lastPreviousIndex == -1) {
            returnArr[0] = -1;
            returnArr[1] = -1;
        } else {
            returnArr[0] = lastPreviousIndex;
            returnArr[1] = lastPreviousIndex + maxOneCount - 1;
        }
        return returnArr;
    }

    public static void main(final String[] args) {
        callMethod(new int[]{0});
        callMethod(new int[]{1});
        callMethod(new int[]{1, 1, 0, 1, 1, 1});
    }

    private static void callMethod(final int[] nums) {
        final int[] result = new CountVowelsPermutation().getFirstAndLastIndexOfConsequetiveOne(nums);
        System.out.println(result[0] + ":" + result[1]);
    }

}
