package me.surendra.leetcode.trees.depth_first_search;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LeafSimilarTreesTest {

    private final LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();

    private boolean callMethod(final Integer[] root1Values, final Integer[] root2Values) {
        final TreeNode treeNode1 = BinaryTreeNodeCreator.fromPreOrder(root1Values);
        final TreeNode treeNode2 = BinaryTreeNodeCreator.fromPreOrder(root2Values);

        return leafSimilarTrees.leafSimilar(treeNode1, treeNode2);
    }

    @Test
    public void test1() {
        final Integer[] root1Values = {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4};
        final Integer[] root2Values = {3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8};

        assertThat(callMethod(root1Values, root2Values), equalTo(true));
    }

    @Test
    public void test2() {
        final Integer[] root1Values = {1, 2, 3};
        final Integer[] root2Values = {1, 3, 2};

        assertThat(callMethod(root1Values, root2Values), equalTo(false));
    }

    @Test
    public void test3() {
        final Integer[] root1Values = {3, 5, 1, 6, 2, 9, 8, null, null, 7, 14};
        final Integer[] root2Values = {3, 5, 1, 6, 71, 4, 2, null, null, null, null, null, null, 9, 8};

        assertThat(callMethod(root1Values, root2Values), equalTo(false));
    }
}
