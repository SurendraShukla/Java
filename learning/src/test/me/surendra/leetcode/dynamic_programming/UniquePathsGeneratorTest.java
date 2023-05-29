package me.surendra.leetcode.dynamic_programming;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class UniquePathsGeneratorTest {

    private final UniquePathsGenerator uniquePathsGenerator = new UniquePathsGenerator();

    private List<String> callMethod(final int m, final int n) {
//        return uniquePathsGenerator.uniquePaths(m, n);
//        return uniquePathsGenerator.uniquePaths2(m, n);
        return uniquePathsGenerator.uniquePathsByVijayApproach(m, n);
    }

    private void verify(final List<String> uniquePaths, final int expected) {
        assertThat(uniquePaths.size(), equalTo(expected));
    }

    @Test
    public void oneDimension() {
//        verify(callMethod(1, 1), 1);
        verify(callMethod(1, 2), 1);
//        verify(callMethod(2, 1), 1);
//        verify(callMethod(1, 3), 1);
//        verify(callMethod(3, 1), 1);
    }

    @Test
    public void twoByTwo() {
        verify(callMethod(2, 2), 2);
        verify(callMethod(2, 3), 3);
        verify(callMethod(3, 2), 3);
        verify(callMethod(3, 3), 6);
        verify(callMethod(3, 7), 28);
    }

    @Test
    public void inputMaxLimit() {
//        verify(callMethod(100, 100), 4631081169483718960L);
    }

}
