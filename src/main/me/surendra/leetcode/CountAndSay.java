package me.surendra.leetcode;

public class CountAndSay {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        final String str = countAndSay(n-1);
        int count = 0;
        char previousChar = str.charAt(0);

        final StringBuilder countAndSayStr = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == previousChar) {
                count++;
            }else{
                countAndSayStr.append(count).append(previousChar);
                count = 1;
                previousChar = str.charAt(j);
            }
        }
        return countAndSayStr.append(count).append(previousChar).toString();
    }

}
