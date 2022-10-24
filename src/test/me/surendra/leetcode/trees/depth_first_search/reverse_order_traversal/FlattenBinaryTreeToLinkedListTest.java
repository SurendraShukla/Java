package me.surendra.leetcode.trees.depth_first_search.reverse_order_traversal;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;


import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class FlattenBinaryTreeToLinkedListTest {

    private void callMethod(final TreeNode treeNode) {
        new FlattenBinaryTreeToLinkedList().flatten(treeNode);
    }

    @Test
    public void emptyNode() {
        final TreeNode treeNode = null;
        callMethod(treeNode);

        assertThat(treeNode, equalTo(null));
    }

    @Test
    public void rootNodeWithoutChild() {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(0);
        callMethod(treeNode);

        assertThat(treeNode, equalTo(treeNode));
    }

    @Test
    public void nodeWithMultipleChildren() {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(1, 2, 5, 3, 4, null, 6);

        callMethod(treeNode);

        final TreeNode expected = BinaryTreeNodeCreator.fromPreOrder(1, null, 2, null, 3, null, 4, null, 5, null, 6);
        assertThat(treeNode, equalTo(expected));
    }

}
