package me.surendra.leetcode.array.two_pointers.unmodifying;

/**
 * @see <a href="https://leetcode.com/problems/remove-element/">Remove Element</a>
 */
public class ElementRemoval {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int removeElementUsingCopyDataOnlyWhenNeeded(final int[] nums, final int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                // reduce array size by one
                right--;
            } else {
                left++;
            }
        }
        return right;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int removeElementUsingCopyFromStarting(final int[] nums, final int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int removeElementGetBothIndexPositionFirst(final int[] nums, final int val) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            }
            return 1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (right > 0 && nums[right] == val) {
                right--;
            }
            while (left < nums.length && nums[left] != val) {
                left++;
            }
            if (left < right) {
                nums[left] = nums[right];
                nums[right] = val;
            }
        }
        return left;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int removeElementRightIndexCalculatedWhenNeeded(final int[] nums, final int target) {
        final int length = nums.length;
        if (length == 1) {
            return length;
        }

        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (nums[left] == target) {
                right = getNonTargetIndex(nums, target, right);
                nums[left] = nums[right];
                nums[right] = target;
            }
            left++;
        }
        return left;
    }

    private int getNonTargetIndex(final int[] nums, final int target, final int index) {
        int returnIndex = index;
        while (nums[returnIndex] == target) {
            returnIndex--;
        }
        return returnIndex;
    }

}
