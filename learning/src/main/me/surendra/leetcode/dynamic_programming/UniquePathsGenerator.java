package me.surendra.leetcode.dynamic_programming;


import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/unique-paths/">Unique Paths</a>
 */
public class UniquePathsGenerator {

    /*
        Time complexity : O(m * n)
        Space complexity: O(m * n)
     */
    int rowMax;
    int colMax;
    List<String> returnList;
    public List<String> uniquePaths(final int m, final int n) {
        returnList = new ArrayList<>();
        rowMax = m - 1;
        colMax = n - 1;
        populate(0, 0, new StringBuilder());
        return returnList;
    }

    private void populate(final int row, final int col, final StringBuilder stringBuilder) {
        if (row == rowMax && col == colMax) {
            returnList.add(stringBuilder.toString());
            return;
        }
        // Bottom
        if (row + 1 <= rowMax) {
            stringBuilder.append("B");
            populate(row + 1, col, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        // Top
        if (col + 1 <= colMax) {
            stringBuilder.append("R");
            populate(row, col + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public List<String> uniquePaths2(final int m, final int n) {
        rowMax = m - 1;
        colMax = n - 1;
        final List<StringBuilder> uniquePathDirections = populate(0, 0);

        final List<String> uniquePaths = new ArrayList<>();
        for (StringBuilder stringBuilder: uniquePathDirections) {
            final String s = stringBuilder.reverse().toString();
            uniquePaths.add(s);
        }
        return uniquePaths;
    }

    private List<StringBuilder> populate(final int row, final int col) {
        if (row == rowMax && col == colMax) {
            return new ArrayList<>();
        }
        final List<StringBuilder> uniquePathDirections = new ArrayList<>();
        if (row + 1 <= rowMax) {
            final List<StringBuilder> tmpList = populate(row + 1, col);
            if (tmpList.isEmpty()) {
                uniquePathDirections.add(new StringBuilder("R"));
            } else {
                for (StringBuilder stringBuilder: tmpList) {
                    uniquePathDirections.add(stringBuilder.append("R"));
                }
            }
        }
        if (col + 1 <= colMax) {
            final List<StringBuilder> tmpList = populate(row, col + 1);
            if (tmpList.isEmpty()) {
                uniquePathDirections.add(new StringBuilder("B"));
            } else {
                for (StringBuilder stringBuilder: tmpList) {
                    uniquePathDirections.add(stringBuilder.append("B"));
                }
            }
        }
        return uniquePathDirections;
    }


    List<List<String>> result;
    List<String> subResult;
    public List<String> uniquePathsByVijayApproach(final int m, final int n) {
        result = new ArrayList<>();
        subResult = new ArrayList<>();
        gridTravel(m, n, "", 0);

        final List<String> list = new ArrayList<>();
        for (List<String> resultChar: result) {
            list.add(resultChar.toString());
        }
        return list;
    }

    public void gridTravel(final int m, final int n, final String direction, final int level) {
        if (m == 0 || n == 0) {
            return;
        }
        if (subResult.size() > level) {
            subResult = subResult.subList(0, level - 1);
        }

        if (!direction.isEmpty()) {
            subResult.add(direction);
        }

        if (m == 1 && n == 1) {
            final List<String> current = new ArrayList<>();
            current.addAll(subResult);
            result.add(current);
            return;
        }

        gridTravel(m - 1, n, "b", level + 1);
        gridTravel(m, n - 1, "r", level + 1);
    }
}
