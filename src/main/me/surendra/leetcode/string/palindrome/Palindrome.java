package me.surendra.leetcode.string.palindrome;

/**
 * @see <a href="https://leetcode.com/problems/valid-palindrome-ii/">Valid Palindrome</a>
 */
public class Palindrome {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public boolean isValidPalindrome_2PointerApproach(final String str) {
        int startPointer=0, endPointer =str.length()-1;
        while(startPointer < endPointer) {
            if (str.charAt(startPointer) == str.charAt(endPointer)) {
                startPointer++;
                endPointer--;
                continue;
            }
            /*
            Check two substrings, one by removing left character and one by removing right character and
            if one of them is palindrome then we can make complete string palindrome by removing corresponding character,
            and if both substrings are not palindrome
                then it is not possible to make complete string a palindrome under given constraint.
            https://www.geeksforgeeks.org/remove-character-string-make-palindrome/
             */
            if(isPalindrome(str, startPointer+1, endPointer) ||
                isPalindrome(str, startPointer, endPointer-1)
            ) {
                return true;
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(final String str, int startIndex, int endIndex) {
        while(startIndex < endIndex) {
            if (str.charAt(startIndex) != str.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }

    /*
        Time Complexity - O(n^2)
        Space Complexity - O(n)
     */
    public boolean isValidPalindrome_BruteForceAlgoUsesSubString(final String str) {
        for (int i = 0; i< str.length(); i++) {
            final String newStr = str.substring(0, i) + str.substring(i+1);
            boolean palindrome = isPalindrome(newStr, newStr.length());
            if (palindrome) {
                return true;
            }
        }
        return false;
    }

    private boolean isPalindrome(final String str, final int strLen) {
        for (int i=0; i<strLen/2; i++) {
            if (str.charAt(i) != str.charAt(strLen-1-i)) {
                return false;
            }
        }
        return true;
    }

    /*
        Time Complexity - O(n^2)
        Space Complexity - O(n)
     */
    public boolean isValidPalindrome_BruteForceUsesStringBuilder(final String str) {
        final StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < stringBuilder.length(); i++) {
            char ch = stringBuilder.charAt(i);
            stringBuilder.deleteCharAt(i);
            if(isPalindrome(stringBuilder)) {
                return true;
            }
            stringBuilder.insert(i, ch);
        }
        return isPalindrome(stringBuilder);
    }

    private boolean isPalindrome(final StringBuilder stringBuilder) {
        final int length = stringBuilder.length();
        for (int i = 0; i < length / 2; i++) {
            if (stringBuilder.charAt(i) != stringBuilder.charAt(length-1-i)) {
                return false;
            }
        }
        return true;
    }

}
