package me.surendra.leetcode.hash_map;


import java.util.HashMap;
import java.util.Map;



/**
 * @see <a href="https://leetcode.com/problems/count-nice-pairs-in-an-array/">Count Nice Pairs in an Array</a>
 */
public class CountNicePairs {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    final int mod = (int) 1e9 + 7;
    public int countNicePairs(final int[] nums) {
        final int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] - rev(nums[i]);
        }

        final Map<Integer, Integer> dic = new HashMap();
        int ans = 0;
        for (int num : arr) {
            ans = (ans + dic.getOrDefault(num, 0)) % mod;
            dic.put(num, dic.getOrDefault(num, 0) + 1);
        }

        return ans;
    }

    private int rev(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }

}
