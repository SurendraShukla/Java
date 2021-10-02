package me.surendra.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/">Generate Parentheses</a>
 */
public class GenerateParentheses {

    /*
        Insert () between already generated valid parenthesis
     */
    public List<String> generateParenthesisUsingIterativeInsertion(int n) {
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            final Set<String> tmp = new HashSet<>();
            if (i == 0) {
                tmp.add("()");
            }else {
                for (String str : resultSet) {
                    for (int j = 1; j <= str.length(); j++) {
                        final String tmpStr = str.substring(0, j) + "()" + str.substring(j);
                        tmp.add(tmpStr);
                    }
                    tmp.add(str + "()");
                }
            }
            resultSet = tmp;
        }
        return new LinkedList<>(resultSet);
    }

    public List<String> generateParenthesisUsingBacktracking(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
