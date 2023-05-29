package me.surendra.leetcode.stack;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LongestAbsoluteFilePathFinderTest {

    private final LongestAbsoluteFilePathFinder longestAbsoluteFilePathFinder = new LongestAbsoluteFilePathFinder();

    private int getLongestPathUsingStack(final String input) {
        return longestAbsoluteFilePathFinder.lengthLongestPathUsingArray(input);
//        return longestAbsoluteFilePathFinder.lengthLongestPathUsingStack(input);
    }

    @Test
    public void fileNotPartOfDirectory() {
        final int operand = 13;
        // "something.png" (13)
        assertThat(getLongestPathUsingStack("dir\nsomething.png"), equalTo(operand));
        assertThat(getLongestPathUsingStack("dir\n\nsomething.png"), equalTo(operand));
        assertThat(getLongestPathUsingStack("dir\n\n\nsomething.png"), equalTo(operand));
    }

    @Test
    public void filePartOfRootDirectory() {
        final int operand = 14;
        // "/something.png" (14)
        assertThat(getLongestPathUsingStack("dir\n\n\tsomething.png"), equalTo(operand));
        assertThat(getLongestPathUsingStack("dir\n\n\n\tsomething.png"), equalTo(operand));

        assertThat(getLongestPathUsingStack("dir\n\ntest\n\n\tsomething.png"), equalTo(operand));
        assertThat(getLongestPathUsingStack("dir\n\n\ntest\n\n\n\tsomething.png"), equalTo(operand));
    }

    @Test
    public void filePartOf1stLevelDirectory() {
        final int operand = 17;
        // "dir/something.png" (17)
        assertThat(getLongestPathUsingStack("dir\n\tsomething.png"), equalTo(operand));
    }

    @Test
    public void filePartOf2ndLevelDirectory() {
        final int operand = 18;
        // "test/something.png" (18)
        assertThat(getLongestPathUsingStack("dir\ntest\n\tsomething.png"), equalTo(operand));
    }

    @Test
    public void directoryIsNotConsideredForCalculation() {
        assertThat(getLongestPathUsingStack("a"), equalTo(0));

        final int operand = 14;
        // "/something.png" (14)
        assertThat(getLongestPathUsingStack("dir\n\nagain\n\n\tsomething.png\n\tsubdir2"), equalTo(operand));
        assertThat(getLongestPathUsingStack("dir\n\n\n\tsomething.png\n\ntest"), equalTo(operand));
        assertThat(getLongestPathUsingStack("dir\n\n\n\tsomething.png\n\n\ntest"), equalTo(operand));
        assertThat(getLongestPathUsingStack("dir\n\n\n\tsomething.png\n\n\n\ntest"), equalTo(operand));

    }

    @Test
    public void leetCodeExample() {
        assertThat(
            getLongestPathUsingStack("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"),
            equalTo(20)
        );

        assertThat(
            getLongestPathUsingStack("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"),
            equalTo(32)
        );

        assertThat(
            getLongestPathUsingStack("dir\n\tsubdir1\n\t\tsubsubdir1\n\t\tfile1.ext\n\t\t\tfile2.ext"),
            equalTo(31)
        );
    }

    @Test
    public void doesNotWork() {
//        assertThat(getLongestPathUsingStack("dir\tsomething.png"), equalTo(17));
//        assertThat(getLongestPathUsingStack("dir\t\tsomething.png"), equalTo(18));
//        assertThat(getLongestPathUsingStack("dir\t\t\tsomething.png"), equalTo(19));
//        assertThat(getLongestPathUsingStack("dir\t\t\t\tsomething.png"), equalTo(20));
    }
}
