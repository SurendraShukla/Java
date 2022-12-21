package me.surendra.leetcode.graph.bfs;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class WallsAndGatesTest {

    private void callMethod(final int[][] rooms) {
        new WallsAndGates().wallsAndGates(rooms);
    }

    @Test
    public void roomsWithGateAndWall() {
        final int[][] rooms = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};

        callMethod(rooms);

        final int[][] expectedState = {{3, -1, 0, 1}, {2, 2, 1, -1}, {1, -1, 2, -1}, {0, -1, 3, 4}};
        assertThat(rooms, equalTo(expectedState));
    }

    @Test
    public void roomsWithJustRoomsAndGate() {
        final int[][] rooms = {{2147483647, 2147483647}, {2147483647, 0}};

        callMethod(rooms);

        final int[][] expectedState = {{2, 1}, {1, 0}};
        assertThat(rooms, equalTo(expectedState));
    }

    @Test
    public void roomsWithJustWall() {
        final int[][] rooms = {{-1}};

        callMethod(rooms);

        final int[][] expectedState = {{-1}};
        assertThat(rooms, equalTo(expectedState));
    }
}
