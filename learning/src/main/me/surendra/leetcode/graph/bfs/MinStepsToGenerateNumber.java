package me.surendra.leetcode.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/discuss/interview-question/406663/Bloomberg-or-Phone-Screen-or-Min-Steps-to-Generate-Number">Min Steps to Generate Number</a>
 *
 * Initial 15 minutes resume and experience. Then, one technical question on coderpad:
 * Given an int n. You can use only 2 operations:
 *      multiply by 2
 *      integer division by 3 (e.g. 10 / 3 = 3)
 * Find the minimum number of steps required to generate n from 1.
 *
 * Example 1:
 *   Input: 10
 *   Output: 6
 *      Explanation: 1 * 2 * 2 * 2 * 2 / 3 * 2
 *      6 steps required, as we have used 5 multiplications by 2, and one division by 3.
 * Example 2:
 *  Input: 3
 *  Output: 7
 *      Explanation: 1 * 2 * 2 * 2 * 2 * 2 / 3 / 3
 *      7 steps required, as we have used 5 multiplications by 2 and 2 divisions by 3.
 */
public class MinStepsToGenerateNumber {

    public static int minSteps(final int n) {

        final Queue<Integer> q = new LinkedList<>();
        final Set<Integer> visited = new HashSet<>();
        q.add(1);

        int steps = 0;
        while (!q.isEmpty()) {
            final int size = q.size();
            for (int i = 0; i < size; i++) {
                final int no = q.remove();
                if (no == n) {
                    return steps;
                }
                if (visited.contains(no)) {
                    continue;
                }
                q.add(no * 2);
                q.add(no / 3);
            }
            steps++;
        }

        return -1;
    }

}
