package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class KthSmallestElementInBSTFinderTest {

    private int callMethod(final TreeNode root, final int k) {
        final KthSmallestElementInBSTFinder kthSmallestElementInBSTFinder = new KthSmallestElementInBSTFinder();
        return kthSmallestElementInBSTFinder.kthSmallest(root, k);
    }

    private void callAndVerify(final TreeNode root, final int minVal, final int maxVal) {
        for (int i = minVal; i < maxVal; i++) {
            final int no = callMethod(root, i);
            assertThat("Failed for " + no, no, equalTo(i));
        }
    }

    @Test
    public void test1() {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(3, 1, 4, null, 2);

        callAndVerify(root, 1, 5);
    }

    @Test
    public void test2() {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(5, 3, 6, 2, 4, null, null, 1);

        callAndVerify(root, 1, 7);
    }

}
