package me.surendra.leetcode.dynamic_programming;


/**
 * @see <a href="https://leetcode.com/problems/decode-ways/">Decode Ways</a>
 */
public class DecodeWays {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    int len;
    String str;
    Integer[] cache;
    public int numDeCodings(final String s) {
        str = s;
        len = s.length();
        cache = new Integer[len];

        return numDeCodings(0);
    }

    private int numDeCodings(final int idx) {
        if (idx == len) {
            return 1;
        }
        if (cache[idx] != null) {
            return cache[idx];
        }
        if (str.charAt(idx) == '0') {
            return 0;
        }

        int result = numDeCodings(idx + 1);
        if (idx < len - 1) {
            final int no = Integer.parseInt(str.substring(idx, idx + 2));
            if (no < 27) {
                result += numDeCodings(idx + 2);
            }
        }

        cache[idx] = result;
        return result;
    }

}
