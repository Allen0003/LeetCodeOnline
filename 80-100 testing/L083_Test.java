
import basicDataStructure.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class L083_Test {

    @Test
    public void testOneNodeCase() {
        ListNode a = new ListNode(1);
        assertEquals(new L083_E().deleteDuplicates(a).val, new ListNode(1).val);
    }

    @Test
    public void testTwoNodesWithoutRepearCaseFirstValue() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        assertEquals(new L083_E().deleteDuplicates(a).val, a.val);
    }

    @Test
    public void testTwoNodesWithoutRepearCaseSecondValue() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        assertEquals(new L083_E().deleteDuplicates(a).next.val, b.val);
    }


    @Test
    public void testThreeNodesWithOneRepearCaseFirstValue() {

        ListNode a = this.produceThreeNodesWithOneRepearCase();
        assertEquals(new L083_E().deleteDuplicates(a).val, a.val);
    }

    @Test
    public void testThreeNodesWithOneRepearCaseSecondValue() {
        ListNode a = this.produceThreeNodesWithOneRepearCase();
        assertEquals(new L083_E().deleteDuplicates(a).next.val, 2);
    }

    @Test
    public void testThreeNodesWithOneRepearCaseThirdValue() {
        ListNode a = this.produceThreeNodesWithOneRepearCase();
        assertEquals(new L083_E().deleteDuplicates(a).next.next, null);
    }


    public ListNode produceThreeNodesWithOneRepearCase() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        a.next = b;
        b.next = c;
        return a;
    }

    @Test
    public void testNodesWithSeveralDifferentRepearsCaseSecondValue() {
        ListNode a = this.produceNodesWithSeveralDifferentRepearsCase();
        assertEquals(new L083_E().deleteDuplicates(a).next.val, 2);
    }

    @Test
    public void testNodesWithSeveralDifferentRepearsCaseThirdValue() {
        ListNode a = this.produceNodesWithSeveralDifferentRepearsCase();
        assertEquals(new L083_E().deleteDuplicates(a).next.next, null);
    }


    public ListNode produceNodesWithSeveralDifferentRepearsCase() {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(2);
        ListNode c = new ListNode(2);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = b;
        b.next = b1;
        b1.next = b2;
        b2.next = c;
        return a;
    }


}
