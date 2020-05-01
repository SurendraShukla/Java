package me.surendra.tdd;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class FizzBuzzReturningObjectTest {

    private void verify(final int input, final Object expected) {
        assertThat(fizzBuzz(input), equalTo(expected));
    }

    static class Fizz {
        private static final Fizz fizz = new Fizz();
    }
    static class Buzz {
        private static final Buzz buzz = new Buzz();
    }
    static class FizzBuzz {
        private static final FizzBuzz fizzBuzz = new FizzBuzz();
    }
    private Object getFizz() {
        return Fizz.fizz;
    }

    private Object getBuzz() {
        return Buzz.buzz;
    }

    private Object getFizzBuzz() {
        return FizzBuzz.fizzBuzz;
    }


    @Test
    public void shouldReturnOneFor1() {
        verify(1, Integer.valueOf(1));
    }

    @Test
    public void shouldReturnTwoFor2() {
        verify(2,   Integer.valueOf(2));
    }

    @Test
    public void shouldReturnFizzFor3() {
        verify(3, getFizz());
    }

    @Test
    public void shouldReturnBuzzFor5() {
        verify(5, getBuzz());
    }

    @Test
    public void shouldReturnFizzFor6() {
        verify(6, getFizz());
    }

    @Test
    public void shouldReturnBuzzFor10() {
        verify(10, getBuzz());
    }

    @Test
    public void shouldReturnFizzBuzzFor15() {
        verify(15, getFizzBuzz());
    }


    @Test
    public void shouldReturnFizzBuzzFor30() {
        verify(30, getFizzBuzz());
    }

    private Object fizzBuzz(final Integer i) {
        if (i % 15 == 0) {
            return getFizzBuzz();
        }
        if (i % 3 == 0) {
            return getFizz();
        }
        if (i % 5 == 0) {
            return getBuzz();
        }

        return  i;
    }
}
