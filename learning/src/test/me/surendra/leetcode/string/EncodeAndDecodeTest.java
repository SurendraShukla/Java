package me.surendra.leetcode.string;


import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class EncodeAndDecodeTest {

    private final EncodeAndDecode encodeAndDecode = new EncodeAndDecode();

    @Test
    public void emptyString() {
        final List<String> strings = Lists.newArrayList("");

        // execute
        final String encodedString = encodeAndDecode.encode(strings);

        assertThat(encodeAndDecode.decode(encodedString), equalTo(strings));
    }

    @Test
    public void emptyStrings() {
        final List<String> strings = Lists.newArrayList("", "");

        // execute
        final String encodedString = encodeAndDecode.encode(strings);

        assertThat(encodeAndDecode.decode(encodedString), equalTo(strings));
    }

    @Test
    public void twoString() {
        final List<String> strings = Lists.newArrayList("Hello", "World");

        // execute
        final String encodedString = encodeAndDecode.encode(strings);

        assertThat(encodeAndDecode.decode(encodedString), equalTo(strings));
    }

}
