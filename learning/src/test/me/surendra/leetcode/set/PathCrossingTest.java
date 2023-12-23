package me.surendra.leetcode.set;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class PathCrossingTest {
    @Test
    public void test() {
        final PathCrossing pathCrossing = new PathCrossing();

        assertThat(pathCrossing.isPathCrossing("NES"), equalTo(false));
        assertThat(pathCrossing.isPathCrossing("NESWW"), equalTo(true));
    }

}
