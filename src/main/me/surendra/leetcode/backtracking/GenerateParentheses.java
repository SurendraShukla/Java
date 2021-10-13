package me.surendra.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/">Generate Parentheses</a>
 */
public class GenerateParentheses {

    int n;
    int totalBrackets;
    List<String> returnList = new ArrayList<>();
    public List<String> generateParenthesisUsingBacktracking(final int n) {
        this.n = n;
        totalBrackets = n * 2;
        backtracking(0, new StringBuilder());
        return returnList;
    }

    private void backtracking(final int idx, final StringBuilder stringBuilder) {
        if (idx == totalBrackets) {
            returnList.add(stringBuilder.toString());
            return;
        }
        if (idx < n) {
            stringBuilder.append("(");
            backtracking(idx + 1, stringBuilder);
            stringBuilder.deleteCharAt(idx);
        }
        if (stringBuilder.length() < totalBrackets) {
            stringBuilder.append(")");
            backtracking(idx + 1, stringBuilder);
            stringBuilder.deleteCharAt(idx);
        }
    }

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public List<String> generateParenthesisUsingIterativeInsertion(final int n) {
        Set<String> returnList = new HashSet<>();
        for (int i = 0; i < n; i++) {
            final Set<String> tmpList = new HashSet<>();
            if (i == 0) {
                tmpList.add("()");
            }else{
                for (final String str : returnList) {
                    for (int j = 0; j < str.length(); j++) {
                        tmpList.add(str.substring(0, j) + "()" + str.substring(j));
                    }
                }
            }
            returnList = tmpList;
        }
        return returnList.stream().collect(Collectors.toList());
    }

}
