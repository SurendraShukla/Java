package me.surendra.leetcode.trees.bfs.binary;

import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SymmetricFinderTest {

    private boolean callMethod(final TreeNode root) {
//        return new SymmetricFinder().isSymmetricSelfThought(root);
        return new SymmetricFinder().isSymmetricUsingIteration(root);
//        return new SymmetricFinder().isSymmetricUsingRecursion(root);
    }

    @Test
    public void isSymmetric() {
        final TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        final TreeNode right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        final TreeNode root = new TreeNode(1, left, right);

        assertThat(callMethod(root), equalTo(true));
    }

    @Test
    public void isNotSymmetric() {
        final TreeNode left = new TreeNode(2, null, new TreeNode(3));
        final TreeNode right = new TreeNode(2, null, new TreeNode(3));
        final TreeNode root = new TreeNode(1, left, right);

        assertThat(callMethod(root), equalTo(false));
    }

    @Test
    public void isNotSymmetricFailedOnLeetCode() {
        final TreeNode left = new TreeNode(3, new TreeNode(4), new TreeNode(5));
        final TreeNode right = new TreeNode(3, null, new TreeNode(4));
        final TreeNode root = new TreeNode(2, left, right);

        assertThat(callMethod(root), equalTo(false));
    }


}
