package me.surendra.leetcode.array;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class Utf8ValidatorTest {

    private boolean callMethod(final int[] data) {
//        return new Utf8Validator().validUtf8UsingRange(data);
        return new Utf8Validator().validUtf8(data);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[]{197, 130, 1}),
            equalTo(true)
        );

        assertThat(
            callMethod(new int[]{235, 140, 4}),
            equalTo(false)
        );

        assertThat(
            callMethod(new int[]{250, 145, 145, 145, 145}),
            equalTo(false)
        );

        assertThat(
            callMethod(new int[]{425, 130}),
            equalTo(false)
        );
    }

}
