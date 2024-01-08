package me.surendra.leetcode.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TimeMapImplementationUsingBinarySearch implements TimeMap {

    Map<String, List<Pair>> binarySearch;
    public TimeMapImplementationUsingBinarySearch() {
        binarySearch = new HashMap<>();
    }

    /*
        Time complexity: O(l * m) l is key and m is number of set function calls
        Space complexity: O(l * m) l is key and m is number of set function calls
     */
    @Override
    public void set(final String key, final String value, final int timestamp) {
        if (!binarySearch.containsKey(key)) {
            binarySearch.put(key, new ArrayList<>());
        }
        binarySearch.get(key).add(new Pair(timestamp, value));
    }

    /*
        Time complexity: O(n * (l log m) n calls, l is key, m is number of set function calls
        Space complexity: O(n) n calls
     */
    @Override
    public String get(final String key, final int timestamp) {
        if (binarySearch.containsKey(key)) {
            return getValueByBinarySearch(key, timestamp);
        }
        return "";
    }

    private String getValueByBinarySearch(final String key, final int timestamp) {
        final List<Pair> pairs = binarySearch.get(key);
        int left = 0;
        int right = pairs.size() - 1;
        if (pairs.get(right).ts <= timestamp) {
            return pairs.get(right).val;
        }

        while (left <= right) {
            final int mid = left + ((right - left) / 2);
            final int midTimestamp = pairs.get(mid).ts;
            if (timestamp == midTimestamp) {
                return pairs.get(mid).val;
            }
            if (timestamp > midTimestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right < 0 ? "" : pairs.get(right).val;
    }

    class Pair {
        int ts;
        String val;
        Pair(final int ts, final String val) {
            this.ts = ts;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Pair{" +
                "ts=" + ts +
                ", val='" + val + '\'' +
                '}';
        }
    }

}

