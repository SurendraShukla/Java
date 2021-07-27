package me.surendra.leetcode;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class HammingUnitFinderTest {

    private int hammingDistance(final int x, final int y) {
        return new HammingUnitFinder().hammingDistanceUsingBitCountMethod(x, y);
//        return new HammingUnitFinder().hammingDistanceUsingBitShift(x, y);
//        return new HammingUnitFinder().hammingDistanceUsingBrianKernighanAlgorithm(x, y);
//        return new HammingDistanceFinder().hammingDistance(x, y);
    }

    private int hammingWeight(final int x) {
//        return new HammingUnitFinder().hammingWeight(x);
        return new HammingUnitFinder().hammingWeightUsingBrianKernighanAlgorithm(x);
    }

    @Test
    public void testHammingDistance() {
        assertThat(hammingDistance(1, 4), equalTo(2));
        assertThat(hammingDistance(3, 1), equalTo(1));
    }

    @Test
    public void testHammingWeight() {
        assertThat(hammingWeight(00000000000000000000000000001011), equalTo(3));
        assertThat(hammingWeight(00000000000000000000000010000000), equalTo(1));
//        assertThat(hammingWeight(11111111111111111111111111111101), equalTo(31));
    }
}
