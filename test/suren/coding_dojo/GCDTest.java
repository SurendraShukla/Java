package suren.coding_dojo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GCDTest {
    @Test
    public void gcdShouldBeOneFor1and1() {
        assertEquals(1, gcd(1, 1));
    }

    @Test
    public void testGCD() {
        assertEquals(4, gcd(8, 12));
        assertEquals(4, gcd(8, 12));
        assertEquals(6, gcd(18, 84));
        assertEquals(6, gcd(48, 18));
        assertEquals(12, gcd(48, 180));
        assertEquals(1, gcd(9, 28));
    }

    private int gcd(int a, int b) {
        return (a % b == 0) ? b : gcd(b, a % b);
    }
}
