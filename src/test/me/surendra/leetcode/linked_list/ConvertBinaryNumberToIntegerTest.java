package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class ConvertBinaryNumberToIntegerTest {

    @Test
    public void getDecimalValueFor5() {
        final ListNode linkedList = LinkedList.from(new int[]{1, 0, 1});

        assertThat(ConvertBinaryNumberToInteger.usingSelfThought(linkedList), equalTo(5));
        assertThat(ConvertBinaryNumberToInteger.usingBitwiseOperator(linkedList), equalTo(5));
        assertThat(ConvertBinaryNumberToInteger.usingArithmeticOperator(linkedList), equalTo(5));
    }

    @Test
    public void getDecimalValueFor1() {
        final ListNode linkedList = LinkedList.from(new int[]{1});

        assertThat(ConvertBinaryNumberToInteger.usingSelfThought(linkedList), equalTo(1));
        assertThat(ConvertBinaryNumberToInteger.usingBitwiseOperator(linkedList), equalTo(1));
        assertThat(ConvertBinaryNumberToInteger.usingArithmeticOperator(linkedList), equalTo(1));
    }

    @Test
    public void getDecimalValueFor18880() {
        int[] intArray = {1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        final ListNode linkedList = LinkedList.from(intArray);

        System.out.println(intArray.length);

        assertThat(ConvertBinaryNumberToInteger.usingSelfThought(linkedList), equalTo(18880));
        assertThat(ConvertBinaryNumberToInteger.usingBitwiseOperator(linkedList), equalTo(18880));
        assertThat(ConvertBinaryNumberToInteger.usingArithmeticOperator(linkedList), equalTo(18880));
    }

    @Test
    public void getDecimalValueFor0() {
        final ListNode linkedList = LinkedList.from(new int[]{0, 0});

        assertThat(ConvertBinaryNumberToInteger.usingSelfThought(linkedList), equalTo(0));
        assertThat(ConvertBinaryNumberToInteger.usingBitwiseOperator(linkedList), equalTo(0));
        assertThat(ConvertBinaryNumberToInteger.usingArithmeticOperator(linkedList), equalTo(0));
    }

    @Test
    public void getDecimalValueFor4() {
        final ListNode linkedList = LinkedList.from(new int[]{1, 0, 0});

        assertThat(ConvertBinaryNumberToInteger.usingSelfThought(linkedList), equalTo(4));
        assertThat(ConvertBinaryNumberToInteger.usingBitwiseOperator(linkedList), equalTo(4));
        assertThat(ConvertBinaryNumberToInteger.usingArithmeticOperator(linkedList), equalTo(4));
    }

}
