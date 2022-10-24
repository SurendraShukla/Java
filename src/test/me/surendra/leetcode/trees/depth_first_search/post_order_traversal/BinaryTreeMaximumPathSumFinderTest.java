package me.surendra.leetcode.trees.depth_first_search.post_order_traversal;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BinaryTreeMaximumPathSumFinderTest {

    private final BinaryTreeMaximumPathSumFinder binaryTreeMaximumPathSumFinder = new BinaryTreeMaximumPathSumFinder();

    private int callMethod(final Integer ...integers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(integers);

        return binaryTreeMaximumPathSumFinder.maxPathSum(treeNode);
    }

    @Test
    public void test() {
        assertThat(callMethod(1, 2, 3), equalTo(6));
        assertThat(callMethod(-10, 9, 20, null, null, 15, 7), equalTo(42));
    }

}
