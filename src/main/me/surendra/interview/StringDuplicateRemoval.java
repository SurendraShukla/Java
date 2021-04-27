package me.surendra.interview;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringDuplicateRemoval {

    public static List<String> duplicateRemoval(final String str1, final String str2) {
        final Set<String> str1Set = Arrays.stream(StringUtils.split(str1,",")).collect(Collectors.toSet());
        final Set<String> str2Set = Arrays.stream(StringUtils.split(str2,",")).collect(Collectors.toSet());
        final Set<String> commonStrings = new HashSet<>();

        for (final String str: str1Set) {
            if(str2Set.contains(str)) {
                commonStrings.add(str);
            }
        }

        str1Set.removeAll(commonStrings);
        str2Set.removeAll(commonStrings);
//
//        for (final String str: commonStrings) {
//            str1Set.remove(str);
//            str2Set.remove(str);
//        }

        final List<String> returnList = new ArrayList<>();
        returnList.add(String.join(",", str1Set));
        returnList.add(String.join(",", str2Set));
        return returnList;
    }

    public static void main(String[] args) {
        final String str1 = "Mangoes,Apples,Oranges,Mangoes";
        final String str2 = "Oranges,PineApples,Grapes,Grapes";
        StringDuplicateRemoval.duplicateRemoval(str1, str2);
    }

}
