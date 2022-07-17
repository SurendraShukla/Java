package me.surendra.leetcode.trees.n_ary_tree;

import org.junit.Test;


public class NaryTreeCreatorTest {

    @Test
    public void test() {
        System.out.println(NaryTreeCreator.from(1, null, 3, 2, 4, null, 5, 6));
        System.out.println(NaryTreeCreator.from(1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14));
    }

}
