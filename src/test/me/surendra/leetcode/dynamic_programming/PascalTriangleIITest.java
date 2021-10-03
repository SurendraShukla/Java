package me.surendra.leetcode.dynamic_programming;

import me.surendra.TestUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PascalTriangleIITest {

    private List<Integer> callMethod(final int rowIndex) {
        return new PascalTriangleII().getRow(rowIndex);
    }

    @Test
    public void test0() {
        final List<Integer> expected = Arrays.asList(1);

        final List<Integer> actual = callMethod(0);

        TestUtil.assertion(expected, actual);
    }

    @Test
    public void test1() {
        final List<Integer> expected = Arrays.asList(1,1);

        final List<Integer> actual = callMethod(1);

        TestUtil.assertion(expected, actual);
    }

    @Test
    public void test3() {
        final List<Integer> expected = Arrays.asList(1,2,1);

        final List<Integer> actual = callMethod(2);

        TestUtil.assertion(expected, actual);
    }

    @Test
    public void test4() {
        final List<Integer> expected = Arrays.asList(1,3,3,1);

        final List<Integer> actual = callMethod(3);

        TestUtil.assertion(expected, actual);
    }

    @Test
    public void test5() {
        final List<Integer> expected = Arrays.asList(1,4,6,4,1);

        final List<Integer> actual = callMethod(4);

        TestUtil.assertion(expected, actual);
    }

    @Test
    public void test33() {
        final List<Integer> expected = Arrays.asList(1,33,528,5456,40920,237336,1107568,4272048,13884156,38567100,92561040,193536720,354817320,573166440,818809200,1037158320,1166803110,1166803110,1037158320,818809200,573166440,354817320,193536720,92561040,38567100,13884156,4272048,1107568,237336,40920,5456,528,33,1);

        final List<Integer> actual = callMethod(33);

        TestUtil.assertion(expected, actual);
    }

}
