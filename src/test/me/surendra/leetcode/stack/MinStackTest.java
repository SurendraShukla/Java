package me.surendra.leetcode.stack;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MinStackTest {
    private MinStack minStackImpl;

    @Before
    public void setUp() throws Exception {
        minStackImpl = new MinStackImplWith2Stacks();
//        minStackImpl = new MinStackImplWithOneStack();
    }

    @Test
    public void test1() {
        minStackImpl.push(-2);
        minStackImpl.push(0);
        minStackImpl.push(-3);
        assertThat(minStackImpl.getMin(), equalTo(-3));

        minStackImpl.pop();
        assertThat(minStackImpl.top(), equalTo(0));
        assertThat(minStackImpl.getMin(), equalTo(-2));
    }


    @Test
    public void test2() {
        minStackImpl.push(-2);
        minStackImpl.push(0);
        minStackImpl.push(-1);
        assertThat(minStackImpl.getMin(), equalTo(-2));

        assertThat(minStackImpl.top(), equalTo(-1));
        minStackImpl.pop();

        assertThat(minStackImpl.getMin(), equalTo(-2));
    }

}
