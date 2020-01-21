import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class L067_Test {

    @Test
    public void testAddTwoSimpleCase1() {
        assertEquals(new L60To80().addBinary("11", "1"), "100");
    }

    @Test
    public void testAddTwoSimpleCase2() {
        assertEquals(new L60To80().addBinary("1010", "1011"), "10101");
    }

    @Test
    public void testOneEmptyCase() {
        assertEquals(new L60To80().addBinary("", "1011"), "1011");
    }

    @Test
    public void testZerosEmptyCase() {
        assertEquals(new L60To80().addBinary("00000000000000000000000", "1011"), "1011");
    }

    @Test
    public void testOnesEmptyCase() {
        assertEquals(new L60To80().addBinary("11111111111111111111111111", "11111111111111111111111111"), "111111111111111111111111110");
    }


}
