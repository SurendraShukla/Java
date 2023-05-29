package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static me.surendra.leetcode.linked_list.ConvertBinaryNumberToInteger.usingArithmeticOperator;
import static me.surendra.leetcode.linked_list.ConvertBinaryNumberToInteger.usingBitwiseOperator;
import static me.surendra.leetcode.linked_list.ConvertBinaryNumberToInteger.usingSelfThought;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class ConvertBinaryNumberToIntegerTest {

    @Test
    public void getDecimalValueFor5() {
        final ListNode linkedList = LinkedList.from(new int[]{1, 0, 1});

        assertThat(usingSelfThought(linkedList), equalTo(5));
        assertThat(usingBitwiseOperator(linkedList), equalTo(5));
        assertThat(usingArithmeticOperator(linkedList), equalTo(5));
    }

    @Test
    public void getDecimalValueFor1() {
        final ListNode linkedList = LinkedList.from(new int[]{1});

        assertThat(usingSelfThought(linkedList), equalTo(1));
        assertThat(usingBitwiseOperator(linkedList), equalTo(1));
        assertThat(usingArithmeticOperator(linkedList), equalTo(1));
    }

    @Test
    public void getDecimalValueFor18880() {
        int[] intArray = {1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        final ListNode linkedList = LinkedList.from(intArray);

        System.out.println(intArray.length);

        assertThat(usingSelfThought(linkedList), equalTo(18880));
        assertThat(usingBitwiseOperator(linkedList), equalTo(18880));
        assertThat(usingArithmeticOperator(linkedList), equalTo(18880));
    }

    @Test
    public void getDecimalValueFor0() {
        final ListNode linkedList = LinkedList.from(new int[]{0, 0});

        assertThat(usingSelfThought(linkedList), equalTo(0));
        assertThat(usingBitwiseOperator(linkedList), equalTo(0));
        assertThat(usingArithmeticOperator(linkedList), equalTo(0));
    }

    @Test
    public void getDecimalValueFor4() {
        final ListNode linkedList = LinkedList.from(new int[]{1, 0, 0});

        assertThat(usingSelfThought(linkedList), equalTo(4));
        assertThat(usingBitwiseOperator(linkedList), equalTo(4));
        assertThat(usingArithmeticOperator(linkedList), equalTo(4));
    }

}
