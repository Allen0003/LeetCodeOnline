import basicDataStructure.TreeNode;


import java.util.*;


public class L100To150 {

//        The algorithm is an implementation of a simple idea that -
//        1. For given two trees, if both trees are empty then they are mirror images of one another.
//        Else they have to satisfy following conditions:
//        2. Root values of both trees have to be same.
//        3. Left sub-tree of tree1 should be mirror image of right sub-tree of tree2.
//        4. Right sub-tree of tree1 should be mirror image of left sub-tree of tree2.

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> checkQueue = new LinkedList();

        checkQueue.add(root);
        checkQueue.add(root);

        while (!checkQueue.isEmpty()) {

            TreeNode leftNode = checkQueue.poll();
            TreeNode rightNode = checkQueue.poll();

            if (leftNode == null && rightNode == null) {
                continue;
            } else if (leftNode == null || rightNode == null) {
                return false;
            } else if (leftNode.val != rightNode.val) {
                return false;
            }


            checkQueue.add(leftNode.left);
            checkQueue.add(rightNode.right);

            checkQueue.add(leftNode.right);
            checkQueue.add(rightNode.left);
        }

        return true;
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lDepth = this.maxDepth(root.left);
        int rDepth = this.maxDepth(root.right);

        if (lDepth > rDepth) {
            return lDepth + 1;
        }
        return rDepth + 1;
    }


    // Google the formula about printing Pascal Triangle
    public List<List<Integer>> generate(int numRows) {
//         1
//        1 1
//       1 2 1
//      1 3 3 1

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list2 = null;
        for (int i = 1; i <= numRows; i++) {
            int c = 1;
            list2 = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                list2.add(c);
                c = c * (i - j) / j;
            }
            list.add(list2);
        }
        return list;
    }


    public List<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex + 1;
        List<Integer> list2 = new ArrayList<>();
        Long c = Long.valueOf(1);
        for (int j = 1; j <= rowIndex; j++) {
            list2.add(Math.toIntExact(c));
            c = c * (rowIndex - j) / j;
        }
        return list2;
    }


    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        if (root != null && root.right == null && root.left == null) { // find the leaf
            return root.val == sum;
        } else if (root != null && root.right == null) {
            return hasPathSum(root.left, sum - root.val);
        } else if (root != null && root.left == null) {
            return hasPathSum(root.right, sum - root.val);
        }
        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }

    public int maxProfit(int[] prices) {

        int profit = 0;

        if (prices == null || prices.length < 2) {
            return profit;
        }

        int buyPrice = Integer.MAX_VALUE;
        boolean holdItem = false;
        int sellPrice = Integer.MIN_VALUE;


        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= buyPrice) {
                buyPrice = prices[i];
                holdItem = true;
            } else if (holdItem && sellPrice <= prices[i]) {
                sellPrice = prices[i];
                if (i < prices.length - 1 && sellPrice > prices[i + 1]) { //selling point not the least item
                    profit += (sellPrice - buyPrice);
                    holdItem = false;
                    buyPrice = Integer.MAX_VALUE;
                    sellPrice = Integer.MIN_VALUE;
                } else if (true && i == prices.length - 1) {// the last item
                    profit += (sellPrice - buyPrice);
                }
            }
        }
        return profit;
    }

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        return Math.abs(getTreeHeight(root.left) - getTreeHeight(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getTreeHeight(root.left) + 1, getTreeHeight(root.right) + 1);
    }


}
