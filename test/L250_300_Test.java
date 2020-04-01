
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class L250_300_Test {

    L250To300 forTest = new L250To300();

    @Test
    public void testGetCase1() {
        assertEquals(forTest.getHint("1807", "7810"), "1A3B");
    }

    @Test
    public void testGetCase2() {
        assertEquals(forTest.getHint("1123", "0111"), "1A1B");
    }

    @Test
    public void testGetCase3() {
        assertEquals(forTest.getHint("1122", "1222"), "3A0B");
    }


    @Test
    public void testCanWinNimCase2() {
        assertEquals(forTest.canWinNim(5), true);
    }

    @Test
    public void testMissingNumberCase1() {
        assertEquals(forTest.missingNumber(new int[]{3, 0, 1}), 2);
    }

    @Test
    public void testMissingNumberCase2() {
        assertEquals(forTest.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}), 8);
    }

    @Test
    public void testMissingNumberCase3() {
        assertEquals(forTest.missingNumber(new int[]{9, 6, 4, 2, 3, 7, 0, 1, 8, 10, 11, 12, 13}), 5);
    }

    @Test
    public void testIsUglyCase1() {
        assertEquals(forTest.isUgly(6), true);
    }

    @Test
    public void testIsUglyCase2() {
        assertEquals(forTest.isUgly(8), true);
    }

    @Test
    public void testIsUglyCase3() {
        assertEquals(forTest.isUgly(14), false );
    }

}
