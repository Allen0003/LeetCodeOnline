import basicDataStructure.ListNode;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class L200_250_Test {

    L200To250 forTest = new L200To250();

    @Test
    public void testRemoveElements1() {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;

        assertEquals(forTest.removeElements(a, 2), a);
    }


    @Test
    public void testRemoveElements2() {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        assertEquals(forTest.removeElements(a, 6), a);
    }

    @Test
    public void testRemoveElementsStartWithTarget() {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        assertEquals(forTest.removeElements(a, 1), c);
    }


    @Test
    public void testRemoveElementsStartAndEndWithTarget() {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;

        assertEquals(forTest.removeElements(a, 1), b);
    }


    @Test
    public void testRemoveElementsWithAllTargets() {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;

        assertEquals(forTest.removeElements(a, 1), null);
    }

    @Test
    public void testCountPrimesCase1() {
        assertEquals(forTest.countPrimes(10), 4);
    }

    @Test
    public void testCountPrimesCase2() {
        assertEquals(forTest.countPrimes(15), 6);
    }

    @Test
    public void testCountPrimesWithSamllNumber() {
        assertEquals(forTest.countPrimes(3), 1);
    }

    @Test
    public void testCountPrimesWithSamllNumberCase2() {
        assertEquals(forTest.countPrimes(2), 0);
    }

    @Test
    public void testContainsDuplicateCase1() {
        assertEquals(forTest.containsDuplicate(new int[]{1, 2, 3, 1}), true);
    }

    @Test
    public void testContainsDuplicateCase2() {
        assertEquals(forTest.containsDuplicate(new int[]{1, 2, 3, 4}), false);
    }

    @Test
    public void testContainsDuplicateCase3() {
        assertEquals(forTest.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}), true);
    }

    @Test
    public void testIsPowerOfTwoCase1() {
        assertEquals(forTest.isPowerOfTwo(1), true);
    }

    @Test
    public void testIsPowerOfTwoCase2() {
        assertEquals(forTest.isPowerOfTwo(16), true);
    }

    @Test
    public void testIsPowerOfTwoCase3() {
        assertEquals(forTest.isPowerOfTwo(218), false);
    }

    @Test
    public void testIsPalindromeCase1() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;

        assertEquals(forTest.isPalindrome(a), true);
    }

    @Test
    public void testIsPalindromeCase2() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;

        assertEquals(forTest.isPalindrome(a), false);
    }

    @Test
    public void testIsPalindromeCase3() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        assertEquals(forTest.isPalindrome(a), true);
    }


    @Test
    public void testSearchMatrixCase1() {
        assertEquals(forTest.searchMatrix(
                new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}}, 5), true);
    }

    @Test
    public void testSearchMatrixCase2() {
        assertEquals(forTest.searchMatrix(
                new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}}, 20), false);
    }


    @Test
    public void testMajorityElementCase1() {
        ArrayList<Integer> str = new ArrayList();
        str.add(3);
        assertEquals(forTest.majorityElement(new int[]{3, 2, 3}), str);
    }

    @Test
    public void testMajorityElementCase2() {
        ArrayList<Integer> str = new ArrayList();
        str.add(1);
        str.add(2);
        assertEquals(forTest.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}), str);
    }


    @Test
    public void testSummaryRangesCase1() {
        ArrayList<String> str = new ArrayList();
        str.add("0->2");
        str.add("4->5");
        str.add("7");
        assertEquals(forTest.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}), str);
    }

    @Test
    public void testSummaryRangesCase2() {
        ArrayList<String> str = new ArrayList();
        str.add("0");
        str.add("2->4");
        str.add("6");
        str.add("8->9");
        assertEquals(forTest.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}), str);
    }

}



