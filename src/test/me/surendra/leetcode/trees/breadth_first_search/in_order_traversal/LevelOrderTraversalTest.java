package me.surendra.leetcode.trees.breadth_first_search.in_order_traversal;


import me.surendra.leetcode.trees.TreeNode;
import me.surendra.leetcode.trees.TreeNodeCreator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LevelOrderTraversalTest {

    private List<List<Integer>> callMethod(final Integer[] integers) {
        final TreeNode treeNode = TreeNodeCreator.fromPreOrder(integers);

        final List<List<Integer>> actualList = new LevelOrderTraversal().levelOrderUsingIterationUsingRecursion(treeNode);
        return actualList;
    }

    @Test
    public void emptyTree() {
        final List<List<Integer>> actualList = callMethod(null);

        final List<List<Integer>> expectedList = emptyList();

        assertThat(actualList, equalTo(expectedList));
    }

    @Test
    public void onlyRootNode() {
        final List<List<Integer>> actualList = callMethod(new Integer[]{1, null, null});

        final List<List<Integer>> expectedList = Arrays.asList(Arrays.asList(1));

        assertThat(actualList, equalTo(expectedList));
    }


    @Test
    public void test() {
        final List<List<Integer>> actualList = callMethod(new Integer[]{3, 9, 20, null, null, 15, 7});

        final List<List<Integer>> expectedList = newArrayList(
            newArrayList(3),
            newArrayList(9, 20),
            newArrayList(15, 7)
        );
        assertThat(actualList, equalTo(expectedList));
    }

}
