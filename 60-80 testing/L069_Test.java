import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class L069_Test {

    @Test
    public void testMySqrtCase1() {
        assertEquals(new L60To80().mySqrt( 4), 2);
    }

    @Test
    public void testMySqrtCase2() {
        assertEquals(new L60To80().mySqrt( 8), 2);
    }

    @Test
    public void testMySqrtCase3() {
        assertEquals(new L60To80().mySqrt( 9), 3);
    }

}
