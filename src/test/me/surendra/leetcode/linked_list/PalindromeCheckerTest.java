package me.surendra.leetcode.linked_list;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class PalindromeCheckerTest {

    private boolean callMethod(final ListNode linkedListCommon) {
        return new PalindromeChecker().isPalindrome(linkedListCommon);
//        return new PalindromeChecker().isPalindromeUsingList(linkedListCommon);
//        return new PalindromeChecker().isPalindromeRecursivelyAdvanced(linkedListCommon);
    }

    @Test
    public void shouldReturnTrueForOneValue() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{RandomUtils.nextInt()});

        assertThat(callMethod(linkedListCommon), equalTo(true));
    }

    @Test
    public void shouldReturnTrueForTwoSameValues() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 1});

        assertThat(callMethod(linkedListCommon), equalTo(true));
    }

    @Test
    public void shouldReturnFalseForTwoDifferentValues() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 2});

        assertThat(callMethod(linkedListCommon), equalTo(false));
    }

    @Test
    public void shouldReturnTrueFor3Values() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 2, 1});

        assertThat(callMethod(linkedListCommon), equalTo(true));
    }

    @Test
    public void shouldReturnTrueForMultipleDifferentValues() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 2, 2, 1});

        assertThat(callMethod(linkedListCommon), equalTo(true));
    }

    @Test
    public void shouldReturnFalseForMultipleDifferentValues() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{8, 4, 5});

        assertThat(callMethod(linkedListCommon), equalTo(false));
    }

    @Test
    public void shouldReturnTrueForMultipleDifferentValues1() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 2, 3, 2, 1});

        assertThat(callMethod(linkedListCommon), equalTo(true));
    }

    @Test
    public void shouldReturnTrueForMultipleDifferentValues2() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 2, 3, 3, 2, 1});

        assertThat(callMethod(linkedListCommon), equalTo(true));
    }

}
