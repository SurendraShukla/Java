package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class FindTheWinnerJosephusProblemTest {

    private int callMethod(final int n, final int k) {
        return new FindTheWinnerJosephusProblem().findTheWinnerUsingList(n, k);
//        return new FindTheWinnerJosephusProblem().findTheWinnerUsingPrimitiveArray(n, k);
    }

    @Test
    public void test1() {
        assertThat(callMethod(5, 2), equalTo(3));
    }

    @Test
    public void test2() {
        assertThat(callMethod(6, 5), equalTo(1));
    }

}
