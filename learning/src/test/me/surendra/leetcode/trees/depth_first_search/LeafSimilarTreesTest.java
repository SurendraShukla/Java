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

        assertThat(
            callMethod(
                new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4},
                new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8}
            ),
            equalTo(true)
        );

        assertThat(
            callMethod(new Integer[]{1, 2, 3}, new Integer[]{1, 3, 2}),
            equalTo(false));

        assertThat(
            callMethod(
                new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 14},
                new Integer[]{3, 5, 1, 6, 71, 4, 2, null, null, null, null, null, null, 9, 8}
            ),
            equalTo(false)
        );
    }

}
