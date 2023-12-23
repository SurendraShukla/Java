package me.surendra.leetcode.prefix_sum;


/**
 * @see <a href="https://leetcode.com/problems/maximum-score-after-splitting-a-string/">Maximum Score After Splitting a String</a>
 */
public class MaximumScoreAfterSplittingString {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int maxScore(final String s) {
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        int ans = 0;
        int zeros = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones--;
            } else {
                zeros++;
            }

            ans = Math.max(ans, zeros + ones);
        }

        return ans;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public int maxScoreUsingPrefixSum(final String s) {
        final int len = s.length() - 1;

        final int[] prefixSumForZero = new int[len + 1];
        prefixSumForZero[0] = (s.charAt(0) == '0') ? 1 : 0;

        final int[] prefixSumForOne = new int[len + 1];
        prefixSumForOne[len] = s.charAt(len) == '0' ? 0 : 1;

        for (int i = 1; i <= len; i++) {
            prefixSumForZero[i] = prefixSumForZero[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
            prefixSumForOne[len - i] = prefixSumForOne[len - i + 1] + (s.charAt(len - i) == '1' ? 1 : 0);
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            result = Math.max(result, prefixSumForZero[i] + prefixSumForOne[i + 1]);
        }

        return result;
    }

}
