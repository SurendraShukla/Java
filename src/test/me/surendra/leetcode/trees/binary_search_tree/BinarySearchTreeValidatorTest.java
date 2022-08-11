package me.surendra.leetcode.trees.binary_search_tree;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BinarySearchTreeValidatorTest {

    private boolean callMethod(final Integer ...integers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(integers);
        final BinarySearchTreeValidator validator = new BinarySearchTreeValidator();

        return validator.isValidBST(treeNode);
//        return validator.isValidBSTUsingInOrderTraversalIterativeApproach(treeNode);
//        return validator.isValidBSTUsingInOrderTraversalRecursionApproach(treeNode);
    }

    @Test
    public void singleLevel() {
        assertThat(callMethod(0), equalTo(true));
        assertThat(callMethod(0, -1), equalTo(true));
        assertThat(callMethod(0, -1), equalTo(true));
        assertThat(callMethod(2, 1, 3), equalTo(true));

        assertThat(callMethod(1, 1, null), equalTo(false));
    }

    @Test
    public void multipleLevel() {
        assertThat(callMethod(5, 1, 4, null, null, 3, 6), equalTo(false));
        assertThat(callMethod(5, 4, 6, null, null, 3, 7), equalTo(false));

        assertThat(callMethod(34, -6, null, -21), equalTo(true));
    }

    @Test
    public void rangeCheck() {
        assertThat(callMethod(2147483647), equalTo(true));
        assertThat(callMethod(-2147483648), equalTo(true));
        assertThat(callMethod(0, -2147483648, 2147483647), equalTo(true));
    }

}
