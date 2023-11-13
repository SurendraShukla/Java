package me.surendra.leetcode.string;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class VowelsSorterTest {

    String callMethod(final String lEetcOde) {
        return new VowelsSorter().sortVowels(lEetcOde);
    }

    @Test
    public void test() {
        assertThat(callMethod("lEetcOde"), equalTo("lEOtcede"));
        assertThat(callMethod("lYmpH"), equalTo("lYmpH"));
    }

}
