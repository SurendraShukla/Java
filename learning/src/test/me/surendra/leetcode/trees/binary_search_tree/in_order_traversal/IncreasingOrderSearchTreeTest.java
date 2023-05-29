package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import com.google.common.collect.Lists;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class IncreasingOrderSearchTreeTest {

    private TreeNode callMethod(final TreeNode treeNode) {
//        return new IncreasingOrderSearchTree().increasingBstTraversalWithRelinking(treeNode);
//        return new IncreasingOrderSearchTree().increasingBstTraversalWithIterationWithDummyNode(treeNode);
        return new IncreasingOrderSearchTree().increasingBstTraversalWithIterationWithoutDummyNode(treeNode);
    }

    @Test
    public void test1() {
        final TreeNode treeNode = new TreeNode(0);

        callMethod(treeNode);

        assertThat(treeNode, equalTo(treeNode));
    }

    @Test
    public void test2() {
        TreeNode node = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        // execute
        final TreeNode treeNode = callMethod(node);

        final TreeNode expected = from(Lists.newArrayList(1, 2, 3));
        assertThat(treeNode, equalTo(expected));
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

        final TreeNode expected = from(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertThat(treeNode, equalTo(expected));
    }

    private TreeNode from(final List<Integer> integerList) {
        TreeNode previousRightNode = null;
        TreeNode treeNode = null;
        for (int i = integerList.size()-1; i >= 0; i--) {
            treeNode = new TreeNode(integerList.get(i), null, previousRightNode);
            previousRightNode = treeNode;
        }
        return treeNode;
    }

}
