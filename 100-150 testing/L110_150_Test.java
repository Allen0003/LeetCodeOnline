import basicDataStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class L110_150_Test {


    Integer[] dimonstion1 = {1};
    Integer[] dimonstion2 = {1, 1};
    Integer[] dimonstion3 = {1, 2, 1};
    Integer[] dimonstion4 = {1, 3, 3, 1};
    Integer[] dimonstion5 = {1, 4, 6, 4, 1};
    Integer[] dimonstion30 = {1, 30, 435, 4060, 27405, 142506, 593775, 2035800, 5852925, 14307150, 30045015, 54627300, 86493225, 119759850, 145422675, 155117520, 145422675, 119759850, 86493225, 54627300, 30045015, 14307150, 5852925, 2035800, 593775, 142506, 27405, 4060, 435, 30, 1};

    @Test
    public void testGenerateCase1() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(dimonstion1).collect(Collectors.toList()));
        assertEquals(new L100To150().generate(1), list);
    }

    @Test
    public void testGetRowCase1() {
        assertEquals(new L100To150().getRow(0), Arrays.stream(dimonstion1).collect(Collectors.toList()));
    }

    @Test
    public void testGenerateCase2() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(dimonstion1).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion2).collect(Collectors.toList()));
        assertEquals(new L100To150().generate(2), list);
    }

    @Test
    public void testGetRowCase2() {
        assertEquals(new L100To150().getRow(1), Arrays.stream(dimonstion2).collect(Collectors.toList()));
    }

    @Test
    public void testGenerateCase3() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(dimonstion1).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion2).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion3).collect(Collectors.toList()));
        assertEquals(new L100To150().generate(3), list);
    }


    @Test
    public void testGetRowCase3() {
        assertEquals(new L100To150().getRow(2), Arrays.stream(dimonstion3).collect(Collectors.toList()));
    }

    @Test
    public void testGenerateCase4() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(dimonstion1).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion2).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion3).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion4).collect(Collectors.toList()));
        assertEquals(new L100To150().generate(4), list);
    }

    @Test
    public void testGetRowCase4() {
        assertEquals(new L100To150().getRow(3), Arrays.stream(dimonstion4).collect(Collectors.toList()));
    }


    @Test
    public void testGetRowCase5() {
        assertEquals(new L100To150().getRow(4), Arrays.stream(dimonstion5).collect(Collectors.toList()));
    }

    @Test
    public void testGetRowCase30() {
        assertEquals(new L100To150().getRow(30), Arrays.stream(dimonstion30).collect(Collectors.toList()));
    }


    @Test
    public void testHasPathSumCase1() {

//       [5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
//        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(2);
//        TreeNode node10 = new TreeNode();
//        TreeNode node11 = new TreeNode();
//        TreeNode node12 = new TreeNode();
//        TreeNode node13 = new TreeNode();
//        TreeNode node14 = new TreeNode();
        TreeNode node15 = new TreeNode(1);


        // node 1
        node1.left = node2;
        node1.right = node3;

        // node 2
        node2.left = node4;
//        node2.right = node5;

        // node 3
        node3.left = node6;
        node3.right = node7;

        // node 4
        node4.left = node8;
        node4.right = node9;

        // node 5
//        node5.left = node10;
//        node5.right = node11;

        // node 6
//        node6.left = node12;
//        node6.right = node13;

        // node 7
//        node7.left = node14;
        node7.right = node15;

        assertEquals(new L100To150().hasPathSum(node1, 26), true);
    }

    @Test
    public void testHasPathSumCase2() {

//       [5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
//        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(2);
//        TreeNode node10 = new TreeNode();
//        TreeNode node11 = new TreeNode();
//        TreeNode node12 = new TreeNode();
//        TreeNode node13 = new TreeNode();
//        TreeNode node14 = new TreeNode();
        TreeNode node15 = new TreeNode(1);


        // node 1
        node1.left = node2;
        node1.right = node3;

        // node 2
        node2.left = node4;
//        node2.right = node5;

        // node 3
        node3.left = node6;
        node3.right = node7;

        // node 4
        node4.left = node8;
        node4.right = node9;

        // node 5
//        node5.left = node10;
//        node5.right = node11;

        // node 6
//        node6.left = node12;
//        node6.right = node13;

        // node 7
//        node7.left = node14;
        node7.right = node15;

        assertEquals(new L100To150().hasPathSum(node1, 22), true);
    }

    @Test
    public void testHasPathSumCase3() {
        assertEquals(new L100To150().hasPathSum(null, 0), false);
    }


    @Test
    public void testHasPathSumCase4() {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        node1.left = node2;

        assertEquals(new L100To150().hasPathSum(node1, 1), false);
    }

    @Test
    public void testHasPathSumCase5() {

//       [1,-2,-3,1,3,-2,null,-1]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(-2);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(-2);
//        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(-1);


        // node 1
        node1.left = node2;
        node1.right = node3;

        // node 2
        node2.left = node4;
        node2.right = node5;

        // node 3
        node3.left = node6;
//        node3.right = node7;

        // node 4
        node4.left = node8;

        assertEquals(new L100To150().hasPathSum(node1, -2), false);
    }

    @Test
    public void testHasPathSumCase6() {

//      [1,2,null,3,null,4,null,5]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(5);


        // node 1
        node1.left = node2;
//        node1.right = node3;

        // node 2
        node2.left = node4;
//        node2.right = node5;

        // node 3
//        node3.left = node6;
//        node3.right = node7;

        // node 4
        node4.left = node8;

        assertEquals(new L100To150().hasPathSum(node1, 6), false);
    }


    @Test
    public void testHasPathSumCase7() {


        TreeNode node1 = new TreeNode(1);


        assertEquals(new L100To150().hasPathSum(node1, 1), true);
    }

}
