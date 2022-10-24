package me.surendra.leetcode.trees.depth_first_search.post_order_traversal;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class DiameterFinderTest {

    private final DiameterFinder diameterFinder = new DiameterFinder();

    private int calMethod(final Integer... integers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(integers);

        return diameterFinder.diameterOfBinaryTree(treeNode);
    }

    @Test
    public void nodWithOneChild() {
        assertThat(calMethod(1, 2), equalTo(1));
    }

    @Test
    public void nodeWithMultipleChild() {
        assertThat(calMethod(1, 2, 3, 4, 5), equalTo(3));
    }

}
