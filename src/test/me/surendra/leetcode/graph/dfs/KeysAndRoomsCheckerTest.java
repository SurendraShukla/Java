package me.surendra.leetcode.graph.dfs;


import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class KeysAndRoomsCheckerTest {

    private final KeysAndRoomsChecker keysAndRoomsChecker = new KeysAndRoomsChecker();

    private boolean callMethod(final List<List<Integer>> rooms) {
        return keysAndRoomsChecker.canVisitAllRoomsUsingBfs(rooms);
//        return keysAndRoomsChecker.canVisitAllRoomsUsingDfs(rooms);
    }

    @Test
    public void canUnlock() {
        final List<List<Integer>> rooms = asList(
            singletonList(1),
            singletonList(2),
            singletonList(3),
            emptyList()
        );
        assertThat(callMethod(rooms), equalTo(true));
    }

    @Test
    public void canNotLock() {
        final List<List<Integer>> rooms = asList(
            asList(1, 3),
            asList(3, 0, 1),
            singletonList(2),
            singletonList(0)
        );
        assertThat(callMethod(rooms), equalTo(false));
    }

}
