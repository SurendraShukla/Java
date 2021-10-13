package me.surendra.leetcode.dynamic_programming;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EggDropFinderTest {

    private int callMethod(final int n) {
//        return new EggDropFinder().twoEggDropFromTopFloorDownwards(n);
        return new EggDropFinder().twoEggDropFromFirstFloorOnwards(n);
    }

    @Test
    public void test() {
        final Map<Integer, Integer> floorWithItsMinimumNoOfMoves = new HashMap<Integer, Integer>() {{
            put(1, 1);put(2, 2);put(3, 2);put(4, 3);put(5, 3);put(6, 3);put(7, 4);put(8, 4);put(9, 4);
            put(10, 4);put(11, 5);put(100, 14);put(1000, 45);
        }};

        for (final Map.Entry<Integer, Integer> map : floorWithItsMinimumNoOfMoves.entrySet()) {
            final Integer floors = map.getKey();
            final Integer minimumNoOfMoves = map.getValue();
            Assert.assertThat(callMethod(floors), Matchers.equalTo(minimumNoOfMoves));
        }

    }

}
