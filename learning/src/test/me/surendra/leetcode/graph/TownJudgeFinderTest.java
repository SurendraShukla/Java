package me.surendra.leetcode.graph;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class TownJudgeFinderTest {

    private int callMethod(final int[][] trust, final int n) {
//        return new TownJudgeFinder().findJudge(n, trust);
        return new TownJudgeFinder().findJudgeUsingOneArray(n, trust);
    }

    @Test
    public void test1() {
        assertThat(callMethod(new int[][]{{1, 2}}, 2), equalTo(2));
        assertThat(callMethod(new int[][]{{1, 3}, {2, 3}}, 3), equalTo(3));
        assertThat(callMethod(new int[][]{{1, 3}, {2, 3}, {3, 1}}, 3), equalTo(-1));
        assertThat(callMethod(new int[][]{{1, 2}, {2, 3}}, 3), equalTo(-1));
        assertThat(callMethod(new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}, 4), equalTo(3));
    }

}
