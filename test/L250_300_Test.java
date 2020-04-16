
import basicDataStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

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
        assertEquals(forTest.isUgly(14), false);
    }

    @Test
    public void testAddDigitsCase1() {
        assertEquals(forTest.addDigits(38), 2);
    }

    @Test
    public void testAddDigitsCase2() {
        assertEquals(forTest.addDigits(47), 2);
    }

    @Test
    public void testBinaryTreePathsCase1() {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.right = e;

        ArrayList<String> result = new ArrayList();
        result.add("1->2->5");
        result.add("1->3");

        assertEquals(forTest.binaryTreePaths(a), result);
    }

    @Test
    public void testLengthOfLISCase1() {
        assertEquals(forTest.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}), 4);
    }

    @Test
    public void testLengthOfLISCase2() {
        assertEquals(forTest.lengthOfLIS(new int[]{10, 15, 2}), 2);
    }


    @Test
    public void testLongestCommonPrefixCase1() {
        assertEquals(forTest.longestCommonPrefix(new String[]{"flower", "flow", "flight"}), "fl");
    }

    @Test
    public void testLongestCommonPrefixCase2() {
        assertEquals(forTest.longestCommonPrefix(new String[]{"", "flow", "flight"}), "");
    }


    @Test
    public void testNumSquaresCase1() {
        assertEquals(forTest.numSquares(12), 3);
    }

    @Test
    public void testNumSquaresCase2() {
        assertEquals(forTest.numSquares(13), 2);
    }


    @Test
    public void testNumSquaresCase3() {
        assertEquals(forTest.numSquares(8), 2);
    }


}
