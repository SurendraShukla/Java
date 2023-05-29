package me.surendra.leetcode.regex;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BasicParserTest {

    @Test
    public void stringDoesNotMatchPatternWhichIsWithoutWildCharacters() {
        assertThat(BasicParser.isMatch("aa", "a"), equalTo(false));
        assertThat(BasicParser.isMatch("a", "aa"), equalTo(false));
        assertThat(BasicParser.isMatch("a", "b"), equalTo(false));
    }

    @Test
    public void stringMatchesPatternWhichIsWithoutWildCharacters() {
        assertThat(BasicParser.isMatch("aa", "aa"), equalTo(true));
        assertThat(BasicParser.isMatch("bb", "bb"), equalTo(true));
    }

    @Test
    public void stringDoesNotMatchPatternWithDotWildChar() {
        assertThat(BasicParser.isMatch("a", "a."), equalTo(false));
        assertThat(BasicParser.isMatch("abc", "a."), equalTo(false));
        assertThat(BasicParser.isMatch("add", "a.c"), equalTo(false));
    }

    @Test
    public void stringMatchesPatternWithDotWildChar() {
        assertThat(BasicParser.isMatch("ab", "a."), equalTo(true));
        assertThat(BasicParser.isMatch("abc", "a.c"), equalTo(true));
        assertThat(BasicParser.isMatch("adc", "a.c"), equalTo(true));
    }

    @Test
    public void stringDoesNotMatchPatternWithStarWildChar() {
        assertThat(BasicParser.isMatch("ac", "a*b"), equalTo(false));
    }

    @Test
    public void stringMatchesPatternWithStarWildChar() {
        assertThat(BasicParser.isMatch("ab", "a*b"), equalTo(true));
        assertThat(BasicParser.isMatch("abbb", "ab*"), equalTo(true));
    }

    @Test
    public void stringMatchesPatternWithBothWildCharacters() {
        assertThat(BasicParser.isMatch("acd", "ab*c."), equalTo(true));
    }


}
