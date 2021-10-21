package me.surendra.leetcode.string;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class PhoneNumberReFormatterTest {

    private String callMethod(final String number) {
        return new PhoneNumberReFormatter().reformatNumberUsingString(number);
//        return new PhoneNumberReFormatter().reformatNumberUsingCharacterQueue(number);
    }

    @Test
    public void stringLessThan4Characters() {
        assertThat(callMethod("1"), equalTo("1"));
        assertThat(callMethod("12"), equalTo("12"));
        assertThat(callMethod("123"), equalTo("123"));
    }

    @Test
    public void stringInBetween4And7Characters() {
        assertThat(callMethod("1234"), equalTo("12-34"));
        assertThat(callMethod("12345"), equalTo("123-45"));
        assertThat(callMethod("123456"), equalTo("123-456"));
        assertThat(callMethod("1234567"), equalTo("123-45-67"));
    }

    @Test
    public void stringIMoreThan7Characters() {
        assertThat(callMethod("12345678"), equalTo("123-456-78"));
        assertThat(callMethod("123456789"), equalTo("123-456-789"));
        assertThat(callMethod("1234567891"), equalTo("123-456-78-91"));
        assertThat(callMethod("123 4-5678"), equalTo("123-456-78"));
        assertThat(callMethod("--17-5 229 35-39475 "), equalTo("175-229-353-94-75"));
    }

}
