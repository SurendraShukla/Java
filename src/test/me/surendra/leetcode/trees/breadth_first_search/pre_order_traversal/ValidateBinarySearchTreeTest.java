package me.surendra.leetcode.trees.breadth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ValidateBinarySearchTreeTest {

    private boolean callMethod(final Integer ...integers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(integers);

        return new ValidateBinarySearchTree().isValidBST(treeNode);
//        return new ValidateBinarySearchTree().isValidBSTUsingIteration(treeNode);
    }

    @Test
    public void validTrees() {
        assertThat(callMethod(0), equalTo(true));
        assertThat(callMethod(0, -1, null), equalTo(true));
        assertThat(callMethod(2, 1, 3), equalTo(true));
        assertThat(callMethod(34, -6, null, -21, null), equalTo(true));
    }

    @Test
    public void inValidTrees() {
        assertThat(callMethod(1, 1, null), equalTo(false));
        assertThat(callMethod(2, 2, 2), equalTo(false));
        assertThat(callMethod(5, 1, 4, null, null, 3, 6), equalTo(false));
        assertThat(callMethod(5, 4, 6, null, null, 3, 7), equalTo(false));
    }

    @Test
    public void rangeCheck() {
        assertThat(callMethod(-2147483648), equalTo(true));
        assertThat(callMethod(-2147483648, null, 2147483647), equalTo(true));
    }

}
