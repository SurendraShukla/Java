package me.surendra.leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/pascals-triangle/">Pascal's Triangle</a>
 */
public class PascalTriangle {

    /*
        Time complexity: O(n ^ 2)
        Space complexity: O(n ^ 2)
     */
    public List<List<Integer>> generate(final int numRows) {

        final List<List<Integer>> triangle = new ArrayList<>();
        // Base case; first row is always [1].
        triangle.add(Arrays.asList(1));

        for (int rowNo = 1; rowNo < numRows; rowNo++) {
            final List<Integer> row = new ArrayList<>();
            final List<Integer> previousRow = triangle.get(rowNo - 1);
            // The first row element is always 1.
            row.add(1);
            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int no = 1; no < previousRow.size(); no++) {
                row.add(previousRow.get(no - 1) + previousRow.get(no));
            }
            // The last row element is always 1.
            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }

}
