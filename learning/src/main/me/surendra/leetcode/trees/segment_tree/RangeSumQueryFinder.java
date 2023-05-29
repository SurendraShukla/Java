package me.surendra.leetcode.trees.segment_tree;

/**
 * @see <a href="https://leetcode.com/problems/range-sum-query-mutable/">Range Sum Query - Mutable</a>
 */
public class RangeSumQueryFinder {

    /*
        Time Complexity - O(n log n)
        Space Complexity- O(n)
     */
    final int[] segmentTree;
    final int numsLen;
    public RangeSumQueryFinder(final int[] nums) {
        numsLen = nums.length;
        segmentTree = new int[numsLen * 2];

        buildTree(nums);
    }

    /**
     * Leaf nodes get places after nth position
     * Parents information get populated in reverse order (n-1 to 1)
     *      parent[i] = parent[2*i] + parent[2*i+1]
     *  Index 0 is empty (does not hold any information)
     */
    private void buildTree(final int[] nums) {
        for (int i = numsLen, j = 0; i < 2 * numsLen; i++, j++) {
            segmentTree[i] = nums[j];
        }
        for (int i = numsLen - 1; i > 0; --i) {
            segmentTree[i] = segmentTree[i * 2] + segmentTree[i * 2 + 1];
        }
    }

    /**
     * Bottom up approach to update the information
     * First update leaf node (index + n)
     * Afterward update all its parents (n/2)
     */
    public void update(final int index, final int val) {
        int pos = index;
        pos += numsLen;
        segmentTree[pos] = val;

        while (pos > 0) {
             // Leaf node can be Left and Right Child of Parent Node
            int left = pos;
            int right = pos;

            // Left node if leaf node is at even index
            if (pos % 2 == 0) {
                // Right node would be next one
                right = pos + 1;
            // Right node if leaf node is at odd index
            } else {
                // Left node would be previous one
                left = pos - 1;
            }
            segmentTree[pos / 2] = segmentTree[left] + segmentTree[right];
            pos /= 2;
        }
    }

    public int sumRange(final int left, final int right) {
        int leftPos = left + numsLen;
        int rightPos = right + numsLen;

        int sum = 0;
        while (leftPos <= rightPos) {
            if (leftPos % 2 == 1) {
                sum += segmentTree[leftPos];
                leftPos++;
            }
            if (rightPos % 2 == 0) {
                sum += segmentTree[rightPos];
                rightPos--;
            }
            leftPos /= 2;
            rightPos /= 2;
        }
        return sum;
    }

}
