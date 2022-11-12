package me.surendra.leetcode.dynamic_programming.one_d;


/**
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">Climbing Stairs</a>
 */
public class ClimbingStairs {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int climbStairsUsingFibonacci(final int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            final int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int climbStairsUsingDp(final int n) {
        if (n < 3) {
            return n;
        }
        final int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        int i = 2;
        while (i < n) {
            arr[i] = arr[i - 1] + arr[i - 2];
            i++;
        }
        return arr[i - 1];
    }

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int climbStairsUsingRecursion(final int n) {
        final int[] cache = new int[n + 1];
        return climbStairs(n, cache);
    }

    private int climbStairs(final int n, final int[] cache) {
        if (cache[n] != 0) {
            return cache[n];
        }
        if (n <= 2) {
            return n;
        }
        cache[n] = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
        return cache[n];
    }

}
