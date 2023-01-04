package me.surendra.leetcode.search.binary_search;

/**
 * @see <a href="https://leetcode.com/problems/time-based-key-value-store/">Time Based Key-Value Store</a>
 */
public interface TimeMap {
   void set(String key, String value, int timestamp);
   String get(String key, int timestamp);
}
