package me.surendra.leetcode.graph.topological_sort;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * @see <a href="https://leetcode.com/problems/parallel-courses-iii/">Parallel Courses III</a>
 */
public class ParallelCoursesIII {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int minimumTime(final int n, final int[][] relations, final int[] time) {

        final int[] inDegreeArr = new int[n];
        final int[] courseMaxTimeArr = new int[n];
        final Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            courseMaxTimeArr[i] = time[i];
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int[] relation: relations) {
            final int courseRequired = relation[0] - 1;
            final int course = relation[1] - 1;
            inDegreeArr[course]++;
            adjacencyList.get(courseRequired).add(course);
        }

        final Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegreeArr.length; i++) {
            if (inDegreeArr[i] == 0) {
                q.add(i);
            }
        }


        int maxCourseDuration = 0;
        while (!q.isEmpty()) {
            final int size = q.size();

            for (int i = 0; i < size; i++) {
                final int courseId = q.remove();

                maxCourseDuration = Math.max(maxCourseDuration, courseMaxTimeArr[courseId]);

                for (int nextCourseId: adjacencyList.get(courseId)) {
                    inDegreeArr[nextCourseId]--;
                    courseMaxTimeArr[nextCourseId] = Math.max(courseMaxTimeArr[nextCourseId],
                        courseMaxTimeArr[courseId] + time[nextCourseId]
                    );
                    if (inDegreeArr[nextCourseId] == 0) {
                        q.add(nextCourseId);
                    }
                }
            }
        }

        return maxCourseDuration;
    }

}
