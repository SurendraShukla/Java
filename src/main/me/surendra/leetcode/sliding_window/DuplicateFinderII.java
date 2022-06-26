package me.surendra.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/**
 * @see <a href="https://leetcode.com/problems/contains-duplicate-ii/">Contains Duplicate II</a>
 */
public class DuplicateFinderII {

    /*
        Time complexity : O(n)
        Space complexity: O(k)
    */
    public boolean containsNearbyDuplicateUsingHashSetToKeepLastKElements(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    /*
        Time complexity : O(n * log n)
        Space complexity: O(k)
    */
    public boolean containsNearbyDuplicateUsingTreeSetToKeepLastKElements(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    /*
        Time complexity : O(n*k)
        Space complexity: O(1)
    */
    public boolean containsNearbyDuplicateByLinearSearchForPreviousKElements(int[] nums, int k) {
        for(int i=0; i<nums.length; i++) {
            for(int j=Math.max(i-k, 0); j<i; i++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)

        Look for last index should be sufficient to get index diff which is less or equal to k
     */
    public boolean containsNearUsingSlidingWindowToKeepOnlyLastIndex(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();

        for(int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            final int val = nums[currentIndex];

            if (map.containsKey(val)) {
                final Integer previousIndex = map.get(val);

                if (Math.abs(currentIndex - previousIndex) <= k) {
                    return true;
                }
            }

            map.put(val, currentIndex);
        }
        return false;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public boolean containsNearbyDuplicateUsingPreviousIndexesInHashMap(int[] nums, int k) {
        final Map<Integer, List<Integer>> seenValuesHashMap = new HashMap<>();

        for(int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int val = nums[currentIndex];
            List<Integer> seenValIndexes;

            if (seenValuesHashMap.containsKey(val)) {
                seenValIndexes = seenValuesHashMap.get(val);

                for(Integer previousIndex: seenValIndexes) {
                    if (Math.abs(currentIndex-previousIndex) <= k) {
                        return true;
                    }
                }

            }else{
                seenValIndexes = new ArrayList<>();
            }

            seenValIndexes.add(currentIndex);
            seenValuesHashMap.put(val, seenValIndexes);
        }
        return false;
    }

}
