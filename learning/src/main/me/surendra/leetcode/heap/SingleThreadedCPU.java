package me.surendra.leetcode.heap;

import java.util.PriorityQueue;


/**
 * @see <a href="https://leetcode.com/problems/single-threaded-cpu/">Single-Threaded CPU</a>
 */
public class SingleThreadedCPU {

    /*
        Time complexity: O(n log n) Heap/Priority Queue
        Space complexity: O(n) Heap will store max n task
     */
    private final static int ENQUEUE_TIME = 0;
    private final static int PROCESSING_TIME = 1;
    private final static int INDEX = 2;
    public int[] getOrder(final int[][] tasks) {
        final PriorityQueue<int[]> taskQByEnqueueTime = new PriorityQueue<>(
            (task1, task2) -> task1[ENQUEUE_TIME] - task2[ENQUEUE_TIME]
        );
        for (int i = 0; i < tasks.length; i++) {
            final int[] task = tasks[i];
            taskQByEnqueueTime.add(new int[]{
                task[ENQUEUE_TIME], task[PROCESSING_TIME], i
            });
        }

        final PriorityQueue<int[]> taskQByProcessingTime = new PriorityQueue<>(
            (task1, task2) -> {
                if (task1[PROCESSING_TIME] == task2[PROCESSING_TIME]) {
                    return task1[INDEX] - task2[INDEX];
                }
                return task1[PROCESSING_TIME] - task2[PROCESSING_TIME];
            });
        int resultIdx = 0;
        int taskProcessTime = taskQByEnqueueTime.peek()[ENQUEUE_TIME];
        final int[] result = new int[tasks.length];
        while (!taskQByEnqueueTime.isEmpty()) {
            while (!taskQByEnqueueTime.isEmpty() &&
                taskQByEnqueueTime.peek()[ENQUEUE_TIME] <= taskProcessTime
            ) {
                final int[] task = taskQByEnqueueTime.remove();
                taskQByProcessingTime.add(task);
            }
            if (taskQByProcessingTime.isEmpty()) {
                taskProcessTime = taskQByEnqueueTime.peek()[ENQUEUE_TIME];
            } else {
                final int[] currentTask = taskQByProcessingTime.remove();
                result[resultIdx] = currentTask[INDEX];
                resultIdx++;
                taskProcessTime += currentTask[PROCESSING_TIME];
            }
        }

        while (!taskQByProcessingTime.isEmpty()) {
            result[resultIdx] = taskQByProcessingTime.remove()[INDEX];
            resultIdx++;
        }

        return result;
    }

}
