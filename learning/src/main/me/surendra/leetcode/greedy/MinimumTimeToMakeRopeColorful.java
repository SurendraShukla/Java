package me.surendra.leetcode.greedy;


/**
 * @see <a href="https://leetcode.com/problems/minimum-time-to-make-rope-colorful/">Minimum Time to Make Rope Colorful</a>
 */
public class MinimumTimeToMakeRopeColorful {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int minCost(final String colors, final int[] neededTime) {
        int result = 0;
        int windowMaxTime = 0;
        int windowTotalTime = 0;
        char prevChar = ' ';
        for (int i = 0; i < neededTime.length; i++) {
            if (prevChar != colors.charAt(i)) {
                result += windowTotalTime - windowMaxTime;
                windowMaxTime = neededTime[i];
                windowTotalTime = neededTime[i];
                prevChar = colors.charAt(i);
            } else {
                windowMaxTime = Math.max(windowMaxTime, neededTime[i]);
                windowTotalTime += neededTime[i];
            }
        }

        result += windowTotalTime - windowMaxTime;

        return result;
    }

    public int minCost2Pointers(final String colors, final int[] neededTime) {
        // Initalize two pointers i, j.
        int totalTime = 0;
        int left = 0, right = 0;

        while (left < neededTime.length) {
            int currTotal = 0, currMax = 0;

            // Find all the balloons having the same color as the
            // balloon indexed at i, record the total removal time
            // and the maximum removal time.
            while (right < neededTime.length && colors.charAt(left) == colors.charAt(right)) {
                currTotal += neededTime[right];
                currMax = Math.max(currMax, neededTime[right]);
                right++;
            }

            // Once we reach the end of the current group, add the cost of
            // this group to total_time, and reset two pointers.
            totalTime += currTotal - currMax;
            left = right;
        }
        return totalTime;
    }

}
