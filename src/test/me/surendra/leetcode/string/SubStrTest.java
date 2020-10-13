package me.surendra.leetcode.string;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SubStrTest {

    @Test
    public void needlePresentInHaystack() {
        assertThat(SubStr.strStr("hello", "ll"), equalTo(2));
    }

    @Test
    public void needleNotPresentInHaystack() {
        assertThat(SubStr.strStr("aaaaa", "bba"), equalTo(-1));
    }

    @Test
    public void haystackAndNeedleBothAreEmpty() {
        assertThat(SubStr.strStr("", ""), equalTo(0));
    }

    @Test
    public void needlePresentAtLastInHaystack() {
        assertThat(SubStr.strStr("abc", "c"), equalTo(2));
    }

    @Test
    public void haystackIsSmallerThanNeedleString() {
        assertThat(SubStr.strStr("a", "aa"), equalTo(-1));
        assertThat(SubStr.strStr("", "a"), equalTo(-1));
    }


}
