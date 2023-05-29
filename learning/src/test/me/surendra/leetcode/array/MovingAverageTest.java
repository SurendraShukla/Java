package me.surendra.leetcode.array;


import org.junit.Test;

import java.text.DecimalFormat;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MovingAverageTest {

    final DecimalFormat df = new DecimalFormat("#.00000");
    MovingAverage movingAverage;

    private String callMethod(final Integer val) {
        final double result = movingAverage.next(val);
        return df.format(result);
    }

    private String getExpectedResult(final Double expected) {
        return df.format(expected);
    }

    @Test
    public void testWith4Call() {
        movingAverage = new MovingAverage(3);

        final List<List<? extends Number>> inputAndOutputData = getSmallInputAndOutputData();
        for (List<? extends Number> data: inputAndOutputData) {
            final String actual = callMethod(data.get(0).intValue());
            final String expected = getExpectedResult(data.get(1).doubleValue());
            assertThat(actual, equalTo(expected));
        }
    }

    @Test
    public void testWith100Call() {
        movingAverage = new MovingAverage(20);

        final List<List<? extends Number>> inputAndOutputData = getLargeInputAndOutputData();
        for (List<? extends Number> data: inputAndOutputData) {
            final String actual = callMethod(data.get(0).intValue());
            final String expected = getExpectedResult(data.get(1).doubleValue());
            assertThat(actual, equalTo(expected));
        }
    }

    private List<List<? extends Number>> getSmallInputAndOutputData() {
        final List<List<? extends Number>> returnList = newArrayList(
            newArrayList(1, 1.0),
            newArrayList(10, 5.5),
            newArrayList(3, 4.66667),
            newArrayList(5, 6.0)
            );
        return returnList;
    }

    private List<List<? extends Number>> getLargeInputAndOutputData() {
        final List<List<? extends Number>> returnList = newArrayList(
            newArrayList(23637, 23637.00000),
            newArrayList(-11625, 6006.00000),
            newArrayList(-5615, 2132.33333),
            newArrayList(-32455, -6514.50000),
            newArrayList(-4011, -6013.80000),
            newArrayList(-2940, -5501.50000),
            newArrayList(-9682, -6098.71429),
            newArrayList(21676, -2626.87500),
            newArrayList(-26616, -5292.33333),
            newArrayList(17045, -3058.60000),
            newArrayList(25362, -474.90909),
            newArrayList(-29570, -2899.50000),
            newArrayList(-15360, -3858.00000),
            newArrayList(-32552, -5907.57143),
            newArrayList(17348, -4357.20000),
            newArrayList(11362, -3374.75000),
            newArrayList(822, -3127.88235),
            newArrayList(-25697, -4381.72222),
            newArrayList(-29180, -5686.89474),
            newArrayList(16630, -4571.05000),
            newArrayList(30227, -4241.55000),
            newArrayList(1483, -3586.15000),
            newArrayList(29470, -1831.90000),
            newArrayList(14410, 511.35000),
            newArrayList(-26439, -610.05000),
            newArrayList(-17137, -1319.90000),
            newArrayList(12798, -195.90000),
            newArrayList(30882, 264.40000),
            newArrayList(16298, 2410.10000),
            newArrayList(-30495, 33.10000),
            newArrayList(11481, -660.95000),
            newArrayList(-32419, -803.40000),
            newArrayList(-2946, -182.70000),
            newArrayList(-9264, 981.70000),
            newArrayList(-13300, -550.70000),
            newArrayList(21715, -33.05000),
            newArrayList(22524, 1052.05000),
            newArrayList(11045, 2889.15000),
            newArrayList(4417, 4569.00000),
            newArrayList(-15042, 2985.40000),
            newArrayList(8045, 1876.30000),
            newArrayList(-31304, 236.95000),
            newArrayList(21742, -149.45000),
            newArrayList(-17831, -1761.50000),
            newArrayList(-29418, -1910.45000),
            newArrayList(-10879, -1597.55000),
            newArrayList(16123, -1431.30000),
            newArrayList(-18726, -3911.70000),
            newArrayList(19135, -3769.85000),
            newArrayList(713, -2209.45000),
            newArrayList(-2752, -2921.10000),
            newArrayList(-28381, -2719.20000),
            newArrayList(2820, -2430.90000),
            newArrayList(-32150, -3575.20000),
            newArrayList(-25995, -4209.95000),
            newArrayList(-28554, -6723.40000),
            newArrayList(-22725, -8985.85000),
            newArrayList(-934, -9584.80000),
            newArrayList(-11983, -10404.80000),
            newArrayList(3360, -9484.70000),
            newArrayList(30530, -8360.45000),
            newArrayList(-11762, -7383.35000),
            newArrayList(21171, -7411.90000),
            newArrayList(25964, -5222.15000),
            newArrayList(20898, -2706.35000),
            newArrayList(469, -2138.95000),
            newArrayList(-15350, -3712.60000),
            newArrayList(1398, -2706.40000),
            newArrayList(-21969, -4761.60000),
            newArrayList(-17686, -5681.55000),
            newArrayList(24260, -4330.95000),
            newArrayList(-13108, -3567.30000),
            newArrayList(14043, -3006.15000),
            newArrayList(17426, -527.35000),
            newArrayList(23885, 1966.65000),
            newArrayList(26660, 4727.35000),
            newArrayList(-2828, 5722.20000),
            newArrayList(-9470, 5295.40000),
            newArrayList(13214, 6555.25000),
            newArrayList(23249, 7549.70000),
            newArrayList(-17781, 5134.15000),
            newArrayList(16086, 6526.55000),
            newArrayList(29081, 6922.05000),
            newArrayList(4686, 5858.15000),
            newArrayList(6411, 5133.80000),
            newArrayList(19428, 6081.75000),
            newArrayList(-17740, 5962.25000),
            newArrayList(-23564, 4714.15000),
            newArrayList(-22063, 4709.45000),
            newArrayList(-3570, 5415.25000),
            newArrayList(15530, 4978.75000),
            newArrayList(27195, 6993.90000),
            newArrayList(12369, 6910.20000),
            newArrayList(4861, 6281.95000),
            newArrayList(-16436, 4265.90000),
            newArrayList(20578, 3961.80000),
            newArrayList(-30233, 2591.55000),
            newArrayList(7350, 3432.55000),
            newArrayList(-12937, 2125.00000),
            newArrayList(-26468, -360.85000)
        );
        return returnList;
    }
}
