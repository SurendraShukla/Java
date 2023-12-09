package me.surendra.leetcode.trees.depth_first_search.in_order_traversal;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class InOrderTraversalTest {

    private InOrderTraversal inOrderTraversal;

    public List<Integer> callMethod(final Integer... integers) {
        inOrderTraversal = new InOrderTraversal();

        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(integers);
        return inOrderTraversal.inorderTraversal(treeNode);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(1, null, 2, 3),
            equalTo(Arrays.asList(1, 3, 2))
        );

        assertThat(
            callMethod(),
            equalTo(Arrays.asList())
        );

        assertThat(
            callMethod(1),
            equalTo(Arrays.asList(1))
        );
    }
}
