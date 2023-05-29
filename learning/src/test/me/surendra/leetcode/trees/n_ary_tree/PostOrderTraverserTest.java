package me.surendra.leetcode.trees.n_ary_tree;


import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PostOrderTraverserTest {

    private List<Integer> callMethod(final Integer ...integers) {
        final Node nAryTreeNode = NaryTreeCreator.from(integers);

//        return new PostOrderTraverser().postorder(nAryTreeNode);
        return new PostOrderTraverser().postorderUsingIterative(nAryTreeNode);
    }

    @Test
    public void test1() {
        // execute
        final List<Integer> actual = callMethod(1, null, 3, 2, 4, null, 5, 6);

        final List<Integer> expected = Lists.newArrayList(5, 6, 3, 2, 4, 1);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        // execute
        final List<Integer> actual = callMethod(1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14);

        final List<Integer> expected = Lists.newArrayList(2, 6, 14, 11, 7, 3, 12, 8, 4, 13, 9, 10, 5, 1);
        assertThat(actual, equalTo(expected));
    }

}
