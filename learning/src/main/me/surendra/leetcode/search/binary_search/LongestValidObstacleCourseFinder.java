package me.surendra.leetcode.search.binary_search;


/**
 * @see <a href="https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/">Find the Longest Valid Obstacle Course at Each Position</a>
 */
public class LongestValidObstacleCourseFinder {

    /*
        Time Complexity - O(n log n) Binary search (log n) for each element (n)
        Space Complexity - O(1)
     */
    public int[] longestObstacleCourseAtEachPosition(final int[] obstacles) {
        final int n = obstacles.length;
        int lisLength = 0;

        // lis[i] records the lowest increasing sequence of length i + 1.
        final int[] answer = new int[n];
        final int[] lis = new int[n];

        for (int i = 0; i < n; ++i) {
            final int height = obstacles[i];
            // Find the rightmost insertion position idx.
            final int idx = bisectRight(lis, height, lisLength);
            if (idx == lisLength)
                lisLength++;

            lis[idx] = height;
            answer[i] = idx + 1;
        }
        return answer;
    }

    // Find the rightmost insertion position. We use a fixed-length array and a changeable right boundary
    // to represent an arraylist of dynamic size.
    private int bisectRight(final int[] arr, final int target, final int r) {
        if (r == 0) {
            return 0;
        }
        int left = 0;
        int right = r;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }


}
