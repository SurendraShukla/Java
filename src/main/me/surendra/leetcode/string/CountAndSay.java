package me.surendra.leetcode.string;

/**
 * @see <a href="https://leetcode.com/problems/count-and-say/">Count and Say</a>
 */
public class CountAndSay {

    /*
        Time complexity : O(4 ^ n/3)
        Space complexity: O(4 ^ n/3)
    */
    public String countAndSay(final int n) {
        if (n == 1) {
            return "1";
        }

        final String str = countAndSay(n - 1);
        int count = 0;
        char previousChar = str.charAt(0);

        final StringBuilder countAndSayStr = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == previousChar) {
                count++;
            } else {
                countAndSayStr.append(count).append(previousChar);
                count = 1;
                previousChar = str.charAt(j);
            }
        }
        return countAndSayStr.append(count).append(previousChar).toString();
    }

}
