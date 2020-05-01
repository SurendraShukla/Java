package me.surendra.data_structures.recursion.backtracking;

import com.google.common.collect.Lists;

import java.util.List;

public class Strings {
    public static List<Integer> generateAllStringsForBites(final List<Integer> inputList, final int n) {
        if (n == 1) {
            inputList.add(0);
            inputList.add(1);
            return inputList;
        }
        final List<Integer> outputList = generateAllStringsForBites(inputList, n-1);
//        outputList.stream().
        return outputList;
    }
}
