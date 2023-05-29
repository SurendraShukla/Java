package me.surendra.leetcode.search.binary_search;

/**
 * @see <a href="https://leetcode.com/problems/search-insert-position/">Search Insert Position</a>
 */
public class SearchInsertPositionFinder {

    /*
        Time Complexity - O(n long n)
        Space Complexity - O(1)
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right= nums.length-1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

}
