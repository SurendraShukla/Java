package me.surendra.leetcode.trees.n_ary_tree;


import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LevelOrderTraversalTest {

    final LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

    private List<List<Integer>> callMethod(final Integer ...integers) {
        final Node root = NaryTreeCreator.from(integers);

        return levelOrderTraversal.levelOrderUsingDfs(root);
//        return levelOrderTraversal.levelOrderUsingBfs(root);
    }

    @Test
    public void emptyTree() {
        final List<List<Integer>> actualList = callMethod();

        final List<List<Integer>> expectedList = emptyList();

        assertThat(actualList, equalTo(expectedList));
    }

    @Test
    public void test() {
        final List<List<Integer>> actualList = callMethod(1, null, 3, 2, 4, null, 5, 6);

        final List<List<Integer>> expectedList = newArrayList(
            newArrayList(1),
            newArrayList(3, 2, 4),
            newArrayList(5, 6)
        );
        assertThat(actualList, equalTo(expectedList));
    }

    @Test
    public void test2() {
        final List<List<Integer>> actualList = callMethod(1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14);

        final List<List<Integer>> expectedList = newArrayList(
            newArrayList(1),
            newArrayList(2, 3, 4, 5),
            newArrayList(6, 7, 8, 9, 10),
            newArrayList(11, 12, 13),
            newArrayList(14)
        );
        assertThat(actualList, equalTo(expectedList));
    }

}
