package me.surendra.leetcode.array;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sum3Test {
    @Test
    public void test1() {
        final int[] nums = {-1,0,1,2,-1,-4};
        final int[][] expected = {{-1,-1,2}, {-1,0,1}};

//        List<List<int[]>> collect = Arrays.stream(expected)
//            .map(Arrays::asList)
//            .collect(Collectors.toList());
        List<List<Integer>> lists = new Sum3().threeSum(nums);

    }
}
