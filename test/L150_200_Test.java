
import basicDataStructure.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


}
