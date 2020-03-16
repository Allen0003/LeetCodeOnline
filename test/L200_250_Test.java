import basicDataStructure.ListNode;
import org.junit.Test;

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

}
