package me.surendra.leetcode.greedy;

/**
 * @see <a href="https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/">Minimum Add to Make Parentheses Valid</a>
 */
public class MakeParenthesesValid {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int minAddToMakeValid(String s) {
        int bracketsNeeded = 0;
        int openBracketCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(') {
                openBracketCount++;
            }else{
                if(openBracketCount == 0) {
                    bracketsNeeded++;
                }else{
                    openBracketCount--;
                }
            }
        }
        return bracketsNeeded + openBracketCount;
    }

}
