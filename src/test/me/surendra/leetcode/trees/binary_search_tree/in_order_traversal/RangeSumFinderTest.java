package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

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
        final TreeNode left = new TreeNode(5, new TreeNode(3), new TreeNode(7));
        final TreeNode right= new TreeNode(15, null, new TreeNode(18));
        final TreeNode root = new TreeNode(10, left, right);

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
        final TreeNode left1 = new TreeNode(3, new TreeNode(1), null);
        final TreeNode right1 = new TreeNode(7, new TreeNode(6), null);
        final TreeNode left = new TreeNode(5, left1, right1);
        final TreeNode right = new TreeNode(15, new TreeNode(13), new TreeNode(18));
        final TreeNode root = new TreeNode(10, left, right);

        assertThat(callMethod(root, 6, 10), equalTo(23));
    }
}
