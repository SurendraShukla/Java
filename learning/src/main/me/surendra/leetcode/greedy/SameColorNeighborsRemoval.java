package me.surendra.leetcode.greedy;


/**
 * @see <a href="https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/">Remove Colored Pieces if Both Neighbors are the Same Color</a>
 */
public class SameColorNeighborsRemoval {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public boolean winnerOfGame(final String colors) {
        int aCount = 0;
        int bCount = 0;
        int curCharCount = 1;
        char prevChar = colors.charAt(0);

        for (int i = 1; i < colors.length(); i++) {
            final char currentChar = colors.charAt(i);
            if (currentChar == prevChar) {
                curCharCount++;
            } else {
                if (curCharCount > 2) {
                    final int diff = curCharCount - 2;
                    if (prevChar == 'A') {
                        aCount += diff;
                    } else {
                        bCount += diff;
                    }
                }
                prevChar = currentChar;
                curCharCount = 1;
            }
        }

        if (curCharCount > 2) {
            final int diff = curCharCount - 2;
            if (prevChar == 'A') {
                aCount += diff;
            } else {
                bCount += diff;
            }
        }

        return aCount > bCount;
    }

}
