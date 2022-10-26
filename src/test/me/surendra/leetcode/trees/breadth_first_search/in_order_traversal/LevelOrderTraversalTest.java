package me.surendra.leetcode.trees.breadth_first_search.in_order_traversal;


import me.surendra.leetcode.trees.TreeNode;
import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LevelOrderTraversalTest {

    final LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

    private List<List<Integer>> callMethod(final Integer ...integers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(integers);

        return levelOrderTraversal.levelOrderUsingIterationUsingRecursion(treeNode);
    }

    @Test
    public void emptyTree() {
        final List<List<Integer>> actualList = callMethod(null);

        final List<List<Integer>> expectedList = emptyList();

        assertThat(actualList, equalTo(expectedList));
    }

    @Test
    public void onlyRootNode() {
        final List<List<Integer>> actualList = callMethod(1, null, null);

        final List<List<Integer>> expectedList = asList(asList(1));

        assertThat(actualList, equalTo(expectedList));
    }

    @Test
    public void test() {
        final List<List<Integer>> actualList = callMethod(3, 9, 20, null, null, 15, 7);

        final List<List<Integer>> expectedList = newArrayList(
            newArrayList(3),
            newArrayList(9, 20),
            newArrayList(15, 7)
        );
        assertThat(actualList, equalTo(expectedList));
    }

}
