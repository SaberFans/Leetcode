package _LeetcodeLoop;

import org.junit.Assert;
import org.junit.Test;

import Tree.TreeNode;
import Tree.TreeUtil;

/**
 * created by yang on 14 Apr 2017
 */
public class _104MaxDepthOfBinaryTree {
	public int maxDepthDFS(TreeNode root){
		if(root==null)
			return 0;
		int leftMax = maxDepthDFS(root.left);
		int rightMax = maxDepthDFS(root.right);
		return Math.max(leftMax, rightMax)+1;
	}
	
	public int MaxDepthBFS(TreeNode root){
		return 0;
	}
	@Test
	public void unblancedTreeTest(){
		TreeNode root = TreeUtil.convertArrayToTree(new Integer[]{1,null, 2,null, 3, null, 4, null, 5, null});
		Assert.assertTrue(new _104MaxDepthOfBinaryTree().maxDepthDFS(root)==5);
	}
	@Test
	public void balancedTreeTest(){
		TreeNode root = TreeUtil.convertArrayToTree(new Integer[]{1,2,3,4,5,6,7,8,9,10});
		Assert.assertEquals(new _104MaxDepthOfBinaryTree( ).maxDepthDFS(root), 4);
	}
}
