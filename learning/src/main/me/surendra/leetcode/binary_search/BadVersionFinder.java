package me.surendra.leetcode.binary_search;

/**
 * @see <a href="https://leetcode.com/problems/first-bad-version/">First Bad Version</a>
 */
public class BadVersionFinder {

    /*
        Time Complexity - O(n long n)
        Space Complexity - O(1)
     */
    public int firstBadVersion(final int n) {
        int left = 0;
        int right = n;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(final int no) {
        return no > 3;
    }

}
