package me.surendra.leetcode.graph.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/keys-and-rooms/">Keys and Rooms</a>
 */
public class KeysAndRoomsChecker {

    /*
        Time Complexity - O(N + E) N is Node/rooms, E is Edge/keys
        Space Complexity - O(N) N is Node/rooms
     */
    public boolean canVisitAllRoomsUsingBfs(final List<List<Integer>> rooms) {
        final boolean[] visited = new boolean[rooms.size()];
        final Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            final int currentRoom = q.remove();
            visited[currentRoom] = true;
            for (int nextRoom: rooms.get(currentRoom)) {
                if (visited[nextRoom]) {
                    continue;
                }
                q.add(nextRoom);
            }
        }

        for (boolean isVisited: visited) {
            if (!isVisited) {
                return false;
            }
        }
        return true;
    }

    /*
        Time Complexity - O(N + E) N is Node/rooms, E is Edge/keys
        Space Complexity - O(N) N is Node/rooms
     */
    public boolean canVisitAllRoomsUsingDfs(final List<List<Integer>> rooms) {
        final boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        final Stack<Integer> stack = new Stack();
        stack.push(0);

        //At the beginning, we have a todo list "stack" of keys to use.
        //'seen' represents at some point we have entered this room.
        while (!stack.isEmpty()) { // While we have keys...
            final int node = stack.pop(); // Get the next key 'node'
            for (int nei: rooms.get(node)) // For every key in room # 'node'...
                if (!seen[nei]) { // ...that hasn't been used yet
                    seen[nei] = true; // mark that we've entered the room
                    stack.push(nei); // add the key to the todo list
                }
        }


        for (boolean v: seen) {
            // if any room hasn't been visited, return false
            if (!v) {
                return false;
            }
        }
        return true;
    }

}
