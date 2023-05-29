package me.surendra.leetcode.queue;

public class BoundedBlockingQueue {
    private int queueMaxSize = 0;
    private int noOfElementsInQueue = 0;
    private int startPointer = 0;
    private int endPointer = 0;
    private int[] queue;

    public BoundedBlockingQueue(int capacity) {
        this.queueMaxSize = capacity;
        this.queue = new int[capacity];
    }

    public void enqueue(int element) throws InterruptedException {
        if (noOfElementsInQueue == queueMaxSize) {
            return;
        }
        endPointer = (endPointer == queueMaxSize) ? 0 : endPointer;
        this.queue[endPointer] = element;
        endPointer++;
        noOfElementsInQueue++;
    }

    public int dequeue() throws InterruptedException {
        if (noOfElementsInQueue == 0) {
            return -1;
        }
//        startPointer = (startPointer == startPointer) ? 0 : startPointer;
        int val = queue[startPointer];
        queue[startPointer] = -1;
        startPointer++;
        noOfElementsInQueue--;
        return val;
    }

    public int size() {
        return noOfElementsInQueue;
    }

}
