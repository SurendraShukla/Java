package me.surendra.leetcode;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BitReverserTest {

    private int callMethod(final int n) {
        return new BitReverser().reverseBits(n);
    }

    @Test
    public void test1() {
        assertThat(callMethod(7), equalTo(3758096384L));
//        assertThat(callMethod(43261596), equalTo(964176192));
    }

}
