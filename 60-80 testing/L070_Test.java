import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class L070_Test {
    @Test
    public void testClimbStairsSimpleCase1() {
        assertEquals(new L60To80().climbStairs(2), 2);
    }

    @Test
    public void testClimbStairsSimpleCase2() {
        assertEquals(new L60To80().climbStairs(3), 3);
    }

    @Test
    public void testClimbStairsSimpleCase3() {
        assertEquals(new L60To80().climbStairs(4), 5);
    }

    @Test
    public void testClimbStairsSimpleCase4() {
        assertEquals(new L60To80().climbStairs(10), 89);
    }

    @Test
    public void testClimbStairsSimpleWithBigNumber() {
        assertEquals(new L60To80().climbStairs(45), 1836311903);
    }

    @Test
    public void testClimbStairsSimpleWithZero() {
        assertEquals(new L60To80().climbStairs(0), 1);
    }


    @Test
    public void testClimbStairsSimpleWithNegativeNumber() {
        assertEquals(new L60To80().climbStairs(-1), 1);
    }


}
