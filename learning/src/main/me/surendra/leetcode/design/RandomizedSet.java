package me.surendra.leetcode.design;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * @see <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/">Insert Delete GetRandom O(1)</a>
 */
public class RandomizedSet {

    /*
        Time Complexity - O(1)
        Space Complexity - O(n)
     */
    final Random rand = new Random();
    final List<Integer> list;
    final Map<Integer, Integer> map;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /*
        Time Complexity - O(1)
     */
    public boolean insert(final int val) {
        if (map.containsKey(val)) {
            return false;
        }
        final int lastIdx = list.size();
        list.add(lastIdx, val);
        map.put(val, lastIdx);
        return true;
    }

    /*
        Time Complexity - O(1)
     */
    public boolean remove(final int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        final int valIdx = map.get(val);

        final int lastValIdx = list.size() - 1;
        final int lastVal = list.get(lastValIdx);

        list.set(valIdx, lastVal);
        map.put(lastVal, valIdx);

        map.remove(val);
        list.remove(lastValIdx);

        return true;
    }

    /*
        Time Complexity - O(1)
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

}
