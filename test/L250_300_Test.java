
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
    public void testCanWinNimCase1() {
        assertEquals(forTest.canWinNim(4), false);
    }

    @Test
    public void testCanWinNimCase2() {
        assertEquals(forTest.canWinNim(5), true);
    }

}
