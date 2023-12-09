package me.surendra.leetcode.greedy;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SameColorNeighborsRemovalTest {

    private final SameColorNeighborsRemoval sameColorNeighborsRemoval = new SameColorNeighborsRemoval();

    private boolean callMethod(final String aaababb) {
        return sameColorNeighborsRemoval.winnerOfGame(aaababb);
    }

    @Test
    public void test() {
        assertThat(callMethod("AAABABB"), equalTo(true));
        assertThat(callMethod("AA"), equalTo(false));
        assertThat(callMethod("ABBBBBBBAAA"), equalTo(false));
        assertThat(callMethod("AAAABBBB"), equalTo(false));
    }

}
