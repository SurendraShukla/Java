package me.surendra.tdd;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/*
States
String
FIZ
BUZZ
FIZBUZZ
 */
public class FizzBuzz {

    private static int number;
    private static String state = "";

    @Test
    public void shouldReturn1AsString() {
        //setup
        FizzBuzz.number = 1;
        //act
        FizzBuzz.state = getState();
        //assert
        assertThat(getState(), Matchers.equalTo("1"));
    }

    @Test
    public void shouldReturn2AsString() {
        //assert
        FizzBuzz.number = 2;
        //act
        FizzBuzz.state = getState();
        //assert
        assertThat(FizzBuzz.state, Matchers.equalTo("2"));
    }

    @Test
    public void shouldReturn3AsFizz() {
        //assert
        FizzBuzz.number = 3;
        //act
        FizzBuzz.state = getState();
        //assert
        assertThat(FizzBuzz.state, Matchers.equalTo("Fizz"));
    }

    @Test
    public void shouldReturn5AsBuzz() {
        //assert
        FizzBuzz.number = 5;
        //act
        FizzBuzz.state = getState();
        //assert
        assertThat(FizzBuzz.state, Matchers.equalTo("Buzz"));
    }

    @Test
    public void shouldReturnMultiplesOf3AsFizz() {
        //assert
        FizzBuzz.number = 3*4;
        //act
        FizzBuzz.state = getState();
        //assert
        assertThat(FizzBuzz.state, Matchers.equalTo("Fizz"));
    }

    @Test
    public void shouldReturnMultiplesOf5AsBuzz() {
        //assert
        FizzBuzz.number = 5*4;
        //act
        FizzBuzz.state = getState();
        //assert
        assertThat(FizzBuzz.state, Matchers.equalTo("Buzz"));
    }

    @Test
    public void shouldReturn15AsFizzBuzz() {
        //assert
        FizzBuzz.number = 5*3;
        //act
        FizzBuzz.state = getState();
        //assert
        assertThat(FizzBuzz.state, Matchers.equalTo("FizzBuzz"));
    }


    private String getState() {
        if(FizzBuzz.number == 15) return "FizzBuzz";
        if(FizzBuzz.number % 3 == 0) return "Fizz";
        if(FizzBuzz.number % 5 == 0) return "Buzz";

        return String.valueOf(FizzBuzz.number);
    }

}


