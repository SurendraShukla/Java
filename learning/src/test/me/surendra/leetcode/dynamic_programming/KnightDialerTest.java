package me.surendra.leetcode.dynamic_programming;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class KnightDialerTest {

    private final KnightDialer knightDialer = new KnightDialer();

    @Test
    public void test() {
        assertThat(knightDialer.knightDialer(1), equalTo(10));
        assertThat(knightDialer.knightDialer(2), equalTo(20));
        assertThat(knightDialer.knightDialer(3131), equalTo(136006598));
//        assertThat(knightDialer.knightDialer(5000), equalTo(406880451));
    }
}
