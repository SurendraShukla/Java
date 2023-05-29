package me.surendra.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/next-permutation/">Next Permutation</a>
 */
public class NextPermutationFinder {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public void nextPermutation(int[] nums) {
        final Queue<Integer> stack = new LinkedList<>();
        int index = nums.length-1;
        int previousNo = nums[index--];
        stack.add(previousNo);

        while(index >=0 && nums[index] >= previousNo) {
            stack.add(nums[index--]);
        }

        if (index >= 0) {
            index--;
            int tmpNo = nums[index];
            nums[index] = previousNo;
            nums[++index] = tmpNo;
        }

        while(!stack.isEmpty()) {
            index++;
            nums[index] = stack.poll();
        }
    }

}
