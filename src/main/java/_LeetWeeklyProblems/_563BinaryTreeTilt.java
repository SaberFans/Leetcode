/**
 * Created by epttwxz on Apr 24, 2017
 */
package _LeetWeeklyProblems;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import Tree.TreeNode;
import Tree.TreeUtil;


/**
 * Return the Tilt of the whole binary tree.
 * A Tilt of one node is:
 * sums of its left sub-tree nodes values 
 *    minus  
 * sum of its right sub-tree nodes values.
 * 
 * And the tilt of a whole tree is the sum of each node's tilt.
 * @author epttwxz
 *
 */
public class _563BinaryTreeTilt {
	
	private int tilt;
	
	public int findTilt(TreeNode root){
		tilt = 0;
		getsubtreeNodeDfs(root);
		return tilt;
	}
	private int getsubtreeNodeDfs(TreeNode root) {
		if(root==null)
			return 0;
		int leftVal = findTilt(root.left);
		int rigthVal = findTilt(root.right);
		tilt += leftVal -rigthVal;
		return root.val+ leftVal-rigthVal;
    }
	
	private List<Integer> postorderIterativeByVisitedMap(TreeNode root){
		HashMap<TreeNode, Boolean> visited = new HashMap<>();
		ArrayList<Integer> ret = new ArrayList<>();
		if(root!=null){
			Deque<TreeNode> nodes = new LinkedList<>();
			nodes.add(root);
			while(nodes.isEmpty()!=true){
				TreeNode rt = nodes.peekLast();
				if(visited.getOrDefault(rt, false)==true){
					TreeNode visitedRoot = nodes.pollLast();
					ret.add(visitedRoot.val);
				}
				else {
					visited.put(rt, true);
					if (rt.left == null && rt.right == null) {
						ret.add(rt.val);
						nodes.pollLast();
					}
					if (rt.right != null)
						nodes.add(rt.right);
					if (rt.left != null)
						nodes.add(rt.left);
				}
			}
		}
		return ret;
	}
	
	private List<Integer> postorderIterativeByPrev(TreeNode root){
		ArrayList<Integer> ret = new ArrayList<>();
		if(root!=null){
			Deque<TreeNode> nodes = new ArrayDeque<TreeNode>();
			nodes.add(root);
			TreeNode prev = null;
			while(nodes.isEmpty()!=true){
				
				TreeNode rt = nodes.peekLast();
				// go down the tree
				// add nodes or poll leaf nodes.
				if(prev==null || prev.left==rt ||prev.right==rt){
					if(rt.left!=null)
						nodes.add(rt.left);
					else if(rt.right!=null)
						nodes.add(rt.right);
					else
						ret.add(nodes.pollLast().val);
				}
				
				// go up the tree from the leaf nodes.
				else if(rt.left==prev){
					if(rt.right!=null){
						nodes.add(rt.right);
					}
					else{
						ret.add(nodes.pollLast().val);
					}
				}
				// finish the node's postorder
				else if(rt.right==prev){
					ret.add(nodes.pollLast().val);
				}
				prev = rt;
			}
		}
		return ret;
	}
	
	@Test
	public void test_tree_postorder_iterative(){
		TreeNode rot = TreeUtil.convertArrayToTree(new Integer[]{1,2,3,4,5,6,7});
		List<Integer> expected = Arrays.asList(new Integer[]{4,5,2,6,7,3,1});
		Assert.assertEquals(new _563BinaryTreeTilt().postorderIterativeByVisitedMap(rot), expected);
	}
    
	@Test
	public void test_postorder_iterative2(){
		TreeNode rot = TreeUtil.convertArrayToTree(new Integer[]{1,2,3,4,5,6,7});
		System.out.println();
		
	}
}	
