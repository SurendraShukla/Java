package me.surendra.leetcode.stack;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MinStackTest {
    private MinStack minStack;

    @Before
    public void setUp() throws Exception {
        minStack = new MinStackImplWith2Stacks();
//        minStackImpl = new MinStackImplWithOneStack();
    }

    @Test
    public void test1() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertThat(minStack.getMin(), equalTo(-3));

        minStack.pop();
        assertThat(minStack.top(), equalTo(0));
        assertThat(minStack.getMin(), equalTo(-2));
    }


    @Test
    public void test2() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        assertThat(minStack.getMin(), equalTo(-2));

        assertThat(minStack.top(), equalTo(-1));
        minStack.pop();

        assertThat(minStack.getMin(), equalTo(-2));
    }

}
