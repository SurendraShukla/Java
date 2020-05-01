package me.surendra.tdd;

import org.junit.Test;

import static me.surendra.tdd.RomanToArabic.RomanToArabicEnum.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class RomanToArabic {

    @Test
    public void shouldReturn0ForEmpty() {
        assertThat(converter(""), equalTo(0));
    }

    @Test
    public void shouldReturnIFor1() {
        assertThat(converter("I"), equalTo(1));
    }

    @Test
    public void shouldReturnIIFor2() {
        assertThat(converter("II"), equalTo(2));
    }

    @Test
    public void shouldReturnIIIFor3() {
        assertThat(converter("III"), equalTo(3));
    }

    @Test
    public void shouldReturnIVFor4() {
        assertThat(converter("IV"), equalTo(4));
    }


    private int converter(String s) {
        int result =0;

        RomanToArabicEnum symbol1;
        int symbolVal1;

        symbol1 = IV;
        symbolVal1 = symbol1.getVal();
        while (s.startsWith(symbol1.name())) {
            result+= symbolVal1;
            s = s.substring(symbol1.name().length());
        }

        symbol1 = I;
        symbolVal1 = symbol1.getVal();
        while(s.startsWith(symbol1.name())) {
            result+= symbolVal1;
            s = s.substring(symbol1.name().length());
        }
        return result;
    }

    enum RomanToArabicEnum{
        I(1),
        IV(4);

        private int val;

        RomanToArabicEnum(final int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }


}
