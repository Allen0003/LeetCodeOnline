package amzaon;


import amazon.AmazonTest;
import basicDataStructure.ListNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestAmazon {

    @Test
    public void testMinPathSumCase1() {
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        result.add(-1);
        result.add(0);
        result.add(1);
        results.add(result);

        result = new LinkedList<>();
        result.add(-1);
        result.add(-1);
        result.add(2);
        results.add(result);

        assertEquals(new AmazonTest().threeSum(new int[]{-1, 0, 1, 2, -1, -4}), results);
    }


    @Test
    public void testAddTwoNumbersCase1() {
//        (2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode ListNode1 = new ListNode(2);
        ListNode ListNode2 = new ListNode(4);
        ListNode ListNode3 = new ListNode(3);

        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;

        ListNode ListNode4 = new ListNode(5);
        ListNode ListNode5 = new ListNode(6);
        ListNode ListNode6 = new ListNode(7);

        ListNode4.next = ListNode5;
        ListNode5.next = ListNode6;


//        7 -> 0 -> 8

        ListNode ListNode7 = new ListNode(7);
        ListNode ListNode8 = new ListNode(0);
        ListNode ListNode9 = new ListNode(8);

        ListNode7.next = ListNode8;
        ListNode8.next = ListNode9;

        assertEquals(new AmazonTest().addTwoNumbers(ListNode1, ListNode4), ListNode7);
    }

}
