package Tree;

import java.util.*;

import org.junit.Test;

public class BinaryTreePostOrderTraversal {

    public List<Integer> postOrderTraversal(TreeNode root) {
	List<Integer> tree = new ArrayList<>();
	Stack<TreeNode> nodes = new Stack<>();
	if (root == null)
	    return tree;
	nodes.push(root);
	TreeNode left =root, right= root;
	while (nodes.isEmpty() != true) {
	    root = nodes.peek();
	    if (root.left == null && root.right == null) {

		tree.add(root.val);
		nodes.pop();
		continue;
	    } 
	    boolean leftv = true, rightv = true;
	    if (root.right != null && root.right != right  ) {
		right = root.right;
		nodes.push(root.right);
		rightv = false;
	    } 
	    if ( root.left != null && root.left != left ) {
		left = root.left;
		nodes.push(root.left);
		leftv = false;
	    }
	    if(leftv &&  rightv){
		tree.add(root.val);
		nodes.pop();
	    }
	}
	return tree;
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
