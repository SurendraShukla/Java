package me.surendra.leetcode.trees.depth_first_search;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SubtreeOfAnotherTreeTest {

    private final SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();


    private boolean callMethod(final List<Integer> rootList, final List<Integer> subRootList) {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(rootList);
        final TreeNode subRoot = BinaryTreeNodeCreator.fromPreOrder(subRootList);
        return subtreeOfAnotherTree.isSubtree(root, subRoot);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(
                newArrayList(3, 4, 5, 1, 2),
                newArrayList(4, 1, 2)
            ),
            equalTo(true)
        );

        assertThat(
            callMethod(
                newArrayList(3, 4, 5, 1, 2, null, null, null, null, 0),
                newArrayList(4, 1, 2)
            ),
            equalTo(false)
        );

        assertThat(
            callMethod(
                newArrayList(3, 4, 5, 1, null, 2),
                newArrayList(3, 1, 2)
            ),
            equalTo(false)
        );


        assertThat(
            callMethod(
                newArrayList(1, 1),
                newArrayList(1)
            ),
            equalTo(true)
        );

    }

}
