package me.surendra.data_structures.recursion.backtracking;

import org.junit.Test;

public class StringsTest {

    @Test
    public void getAllStringPermutation() {
        System.out.println(Strings.getAllPermutation("a"));
        System.out.println(Strings.getAllPermutation("ab"));
        System.out.println(Strings.getAllPermutation("abc"));
        System.out.println(Strings.getAllPermutation("abcd"));
        System.out.println(Strings.getAllPermutation("abcde"));
    }

    @Test
    public void getAllStringPermutationRecursively() {
        System.out.println(Strings.getAllPermutationRecursively("a"));
        System.out.println(Strings.getAllPermutationRecursively("ab"));
        System.out.println(Strings.getAllPermutationRecursively("abc"));
        System.out.println(Strings.getAllPermutationRecursively("abcd"));
        System.out.println(Strings.getAllPermutationRecursively("abcde"));
    }

}
