package me.surendra.leetcode.search.binary_search;

import org.junit.Test;
import java.util.function.Function;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class NumberGuesserTest {

    private int callMethod(final int n, final Function<Integer, Integer> guess) {
        return new NumberGuesser().guessNumber(n, guess);
    }

    private Function<Integer, Integer> guessMethod(final int picked) {
        return (guestNo) -> {
            if (guestNo == picked) return 0;
            if (guestNo < picked) return 1;
            return -1;
        };
    }

    @Test
    public void test1() {
        assertThat(callMethod(10, guessMethod(6)), equalTo(6));
        assertThat(callMethod(1, guessMethod(1)), equalTo(1));
        assertThat(callMethod(2, guessMethod(1)), equalTo(1));
        assertThat(callMethod(2, guessMethod(2)), equalTo(2));
    }

    @Test
    public void testDidNotPassOnLeetCode() {
        assertThat(callMethod(3, guessMethod(2)), equalTo(2));
    }

}
