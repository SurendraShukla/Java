package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class RangeSumFinderTest {

    private int callMethod(final TreeNode root, final int low, final int high) {
        return new RangeSumFinder().rangeSumBST(root, low, high);
    }

    @Test
    public void test1() {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(10, 5, 15, 3, 7, null, 18);

        assertThat(callMethod(root, 7, 15), equalTo(32));
        assertThat(callMethod(root, 3, 3), equalTo(3));
        assertThat(callMethod(root, 3, 5), equalTo(8));
        assertThat(callMethod(root, 3, 7), equalTo(15));
        assertThat(callMethod(root, 3, 10), equalTo(25));
        assertThat(callMethod(root, 3, 15), equalTo(40));
        assertThat(callMethod(root, 3, 18), equalTo(58));
    }

    @Test
    public void test2() {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(10, 5, 15, 3, 7, 13, 18, 1, null, 6);

        assertThat(callMethod(root, 6, 10), equalTo(23));
    }
}
