package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;


public class IncreasingOrderSearchTreeTest {

    private TreeNode callMethod(final TreeNode treeNode) {
//        return new IncreasingOrderSearchTree().increasingBstTraversalWithRelinking(treeNode);
//        return new IncreasingOrderSearchTree().increasingBstTraversalWithIterationWithDummyNode(treeNode);
        return new IncreasingOrderSearchTree().increasingBstTraversalWithIterationWithoutDummyNode(treeNode);
    }

    @Test
    public void test1() {
        TreeNode node = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        // execute
        final TreeNode treeNode = callMethod(node);

        System.out.println(treeNode);
    }

    @Test
    public void test3() {
        final TreeNode rightInner = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        final TreeNode right = new TreeNode(6, null, rightInner);

        final TreeNode leftInner = new TreeNode(2, new TreeNode(1), null);
        final TreeNode left = new TreeNode(3, leftInner, new TreeNode(4));

        final TreeNode root = new TreeNode(5, left, right);

        // execute
        final TreeNode treeNode = callMethod(root);

        System.out.println(treeNode);

    }

}
