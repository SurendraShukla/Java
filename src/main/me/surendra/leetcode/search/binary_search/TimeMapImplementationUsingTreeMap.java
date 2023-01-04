package me.surendra.leetcode.search.binary_search;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeMapImplementationUsingTreeMap implements TimeMap {

    HashMap<String, TreeMap<Integer, String>> keyTimeMap;

    public TimeMapImplementationUsingTreeMap() {
        keyTimeMap = new HashMap<String, TreeMap<Integer, String>>();
    }

    /*
        Time complexity: O(l * m log m) l is key and m is number of set function calls
        Space complexity: O(l * m) l is key and m is number of set function calls
     */
    @Override
    public void set(final String key, final String value, final int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new TreeMap<Integer, String>());
        }

        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap.get(key).put(timestamp, value);
    }

    /*
        Time complexity: O(n * (l log m + log m) n calls, l is key, m is number of set function calls
        Space complexity: O(n) n calls
     */
    @Override
    public String get(final String key, final int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }

        final Integer floorKey = keyTimeMap.get(key).floorKey(timestamp);
        // Return searched time's value, if exists.
        if (floorKey != null) {
            return keyTimeMap.get(key).get(floorKey);
        }

        return "";
    }
}
