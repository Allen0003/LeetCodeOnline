
import org.junit.Test;
import basicDataStructure.TreeNode;

import static org.junit.Assert.assertEquals;

public class L101_Test {

    @Test
    public void testASymmetricTree() {

//[1,2,2,3,4,4,3]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);

        // node 1
        node1.left = node2;
        node1.right = node3;

        // node 2
        node2.left = node4;
        node2.right = node5;

        // node 3
        node3.left = node6;
        node3.right = node7;

        assertEquals(new L100To150().isSymmetric(node1), true);
    }

    @Test
    public void testASymmetricTreeCase2() {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(3);

        // node 1
        node1.left = node2;
        node1.right = node3;

        // node 2
//        node2.left = node4;
        node2.right = node5;

        // node 3
        node3.left = node6;
//        node3.right = node7;

        assertEquals(new L100To150().isSymmetric(node1), true);
    }


    @Test
    public void testANotSymmetricTree() {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(null);
        TreeNode node5 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(3);

        // node 1
        node1.left = node2;
        node1.right = node3;

        // node 2
//        node2.left = node4;
        node2.right = node5;

        // node 3
//        node3.left = node6;
        node3.right = node7;

        assertEquals(new L100To150().isSymmetric(node1), false);
    }


    @Test
    public void testANotSymmetricTreeCase2() {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(3);

        // node 1
        node1.left = node2;
        node1.right = node3;

        // node 2
        node2.left = node4;
        node2.right = node5;

        // node 3
        node3.left = node6;
        node3.right = node7;

        assertEquals(new L100To150().isSymmetric(node1), false);
    }

}
