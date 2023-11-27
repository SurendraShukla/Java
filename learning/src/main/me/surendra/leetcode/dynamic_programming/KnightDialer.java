package me.surendra.leetcode.dynamic_programming;

/**
 * @see <a href="https://leetcode.com/problems/knight-dialer/">Knight Dialer</a>
 */
public class KnightDialer {

    int mod =  1_000_000_007;
    Integer[][] cache;
    int[][] jumps = {
        {4, 6},
        {6, 8},
        {7, 9},
        {4, 8},
        {3, 9, 0},
        {},
        {1, 7, 0},
        {2, 6},
        {1, 3},
        {2, 4}
    };

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public int knightDialer(final int n) {
        cache = new Integer[10][n + 1];

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + knightDialer(i, n - 1))  % mod;
        }
        return result;
    }


    private int knightDialer(final int prevNo, final int remain) {
        if (remain == 0) {
            return 1;
        }
        if (cache[prevNo][remain] != null) {
            return cache[prevNo][remain];
        }

        int result = 0;
        for (int no: jumps[prevNo]) {
            result = (result + knightDialer(no, remain - 1)) % mod;
        }

        cache[prevNo][remain] = result;
        return result;
    }

}
