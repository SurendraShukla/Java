package me.surendra.leetcode.graph.topological_sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/course-schedule/">Course Schedule</a>
 */
public class CourseScheduler {

    /*
        Time Complexity - O(E + V) E for Edge (number of dependencies), V for Vertx (number of courses)
        Space Complexity - O(E + V)
     */
    final Map<Integer, List<Integer>> graph = new HashMap<>();
    final Map<Integer, Integer> inDegrees = new HashMap<>();
    public boolean canFinish(final int numCourses, final int[][] prerequisites) {
        createGraph(numCourses, prerequisites);

        final Queue<Integer> q = new LinkedList<>();
        for (int nodeIdx = 0; nodeIdx < numCourses; nodeIdx++) {
            if (inDegrees.get(nodeIdx) == 0) {
                q.add(nodeIdx);
            }
        }

        return checkByRemovingInDegrees(q, numCourses);
//        return checkByRemovingInDegrees(q);
    }

    private boolean checkByRemovingInDegrees(final Queue<Integer> q, final int numCourses) {
        final List<Integer> visited = new ArrayList<>();
        while (!q.isEmpty()) {
            final int currentCourse = q.remove();
            visited.add(currentCourse);
            final List<Integer> courseList = graph.get(currentCourse);
            for (int requiredCourse: courseList) {
                inDegrees.put(requiredCourse, inDegrees.get(requiredCourse) - 1);
                if (inDegrees.get(requiredCourse) == 0) {
                    q.add(requiredCourse);
                }
            }
        }
        return visited.size() == numCourses;
    }

    private boolean checkByRemovingInDegrees(final Queue<Integer> q) {
        while (!q.isEmpty() && !inDegrees.isEmpty()) {
            final int node = q.remove();
            inDegrees.remove(node);
            for (int currentNode: graph.get(node)) {
                inDegrees.put(currentNode, inDegrees.get(currentNode) - 1);
                if (inDegrees.get(currentNode) == 0) {
                    q.add(currentNode);
                }
            }
        }
        return inDegrees.isEmpty();
    }

    private void createGraph(final int numCourses, final int[][] prerequisites) {
        for (int node = 0; node < numCourses; node++) {
            graph.put(node, new ArrayList<>());
            inDegrees.put(node, 0);
        }

        for (int[] prerequisite: prerequisites) {
            final int parentNode = prerequisite[0];
            final int childNode  = prerequisite[1];
            graph.get(parentNode).add(childNode);
            inDegrees.put(childNode, inDegrees.get(childNode) + 1);
        }
    }

}
