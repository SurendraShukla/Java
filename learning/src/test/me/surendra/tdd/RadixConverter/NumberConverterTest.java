package me.surendra.tdd.RadixConverter;

import org.junit.Assert;
import org.junit.Test;

public class NumberConverterTest {

    @Test
    public void shouldConvertForDecimal() {
        Assert.assertEquals("10", NumberConverter.convert(10, 10));
        Assert.assertEquals("10", NumberConverter.convertRecursive(10, 10));
    }
    @Test
    public void shouldConvertForBinary() {
        Assert.assertEquals("100", NumberConverter.convert(4, 2));
        Assert.assertEquals("100", NumberConverter.convertRecursive(4, 2));
    }
    @Test
    public void shouldConvertForOctal() {
        Assert.assertEquals("10", NumberConverter.convert(8, 8));
        Assert.assertEquals("10", NumberConverter.convertRecursive(8, 8));
    }
    @Test
    public void shouldConvertForHexaDecimal() {
        Assert.assertEquals("3A", NumberConverter.convert(58, 16));
        Assert.assertEquals("3A", NumberConverter.convertRecursive(58, 16));
    }
    @Test
    public void shouldConvertForAnyGivenBase() {
        Assert.assertEquals("B73", NumberConverter.convert(4543, 20));
        Assert.assertEquals("B73", NumberConverter.convertRecursive(4543, 20));
    }
}
