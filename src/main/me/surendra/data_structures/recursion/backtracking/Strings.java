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
        return outputList;
    }

    public static List<String> getAllPermutationRecursively(final String str) {
        List<String> possiblePermutation = Lists.newArrayList();
        if (str.length() == 1) {
            possiblePermutation.add(str);
            return possiblePermutation;
        }

        List<String> tmpPossiblePermutation = getAllPermutationRecursively(str.substring(1));
        return addCharToPossiblePermutationString(tmpPossiblePermutation, str.charAt(0));
    }


    public static List<String> getAllPermutation(final String str) {
        List<String> possiblePermutation = Lists.newArrayList();
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (possiblePermutation.size() == 0) {
                possiblePermutation.add(Character.toString(ch));
                continue;
            } else {
                possiblePermutation = addCharToPossiblePermutationString(possiblePermutation, ch);
            }
        }

        return possiblePermutation;
    }

    private static List<String> addCharToPossiblePermutationString(final List<String> possiblePermutation, final char ch) {
        final List<String> tmpPossiblePermutation = Lists.newArrayList();
        for (String tmpStr : possiblePermutation) {
            for (int position = 0; position <= tmpStr.length(); position++) {
                StringBuffer sb = new StringBuffer(tmpStr);
                sb.insert(position, ch);
                tmpPossiblePermutation.add(sb.toString());
            }
        }
        return tmpPossiblePermutation;
    }

}
