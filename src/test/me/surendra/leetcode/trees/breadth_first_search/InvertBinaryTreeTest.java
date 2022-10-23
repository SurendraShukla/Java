package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class InvertBinaryTreeTest {

    private final InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

    private TreeNode createTreeNodeFrom(final Integer ...integers) {
        return BinaryTreeNodeCreator.fromPreOrder(integers);
    }

    @Test
    public void invertedTreeForNull() {
        final TreeNode treeNode = null;

        invertBinaryTree.invertTree(treeNode);

        assertThat(treeNode, equalTo(null));
    }

    @Test
    public void invertedTree1() {
        final TreeNode treeNode = createTreeNodeFrom(4, 2, 7, 1, 3, 6, 9);

        invertBinaryTree.invertTree(treeNode);

        final TreeNode expected = createTreeNodeFrom(4, 7, 2, 9, 6, 3, 1);
        assertThat(treeNode, equalTo(expected));
    }

    @Test
    public void invertedTree2() {
        final TreeNode treeNode = createTreeNodeFrom(2, 1, 3);

        invertBinaryTree.invertTree(treeNode);

        final TreeNode expected = createTreeNodeFrom(2, 3, 1);
        assertThat(treeNode, equalTo(expected));
    }

}
