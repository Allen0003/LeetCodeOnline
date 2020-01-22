import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class L075_Test {
    @Test
    public void testSortColorsCase1() {
        int[] a = new int[]{2, 0, 2, 1, 1, 0};
        new L60To80().sortColors(a);

        assertTrue(Arrays.equals(a, new int[]{0, 0, 1, 1, 2, 2}));
    }

    @Test
    public void testSortColorsCase2() {
        int[] a = new int[]{2, 0, 2, 1, 1, 0, 0, 0, 0};
        new L60To80().sortColors(a);

        assertTrue(Arrays.equals(a, new int[]{0, 0, 0, 0, 0, 1, 1, 2, 2}));
    }

    @Test
    public void testSortColorsCase3() {
        int[] a = new int[]{};
        new L60To80().sortColors(a);

        assertTrue(Arrays.equals(a, new int[]{}));
    }

}
