package me.surendra.leetcode.trees;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LowestCommonAncestorBinaryTreeIITest {

    private final LowestCommonAncestorBinaryTreeII unit = new LowestCommonAncestorBinaryTreeII();
    final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);

    @Test
    public void rootAsLCA() {
        assertThat(unit.lowestCommonAncestor(root, root.left, root.right), equalTo(root));
    }

    @Test
    public void leftAsLCA() {
        assertThat(unit.lowestCommonAncestor(root, root.left, root.left.right.right), equalTo(root.left));
    }

    @Test
    public void noRoot() {
        final TreeNode right = BinaryTreeNodeCreator.fromPreOrder(10);

        assertThat(unit.lowestCommonAncestor(root, root.left, right), equalTo(null));
    }

}
