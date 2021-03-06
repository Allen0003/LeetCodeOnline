import basicDataStructure.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class L150_200_Test {

    L150To200 minStack = new L150To200();

    @Test
    public void testMinStackCase1() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(minStack.getMin(), -3);
    }

    @Test
    public void testMinStackCase2() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        assertEquals(minStack.top(), 0);
    }

    @Test
    public void testMinStackCase3() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        assertEquals(minStack.getMin(), -2);
    }

    @Test
    public void testIntersectionNodeCase1() {
        //[4,1,8,4,5]
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(8);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        listNode4.next = listNode5;

        //[5,0,1,8,4,5]
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(0);
        ListNode listNode8 = new ListNode(1);

        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode3;

        assertEquals(minStack.getIntersectionNode(listNode1, listNode6), listNode3);
    }


    @Test
    public void testIntersectionNodeCase2() {
        //[2,6,4]
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        //[1,5]
        ListNode listNode6 = new ListNode(1);
        ListNode listNode7 = new ListNode(5);

        listNode6.next = listNode7;
        assertEquals(minStack.getIntersectionNode(listNode1, listNode6), null);
    }

    @Test
    public void testConvertToTitleCase1() {
        assertEquals(minStack.convertToTitle(1), "A");
    }

    @Test
    public void testConvertToTitleCase2() {
        assertEquals(minStack.convertToTitle(28), "AB");
    }

    @Test
    public void testConvertToTitleCase3() {
        assertEquals(minStack.convertToTitle(701), "ZY");
    }

    @Test
    public void testConvertToTitleCase6() {
        assertEquals(minStack.convertToTitle(702), "ZZ");
    }

    @Test
    public void testConvertToTitleCase4() {
        assertEquals(minStack.convertToTitle(52), "AZ");
    }

    @Test
    public void testConvertToTitleCase5() {
        assertEquals(minStack.convertToTitle(26), "Z");
    }

    @Test
    public void testTitleToNumberCase1() {
        assertEquals(minStack.titleToNumber("A"), 1);
    }

    @Test
    public void testTitleToNumberCase2() {
        assertEquals(minStack.titleToNumber("AB"), 28);
    }

    @Test
    public void testTitleToNumberCase3() {
        assertEquals(minStack.titleToNumber("AZ"), 52);
    }

    @Test
    public void testTitleToNumberCase4() {
        assertEquals(minStack.titleToNumber("ZY"), 701);
    }

    @Test
    public void testTitleToNumberCase5() {
        assertEquals(minStack.titleToNumber("AAA"), 703);
    }

    @Test
    public void testTrailingZeroesCase1() {
        assertEquals(minStack.trailingZeroes(3), 0);
    }

    @Test
    public void testTrailingZeroesCase2() {
        assertEquals(minStack.trailingZeroes(5), 1);
    }

    @Test
    public void testTrailingZeroesCase3() {
        assertEquals(minStack.trailingZeroes(10), 2);
    }

    @Test
    public void testTrailingZeroesCase4() {
        assertEquals(minStack.trailingZeroes(30), 7);
    }

    @Test
    public void testTrailingZeroesCase5() {
        assertEquals(minStack.trailingZeroes(200), 49);
    }

    @Test
    public void testTrailingZeroesCase6() {
        assertEquals(minStack.trailingZeroes(130), 32);
    }

    @Test
    public void testTrailingZeroesCase7() {
        assertEquals(minStack.trailingZeroes(1808548329), 452137076);
    }

    @Test
    public void testRobCase1() {
        assertEquals(minStack.rob(new int[]{1, 2, 3, 1}), 4);
    }

    @Test
    public void testRobCase2() {
        assertEquals(minStack.rob(new int[]{2, 7, 9, 3, 1}), 12);
    }

    @Test
    public void testRobCase3() {
        assertEquals(minStack.rob(new int[]{1, 3, 5, 4}), 7);
    }

    @Test
    public void testRobCase4() {
        assertEquals(minStack.rob(new int[]{9, 1, 1, 9}), 18);
    }

    @Test
    public void testHammingWeightCase1() {
        assertEquals(minStack.hammingWeight(11), 3);
    }

    @Test
    public void testHammingWeightCase2() {
        assertEquals(minStack.hammingWeight(128), 1);
    }


    @Test
    public void testNumIslands1() {
        char[][] input = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        assertEquals(minStack.numIslands(input), 1);
    }

    @Test
    public void testNumIslands2() {
        char[][] input = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '0', '1'},
        };
        assertEquals(minStack.numIslands(input), 3);
    }

    @Test
    public void testNumIslands3() {
        char[][] input = {
                {'0', '1', '0'},
                {'1', '1', '0'}
        };
        assertEquals(minStack.numIslands(input), 1);
    }

    @Test
    public void testNumIslands4() {
        char[][] input = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'},
        };
        assertEquals(minStack.numIslands(input), 1);
    }


    @Test
    public void testLargestNumber1() {
        assertEquals(minStack.largestNumber(new int[]{2, 10}), "210");
    }

    @Test
    public void testLargestNumber2() {
        assertEquals(minStack.largestNumber(new int[]{30, 34, 5, 9, 3}), "9534330");
    }


    @Test
    public void testLargestNumber3() {
        assertEquals(minStack.largestNumber(new int[]{0, 0, 0}), "0");
    }

    @Test
    public void testLargestNumber4() {
        assertEquals(minStack.largestNumber(new int[]{50, 3, 9}), "9503");
    }


    @Test
    public void testReverseWords1() {
        assertEquals(minStack.reverseWords("the sky is blue"), "blue is sky the");
    }


    @Test
    public void testReverseWords2() {
        assertEquals(minStack.reverseWords("  hello world!  "), "world! hello");
    }


    @Test
    public void testReverseWords3() {
        assertEquals(minStack.reverseWords("a good   example"), "example good a");
    }

    @Test
    public void testMaxProduct1() {
        assertEquals(minStack.maxProduct(new int[]{2, 3, -2, 4}), 6);
    }

    @Test
    public void testMaxProduct2() {
        assertEquals(minStack.maxProduct(new int[]{-2, 0, -1}), 0);
    }

    @Test
    public void testMaxProduct3() {
        assertEquals(minStack.maxProduct(new int[]{-25, 10, -1, 66, 5, -9}), 82500);
    }

    @Test
    public void testMaxProduct4() {
        assertEquals(minStack.maxProduct(new int[]{0, -1, 4, -4, 5, -2, -1, -1, -2, -3, 0, -3, 0, 1, -1, -4, 4, 6, 2, 3, 0, -5, 2, 1, -4, -2, -1, 3, -4, -6, 0, 2, 2, -1, -5, 1, 1, 5, -6, 2, 1, -3, -6, -6, -3, 4, 0, -2, 0, 2}), 388800);
    }

    @Test
    public void testMaxProduct5() {
        assertEquals(minStack.maxProduct(new int[]{-4, -3}), 12);
    }

    @Test
    public void testMaxProduct6() {
        assertEquals(minStack.maxProduct(new int[]{0, -2}), 0);
    }

    @Test
    public void testMaxProduct7() {
        assertEquals(minStack.maxProduct(new int[]{3, -1, 4}), 4);
    }

    @Test
    public void testMaxProduct8() {
        assertEquals(minStack.maxProduct(new int[]{-2, 3, -4}), 24);
    }

    @Test
    public void testFindPeakElement1() {
        assertEquals(minStack.findPeakElement(new int[]{1, 2, 3, 1}), 2);
    }

    @Test
    public void testFindPeakElement2() {
        assertEquals(minStack.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}), 1);
    }


}
