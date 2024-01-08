package me.surendra.leetcode.binary_search;

import java.util.function.Function;


/**
 * @see <a href="https://leetcode.com/problems/guess-number-higher-or-lower/">Guess Number Higher or Lower</a>
 */
public class NumberGuesser {

    /*
        Time complexity : O(log2 n)
        Space complexity: O(1)
     */
    public int guessNumber(int n, final Function<Integer, Integer> guess) {
        int low = 1;
        int max = n;

        while (low <= max) {
            // To handle integer overflow (range) issue after addition
            int mid = ((max -low) / 2) + low;
            final Integer no = guess.apply(mid);
            // Number is higher
            if (no == 1) {
                low = mid + 1;
                // Number is lower
            } else if (no == -1) {
                max = mid - 1;
            }else{
                low = mid;
                break;
            }
        }
        return low;
    }

}
