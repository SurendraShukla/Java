package me.surendra.leetcode.trees.depth_first_search.post_order_traversal;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BinaryTreeMaximumPathSumFinderTest {

    private int callMethod(final Integer ...integers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(integers);

        return new BinaryTreeMaximumPathSumFinder().maxPathSum(treeNode);
    }

    @Test
    public void test() {
        assertThat(callMethod(0), equalTo(0));
        assertThat(callMethod(1), equalTo(1));
        assertThat(callMethod(-3), equalTo(-3));
        assertThat(callMethod(2, -1), equalTo(2));
        assertThat(callMethod(-2, -1), equalTo(-1));
        assertThat(callMethod(1, 2, 3), equalTo(6));
        assertThat(callMethod(1, -2, 3), equalTo(4));
        assertThat(callMethod(1, -2, -3, 1, 3, -2, null, -1), equalTo(3));
        assertThat(callMethod(-10, 9, 20, null, null, 15, 7), equalTo(42));
    }

}
