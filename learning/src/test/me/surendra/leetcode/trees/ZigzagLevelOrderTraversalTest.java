package me.surendra.leetcode.trees;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ZigzagLevelOrderTraversalTest {

    private List<List<Integer>> callMethod(final TreeNode root) {
        return new ZigzagLevelOrderTraversal().zigzagLevelOrder(root);
    }

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(10, 4, 2, 6, 5, 8);
        Collections.reverse(list);

        final List<List<Integer>> expected = newArrayList();

        assertion(callMethod(null), expected);
    }

    @Test
    public void test2() {
        final TreeNode root = new TreeNode(1);
        final List<List<Integer>> expected = newArrayList(
            newArrayList(1),
            newArrayList(1)
        );

//        assertion(callMethod(root), expected);
    }

    @Test
    public void test3() {
        // [3,9,20,null,null,15,7]
        final TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        final TreeNode root = new TreeNode(3, new TreeNode(9), right);

        final List<List<Integer>> expected = newArrayList(
            newArrayList(3),
            newArrayList(20, 9),
            newArrayList(15, 7)
        );
        assertion(callMethod(root), expected);
    }

    @Test
    public void test4() {
        // [3,9,20,null,null,15,7]
        final TreeNode left = new TreeNode(9, new TreeNode(10), new TreeNode(12));
        final TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        final TreeNode root = new TreeNode(3, left, right);

        final List<List<Integer>> expected = newArrayList(
            newArrayList(3),
            newArrayList(20, 9),
            newArrayList(10, 12, 15, 7)
        );
//        assertion(callMethod(root), expected);
    }

    @Test
    public void containsNe() {

    }

    private void assertion(final List<List<Integer>> actual, final List<List<Integer>> expected) {
        assertThat(actual.size(), equalTo(expected.size()));

        for (int i = 0; i < actual.size(); i++) {
            final List<Integer> tmpActual = actual.get(i);
            final List<Integer> tmpExpected = expected.get(i);

            assertThat(tmpActual.size(), equalTo(tmpExpected.size()));
            for (int j = 0; j < tmpActual.size(); j++) {
                assertThat(tmpActual.get(j), equalTo(tmpExpected.get(j)));
            }
        }
    }

}
