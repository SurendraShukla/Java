package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;


import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class KthSmallestElementInBSTFinderTest {

    private int callMethod(final TreeNode root, final int k) {
        return new KthSmallestElementInBSTFinder().kthSmallest(root, k);
    }

    @Test
    public void test1() {
        final TreeNode left = new TreeNode(1, null, new TreeNode(2));
        final TreeNode right= new TreeNode(4, null, null);
        final TreeNode root= new TreeNode(3, left, right);

        for (int i = 1; i < 5; i++) {
            int no = callMethod(root, i);
            assertThat("Failed for " + no, no, equalTo(i));
        }
    }

    @Test
    public void test2() {
        final TreeNode left1= new TreeNode(2, new TreeNode(1), null);
        final TreeNode left = new TreeNode(3, left1, new TreeNode(4));
        final TreeNode root= new TreeNode(5, left, new TreeNode(6));

        for (int i = 1; i < 7; i++) {
            int tmpNo = i;
            int no = callMethod(root, tmpNo);
            assertThat("Failed for " + no, no, equalTo(i));
        }
    }

}
