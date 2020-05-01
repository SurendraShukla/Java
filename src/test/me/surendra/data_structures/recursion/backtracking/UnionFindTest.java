package me.surendra.data_structures.recursion.backtracking;

import me.surendra.data_structures.recursion.backtracking.island.UnionFind;
import org.junit.Test;

public class UnionFindTest {

    @Test
    public void shouldCreate() {
        final UnionFind unionFind = new UnionFind(11);
        unionFind.connect(0, 1);
        unionFind.connect(1, 2);
        unionFind.connect(4, 5);
        unionFind.connect(7, 8);
        unionFind.connect(8, 9);
        unionFind.connect(9, 10);
        System.out.println(unionFind.getConnectedPointsOnly());
    }

}
