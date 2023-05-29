package me.surendra.tdd;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class BankOCRTest {

    final char PIPE = '|';

    @Test
    public void should() {
        final char[][] expectedArray = new char[3][3];
        expectedArray[1][2] = PIPE;
        expectedArray[2][2] = PIPE;
        System.out.println(expectedArray);

        printArray(expectedArray);
        Assert.assertThat(getBankOCRForNumber(1), Matchers.equalTo(expectedArray));
    }

    private char[][] getBankOCRForNumber(final int i) {
        final char[][] bankOCR = new char[3][3];
        bankOCR[1][2] = PIPE;
        bankOCR[2][2] = PIPE;
        return bankOCR;
    }

    private void printArray(final char[][] expectedArray) {
        for (int row = 0; row < expectedArray.length; row++) {
            for (int col = 0; col < expectedArray[row].length; col++) {
                char c = expectedArray[row][col];
                char printChar;
                printChar= (c == '_') ? c : ' ';
                System.out.print(printChar + "\t");
            }
            System.out.println(' ');
        }
    }

}
