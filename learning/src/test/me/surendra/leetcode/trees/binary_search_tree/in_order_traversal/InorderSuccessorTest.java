package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import com.google.common.collect.Lists;
import me.surendra.leetcode.trees.TreeNode;
import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class InorderSuccessorTest  {

    private TreeNode callMethod(final Integer[] rootNodeValues, final int pNodeVal) {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(Lists.newArrayList(rootNodeValues));
        final TreeNode pNode = BinaryTreeNodeCreator.fromPreOrder(Lists.newArrayList(pNodeVal));

        return new InorderSuccessor().inorderSuccessor(root, pNode);
    }

    @Test
    public void foundInOrderSuccessor() {
        final Integer[] rootNodeValues = {2, 1, 3};

        // execute
        final TreeNode actual = callMethod(rootNodeValues, 1);

        final TreeNode expected = BinaryTreeNodeCreator.fromPreOrder(Lists.newArrayList(rootNodeValues));
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void notFoundInOrderSuccessor() {
        final Integer[] rootNodeValues = {5, 3, 6, 2, 4, null, null};

        // execute
        final TreeNode actual = callMethod(rootNodeValues, 6);

        assertThat(actual, equalTo(null));
    }

}
