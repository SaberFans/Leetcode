package _LeetcodeLoop;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

import Tree.TreeNode;
import Tree.TreeUtil;

/**
 * created by yang on 14 Apr 2017
 */
public class _104MaxDepthOfBinaryTree {
	public int maxDepthDfs(TreeNode root) {
		if (root == null)
			return 0;
		int leftMax = maxDepthDfs(root.left);
		int rightMax = maxDepthDfs(root.right);
		return Math.max(leftMax, rightMax) + 1;
	}

	public int MaxDepthBfs(TreeNode root) {
		int depth = 0;
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			int width = nodes.size();
			TreeNode curRoot = nodes.poll();
			if (curRoot != null) {
				depth++;
				for (int i = 0; i < width; i++) {
					if (i > 0)
						curRoot = nodes.poll();
					if (curRoot != null) {
						nodes.add(curRoot.left);
						nodes.add(curRoot.right);
					}
				}
			}
		}
		return depth;
	}

	@Test
	public void unblancedTreeTest() {
		TreeNode root = TreeUtil.convertArrayToTree(new Integer[] { 1, null, 2, null, 3, null, 4, null, 5, null });
		Assert.assertTrue(new _104MaxDepthOfBinaryTree().maxDepthDfs(root) == 5);
		Assert.assertTrue(new _104MaxDepthOfBinaryTree().MaxDepthBfs(root) == 5);
	}

	@Test
	public void balancedTreeTest() {
		TreeNode root = TreeUtil.convertArrayToTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		Assert.assertEquals(new _104MaxDepthOfBinaryTree().maxDepthDfs(root), 4);
		Assert.assertEquals(new _104MaxDepthOfBinaryTree().MaxDepthBfs(root), 4);
	}
}
