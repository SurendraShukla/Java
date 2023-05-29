package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LowestCommonAncestorFinderTest {

    private final LowestCommonAncestorFinder lowestCommonAncestorFinder = new LowestCommonAncestorFinder();

    private TreeNode callMethod(final TreeNode root, final TreeNode left, final TreeNode right) {
        return lowestCommonAncestorFinder.lowestCommonAncestor(root, left, right);
    }

    @Test
    public void test1() {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(1, 2, null);
        final TreeNode pNode = root;
        final TreeNode qNode = root.left;

        assertThat(callMethod(root, pNode, qNode), equalTo(root));
    }

    @Test
    public void test2() {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        final TreeNode pNode = root.left;
        final TreeNode qNode = root.right;

        assertThat(callMethod(root, pNode, qNode), equalTo(root));
    }

    @Test
    public void test3() {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        final TreeNode pNode = root.left;
        final TreeNode qNode = root.left.right.right;

        assertThat(callMethod(root, pNode, qNode), equalTo(pNode));
    }
}
