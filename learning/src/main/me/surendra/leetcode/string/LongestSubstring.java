package me.surendra.leetcode.string;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
    public static List<String> getStringPermutation(final String str) {
        final ArrayList<String> arrayList = new ArrayList<>();
        if (str.length() < 0) {
            return arrayList;
        }
        final String[] charArray = str.split("");
        System.out.println(charArray[0]);
        if (str.length() == 1) {
            arrayList.add(charArray[0]);
            return arrayList;
        }
        return arrayList;
    }

//    public static List<String> withKDistinctCharacters(final String str, final int k) {
//        return new ArrayList<>();
//    }


}
