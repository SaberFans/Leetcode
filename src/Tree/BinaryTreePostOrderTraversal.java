package Tree;

import java.util.*;

import org.junit.Test;

public class BinaryTreePostOrderTraversal {

    /**
     * Keep a previous reference to keep the left/right child, to
     * prevent duplicates nodes to add into Stack.
     * *Needs more optimization on the code*
     * @param root Top-most root
     * @return post-Order traversal of binary tree.
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
	List<Integer> tree = new ArrayList<>();
	Stack<TreeNode> nodes = new Stack<>();
	if (root == null)
	    return tree;

	nodes.push(root);
	TreeNode previous = root;
	while(!nodes.isEmpty()){
	    root = nodes.peek();
	    if(root.left==null && root.right==null){
		tree.add(root.val);
		nodes.pop();
		previous = root;
	    }
	    else if(root.left == previous){
		if(root.right==null){
		    nodes.pop();
		    tree.add(root.val);
		    previous =root;
	    	}
		else{
		    nodes.push(root.right);
		}
	    }
	    else if(root.right == previous){
		nodes.pop();
		tree.add(root.val);
		previous = root;
	    }
	    else{
		if(root.left!=null){
		    nodes.push(root.left);
		}
		else if(root.right!=null){
		    nodes.push(root.right);
		}
	    }
	}
	
	return tree;
    }
    
    /**
     * Recursive way to visit the nodes.
     */
    private List<Integer> postorderTree = new ArrayList<>();
    public List<Integer> postOrderTraversalRecur(TreeNode root){
	if(root==null)
	    return postorderTree;
	postOrderTraversalRecur(root.left);
	postOrderTraversalRecur(root.right);
	postorderTree.add(root.val);
	return postorderTree;
    }
    @Test
    public void test(){
	TreeNode n1 = new TreeNode(2);
	TreeNode n2 = new TreeNode(3);
	TreeNode n3 = new  TreeNode(1);
	n1.left = n2; n1.right = null;
	n2.left = n3; n2.right = n3.left = n3.right = null;
	List<Integer> tr = postOrderTraversal(n1);
 
	System.out.println(tr);
    }

}
