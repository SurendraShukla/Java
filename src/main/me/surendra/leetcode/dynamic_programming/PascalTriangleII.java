package me.surendra.leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/pascals-triangle-ii/">Pascal's Triangle II</a>
 */
public class PascalTriangleII {

    /*
        Time complexity: O(n ^ 2)
        Space complexity: O(n ^ 2)
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> triangle = new ArrayList<>();
        // Base case; first row is always 1.
        triangle.add(1);

        for(int rowNo=1; rowNo<=rowIndex; rowNo++) {
            final List<Integer> row = new ArrayList<>();
            // The first row element is always 1.
            row.add(1);
            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int no=1; no<triangle.size(); no++) {
                row.add(triangle.get(no-1) + triangle.get(no));
            }
            // The last row element is always 1.
            row.add(1);
            triangle = row;
        }
        return triangle;
    }

}
