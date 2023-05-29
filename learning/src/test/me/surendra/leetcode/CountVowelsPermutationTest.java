package me.surendra.leetcode;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CountVowelsPermutationTest {

    private final CountVowelsPermutation countVowelsPermutation = new CountVowelsPermutation();

    private int callMethod(final int n) {
        return countVowelsPermutation.countVowelPermutation(n);
    }

    @Test
    public void test() {
        assertThat(callMethod(1), equalTo(5));
        assertThat(callMethod(2), equalTo(10));
        assertThat(callMethod(3), equalTo(19));
        assertThat(callMethod(5), equalTo(68));
        assertThat(callMethod(10), equalTo(1739));
        assertThat(callMethod(30), equalTo(761083377));
        assertThat(callMethod(31), equalTo(457014530));
        assertThat(callMethod(50), equalTo(227130014));
        assertThat(callMethod(100), equalTo(173981881));
        assertThat(callMethod(1999), equalTo(666388680));
        assertThat(callMethod(2000), equalTo(793084836));
    }

}
