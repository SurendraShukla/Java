package me.surendra.leetcode.trees.binary_search_tree;

import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ValidatorTest {

    private boolean callMethod(final TreeNode treeNode) {
//        return new Validator().isValidBSTUsingInOrderTraversalIterativeApproach(treeNode);
        return new Validator().isValidBSTUsingInOrderTraversalRecursionApproach(treeNode);
//        return new Validator().isValidBST(treeNode);
    }

    @Test
    public void valid1() {
//        [1]
        final TreeNode treeNode = new TreeNode(1);

        assertThat(callMethod(treeNode), equalTo(true));
    }

    @Test
    public void valid2() {
//        [0,-1]
        final TreeNode treeNode = new TreeNode(0, new TreeNode(-1), null);

        assertThat(callMethod(treeNode), equalTo(true));
    }

    @Test
    public void valid3() {
//        [2,1,3]
        final TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        assertThat(callMethod(treeNode), equalTo(true));
    }

    @Test
    public void inValid1() {
//        [1,1]
        final TreeNode treeNode = new TreeNode(1, new TreeNode(1), null);

        assertThat(callMethod(treeNode), equalTo(false));
    }

    @Test
    public void inValid2() {
//        [5,4,6,null,null,3,7]
        final TreeNode left = new TreeNode(1);
        final TreeNode right = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        final TreeNode treeNode = new TreeNode(5, left, right);

        assertThat(callMethod(treeNode), equalTo(false));
    }

    @Test
    public void inValid3() {
//        [5,4,7,null,null,6,8]
        final TreeNode left = new TreeNode(4);
        final TreeNode right = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        final TreeNode treeNode = new TreeNode(5, left, right);

        assertThat(callMethod(treeNode), equalTo(false));
    }


}
