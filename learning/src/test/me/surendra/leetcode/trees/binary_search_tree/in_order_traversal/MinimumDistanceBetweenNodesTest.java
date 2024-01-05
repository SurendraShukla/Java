package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MinimumDistanceBetweenNodesTest {

    private static int callMethod(final Integer... integers) {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(integers);

        return new MinimumDistanceBetweenNodes().minDiffInBST(root);
    }

    @Test
    public void test() {
        assertThat(callMethod(4, 2, 6, 1, 3), equalTo(1));
        assertThat(callMethod(1, 0, 48, null, null, 12, 49), equalTo(1));
        assertThat(callMethod(90, 69, null, 49, 89, null, 52), equalTo(1));
        assertThat(callMethod(956, 267, 961, 7, 296, null, 981, null, 138, null, 496, null, null, null, 263, 362, 638, null, null, 308, 409, null, 703, null, 322, null, null, null, 769, null, null, null, 883, 808, 945, null, null, 915), equalTo(4));
    }

}
