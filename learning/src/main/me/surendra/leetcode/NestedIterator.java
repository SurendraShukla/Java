package me.surendra.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/flatten-nested-list-iterator/">Flatten Nested List Iterator</a>
 */
public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> integerQueue = new LinkedList<>();
    private int currentIndex = 0;
    private int totalElements = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        populateQueue(nestedList);
    }

    private void populateQueue(final List<NestedInteger> nestedList) {
        for (final NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                integerQueue.add(nestedInteger.getInteger());
                totalElements++;
            }else{
                populateQueue(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if (currentIndex < totalElements) {
            currentIndex++;
            return integerQueue.poll();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < totalElements;
    }

}
