package me.surendra.leetcode.hash_map;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BrickWallTest {

    private int callMethod(final Integer[][] wall) {
        final List<List<Integer>> wallList = Arrays
            .stream(wall)
            .map(Arrays::asList)
            .collect(Collectors.toList())
            ;

        return new BrickWall().leastBricks(wallList);
    }

    @Test
    public void brickDoesNeedToBeCut1() {
        final Integer[][] wall = {
            {1,2,3},
            {1,2,3},
            {1,2,3}
        };

        assertThat(callMethod(wall), equalTo(0));
    }

    @Test
    public void brickDoesNeedToBeCut2() {
        final Integer[][] wall = {
            {1,2,3},
            {1,3,2},
            {1,2,3}
        };

        assertThat(callMethod(wall), equalTo(0));
    }

    @Test
    public void brickNeedsToBeCut1() {
        final Integer[][] wall = {
            {1},
            {1},
            {1}
        };

        assertThat(callMethod(wall), equalTo(3));
    }

    @Test
    public void brickNeedsToBeCut2() {
        final Integer[][] wall = {
            {1,2,2,1},
            {3,1,2},
            {1,3,2},
            {2,4},
            {3,1,2},
            {1,3,1,1}
        };

        assertThat(callMethod(wall), equalTo(2));
    }

    @Test
    public void brickNeedsToBeCut3() {
        final Integer[][] wall = {
            {1,1},
            {2},
            {1,1}
        };

        assertThat(callMethod(wall), equalTo(1));
    }

    @Test
    public void brickNeedsToBeCut4() {
        final Integer[][] wall = {
            {1,1,1},
            {2,1},
            {1,2}
        };

        assertThat(callMethod(wall), equalTo(1));
    }

    @Test
    public void brickNeedsToBeCut5() {
        final Integer[][] wall = {
            {7,1,2},
            {3,5,1,1},
            {10}
        };

        assertThat(callMethod(wall), equalTo(1));
    }



}
