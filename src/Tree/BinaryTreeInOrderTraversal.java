
package Tree;

import java.util.*;

import org.junit.Test;
/**
 * Definition for binary tree public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class BinaryTreeInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> list = new ArrayList<>();
	Stack<TreeNode> nodes = new Stack<>();;
	if(root==null)
	    return list;
	nodes.push(root);
	
	while (!nodes.isEmpty()) {
	    
	    if(root.left!=null){
		nodes.push(root.left);
		root = root.left;
	    }
	    else{
		list.add(root.val);
		root = nodes.pop();
		if(root.right != null){
		    nodes.push(root.right);
		    root = root.right;
		}
		else{
		    if(nodes.peek()!=null && nodes.peek().right!=null){
			root = nodes.pop();
		    }
		}	
		
	    }
	}
	return list;
	
    }
    
    
    /**
     * Recursively to print the In-Order traversal sequence of BT.
     * @param root
     * @return
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
	if(root==null)
	    return list;
	inorderTraversal(root.left);
	list.add(root.val);
	inorderTraversal(root.right);
	
	return list;
    }
    
    @Test
    public void test(){
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(6);
	TreeNode n3 = new  TreeNode(3);
	n1.left = n2; n1.right = n3;
	n2.left = n2.right = n3.left = n3.right = null;
	List<Integer> tr = inorderTraversal(n1);
	System.out.println(n1.val);
	System.out.println(tr);
    }	
    
}
