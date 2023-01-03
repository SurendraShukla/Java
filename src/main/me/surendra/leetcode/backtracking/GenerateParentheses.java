package me.surendra.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/">Generate Parentheses</a>
 */
public class GenerateParentheses {

    /*
        Time complexity: 0(4 ^ n)
        Space complexity: 0(4 ^ n)
     */
    /**
        Time complexity: O(n * (2 ^ 2n))
                The recursion tree in this problem is a binary tree where
                    vertices represent incomplete sequences of brackets and
                    edges represent the choice of the next bracket (either left or the right).
                The height of the tree is 2n, since we must branch once per bracket.
                    So the number of vertices is at most 2^2n and
                    the number of leaves is at most half the number of vertices of a perfect tree,
                so asymptotically O(2^2n).

                Additionally we do linear work per leaf to copy the sequence to output.
                A more complete analysis would take into account that some bracket choices are invalid,
                    which leads to asymptotically fewer leaves in the tree.
                However since we are interested in upper bounds,
                    it's still correct to say that time complexity is O(n*(2^2n)),
                    even though it's not the most accurate upper bound.
        Space complexity: (n * (2 ^ 2n))
     */
    int no;
    List<String> returnList = new ArrayList<>();
    public List<String> generateParenthesisUsingStringBuilderForBacktracking(final int n) {
        this.no = n;
        backtrack(0, 0, new StringBuilder());
        return returnList;
    }

    private void backtrack(final int open, final int close, final StringBuilder sb) {
        if (open == no && close == no) {
            returnList.add(sb.toString());
            return;
        }
        if (open < no) {
            sb.append("(");
            backtrack(open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /*
        Time complexity: O(n * (2 ^ 2n))
        Space complexity: (n * (2 ^ 2n))
     */
    public List<String> generateParenthesisUsingStringForBacktracking(final int n) {
        this.no = n;
        backtrack(0, 0, "");
        return returnList;
    }

    private void backtrack(final int open, final int close, final String str) {
        if (open == no && close == no) {
            returnList.add(str);
            return;
        }
        if (open < no) {
            backtrack(open + 1, close, str + "(");
        }
        if (close < open) {
            backtrack(open, close + 1, str + ")");
        }
    }

    /*
        Time complexity: O(4 ^ n)
        Space complexity: O(4 ^ n)
     */
    public List<String> generateParenthesisUsingIterativeInsertion(final int n) {
        Set<String> returnList = new HashSet<>();
        for (int i = 0; i < n; i++) {
            final Set<String> tmpList = new HashSet<>();
            if (i == 0) {
                tmpList.add("()");
            } else {
                for (final String str : returnList) {
                    for (int j = 0; j < str.length(); j++) {
                        tmpList.add(str.substring(0, j) + "()" + str.substring(j));
                    }
                }
            }
            returnList = tmpList;
        }
        return new ArrayList<>(returnList);
    }

}
