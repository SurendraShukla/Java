package me.surendra.leetcode.string.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @see <a href="https://leetcode.com/problems/group-anagrams/">Group Anagrams</a>
 */
public class GroupAnagrams {

    /*
        Time Complexity - O(n * k) - N is the length of strs
                    and k is the maximum length of a string in strs
        Space Complexity- O(n * k)
     */
    public List<List<String>> groupAnagramsCategorizeByCount(final String[] strs) {
        if (strs.length == 0) return new ArrayList();

        final Map<String, List> ans = new HashMap<>();
        final int[] count = new int[26];

        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            final StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            final String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


    /*
        Time Complexity - O(n * k log k) - N is the length of strs
                    and k is the maximum length of a string in strs
        Space Complexity- O(n * k)
     */
    public List<List<String>> groupAnagramsCategorizeBySortedString(final String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            final char[] chars = str.toCharArray();
            Arrays.sort(chars);
            final String key = new String(chars);
            map.computeIfAbsent(key, (k) -> new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

}
