package me.surendra.leetcode.trees.binary_search_tree.bfs;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LowestCommonAncestorFinderTest {

    private final LowestCommonAncestorFinder lowestCommonAncestorFinder = new LowestCommonAncestorFinder();

    private TreeNode callMethod(final TreeNode treeNode, final TreeNode pNode, final TreeNode qNode) {
//        return lowestCommonAncestorFinder.lowestCommonAncestor(treeNode, pNode, qNode);
        return lowestCommonAncestorFinder.lowestCommonAncestorComparingEqualValAlso(treeNode, pNode, qNode);
    }

    @Test
    public void test1() {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(2, 1, null);
        final TreeNode pNode = root;
        final TreeNode qNode = root.left;

        assertThat(callMethod(root, pNode, qNode), equalTo(root));
    }

    @Test
    public void test2() {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        final TreeNode pNode = root.left;
        final TreeNode qNode = root.right;

        assertThat(callMethod(root, pNode, qNode), equalTo(root));
    }
    
    @Test
    public void test3() {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        final TreeNode pNode = root.left;
        final TreeNode qNode = root.left.right;

        assertThat(callMethod(root, pNode, qNode), equalTo(pNode));
    }

}
