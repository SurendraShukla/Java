package suren.coding_dojo.RadixConverter;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class RadixConverterTest {

    public static class DecimalTest {
        final int BASE_DECIMAL = 10;

        @Test
        public void conversionToBase10ShouldResultInTheSameNumber() {
            assertEquals("0", convert(0, BASE_DECIMAL));
            assertEquals("1", convert(1, BASE_DECIMAL));
            assertEquals("10", convert(10, BASE_DECIMAL));
        }
    }

    public static class BinaryTest {
        final int BASE_BINARY = 2;

        @Test
        public void zeroAndOneShouldBeConvertedAsItIs() {
            assertEquals("0", convert(0, BASE_BINARY));
            assertEquals("1", convert(1, BASE_BINARY));
        }

        @Test
        public void converting3ShouldGive11() {
            assertEquals("10", convert(2, BASE_BINARY));
            assertEquals("11", convert(3, BASE_BINARY));
            assertEquals("100", convert(4, BASE_BINARY));
            assertEquals("101", convert(5, BASE_BINARY));
            assertEquals("110", convert(6, BASE_BINARY));
        }
    }

    public static class HexTest {
        final int BASE_HEX = 16;

        @Test
        public void numberShouldBeUnchanged() {
            assertEquals("9", convert(9, BASE_HEX));
        }

        @Test
        public void numberMoreThan9AndLessThan16ShouldBeChangedToAlphabets() {
            assertEquals("A", convert(10, BASE_HEX));
            assertEquals("F", convert(15, BASE_HEX));
        }
    }

    static String convert(int number, int base) {
        if (number > 9 && number < base) return "" + (char) ('A' + (number - 10));
        return ((number >= base) ? convert(number / base, base) : "") + number % base;
    }

}
