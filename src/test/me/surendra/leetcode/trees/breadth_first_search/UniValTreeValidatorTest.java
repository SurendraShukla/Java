package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;


public class UniValTreeValidatorTest {

    private boolean callMethod(final TreeNode root) {
        return new UniValTreeValidator().isUnivalTree(root);
    }

    @Test
    public void uniValTree() {
        final TreeNode left = new TreeNode(1, new TreeNode(1), new TreeNode(1));
        final TreeNode right = new TreeNode(1, null, new TreeNode(1));
        final TreeNode root = new TreeNode(1, left, right);

        Assert.assertTrue(callMethod(root));
    }

    @Test
    public void nonUniValTree() {
        final TreeNode left = new TreeNode(2, new TreeNode(5), new TreeNode(2));
        final TreeNode root = new TreeNode(2, left, new TreeNode(2));

        Assert.assertFalse(callMethod(root));
    }

}
