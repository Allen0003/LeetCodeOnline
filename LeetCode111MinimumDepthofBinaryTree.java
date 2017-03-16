package practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 */

/**
 * point 1: BFS and DFSF
 * 
 * point 2: BFS's depth
 * 
 * point 3: leaf's definition 
 * 
 * */


public class LeetCode111MinimumDepthofBinaryTree {

	public int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		} else if (root.left == null && root.right == null) {
			return 2;
		}
		int index = 1;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {

			TreeNode temp = queue.poll();
			if (temp == null) {
				index++;
				queue.add(null);
				// You are encountering two consecutive `nulls` means, you
				// visited all the nodes.
				if (queue.peek() == null) {
					break;
				} else {
					continue;
				}
			}
			// finding left
			if (temp.right == null && temp.left == null) {
				break;
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
			if (temp.left != null) {
				queue.add(temp.left);
			}
		}

		return index;
	}

}
