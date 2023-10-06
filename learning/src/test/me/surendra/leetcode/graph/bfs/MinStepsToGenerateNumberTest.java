package me.surendra.leetcode.graph.bfs;

import org.junit.Test;

import static me.surendra.leetcode.graph.bfs.MinStepsToGenerateNumber.minSteps;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MinStepsToGenerateNumberTest {

    @Test
    public void test() {
        assertThat(minSteps(10), equalTo(6));
        assertThat(minSteps(3), equalTo(7));
//        assertThat(minSteps(10), equalTo(6));
    }
}
