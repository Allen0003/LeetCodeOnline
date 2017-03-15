package practice;

/**
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9 

to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

 * 
 * */


public class LeetCode226_InvertBinaryTree_E {
	public static void main(String args[]) {

		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(9);

		// node 1
		node1.left = node2;
		node1.right = node3;

		// node 2
		node2.left = node4;
		node2.right = node5;

		// node 3
		node3.left = node6;
		node3.right = node7;

		node1 = new LeetCode226_InvertBinaryTree_E().invertTree(node1);
		
	}
	// use Recursive to solve this problem
	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		TreeNode tempNode = null;

		tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;

		if (root.left != null) {
			invertTree(root.left);
		}
		if (root.right != null) {
			invertTree(root.right);
		}
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
