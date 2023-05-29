package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class CircularQueueDesignerTest {

    @Test
    public void test() {
        final CircularQueueDesigner circularQueue = new CircularQueueDesigner(3);

        assertThat(circularQueue.enQueue(1), equalTo(true));
        assertThat(circularQueue.enQueue(2), equalTo(true));
        assertThat(circularQueue.enQueue(3), equalTo(true));

        assertThat(circularQueue.enQueue(4), equalTo(false));

        assertThat(circularQueue.front(), equalTo(1));
        assertThat(circularQueue.rear(), equalTo(3));
        assertThat(circularQueue.isFull(), equalTo(true));

        assertThat(circularQueue.deQueue(), equalTo(true));
        assertThat(circularQueue.enQueue(4), equalTo(true));

        assertThat(circularQueue.rear(), equalTo(4));
    }

}
