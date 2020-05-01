package me.surendra.leetcode.recursion;

public class ReverseString {

    public static void reverseString(char[] s) {
        reverseString(0, s);
    }

    public static void reverseString(int counter, char[] s) {
        if (counter > s.length-1) return;
        char c = s[s.length-1-counter];
        reverseString(counter+1, s);
        s[counter] = c;
    }

}
