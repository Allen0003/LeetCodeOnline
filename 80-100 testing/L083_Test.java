
import framework.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class L083_Test {

    @Test
    public void testOneNodeCase() {
        ListNode a = new ListNode(1);

        assertEquals(new L083_E().deleteDuplicates(a).val, new ListNode(1).val);
    }


    public void testTwoNodeWithoutRepearCase() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;

        assertEquals(new L083_E().deleteDuplicates(a).val, new ListNode(1).val);
    }


}
