package me.surendra.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/longest-absolute-file-path/">Longest Absolute File Path</a>
 */
public class LongestAbsoluteFilePathFinder {

    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)

        https://www.youtube.com/watch?v=EtmOdDYrU0U
     */
    public int lengthLongestPathUsingArray(final String input) {
        int longestAbsolutePath = 0;
        final String[] lines = input.split("\n");
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(-1, 0);

        for (String line: lines) {
            final int depth = line.lastIndexOf("\t") + 1;
            final int currentLength = line.length() - depth + map.get(depth - 1);
            map.put(depth, currentLength);

            if (line.contains(".")) {
                longestAbsolutePath = Math.max(longestAbsolutePath, map.get(depth) + depth);
            }
        }

        return longestAbsolutePath;
    }

    public int lengthLongestPathUsingStack(final String input) {
        int longestAbsolutePath = 0;
        final Stack<Integer> directories = new Stack<>();
        directories.push(0);

        for (String line: input.split("\n")) {
            final int level = line.lastIndexOf("\t") + 1;
            final int currentLength = line.length();

            if (line.contains(".")) {
                longestAbsolutePath = Math.max(longestAbsolutePath, directories.peek() + currentLength);
            } else {
                while (directories.size() > level) {
                    directories.pop();
                }
                final int parentDirectoryLength = directories.isEmpty() ? 0 : directories.peek();
                directories.add(parentDirectoryLength + currentLength - level);
            }
        }

        return longestAbsolutePath;
    }

}
