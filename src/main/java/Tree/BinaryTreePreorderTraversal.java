package Tree;

import java.util.*;

import org.junit.Test;

/**
 * Pre-order traversal of binary tree
 */
public class BinaryTreePreorderTraversal {

    /**
     * Use Stack as the place where to
     * put the tree nodes.
     * @param root
     * @return sequence of pre-order traversal sequence.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
	
	List<Integer> lint = new ArrayList<>();
	Deque<TreeNode> deque =new ArrayDeque<>();
	if(root!=null)
	    deque.addLast(root);
	
	while(!deque.isEmpty()){
	    root = deque.removeFirst();
	    lint.add(root.val);
	    if(root.right!=null){
		deque.addFirst(root.right);
	    }
	    if(root.left!=null){
		deque.addFirst(root.left);
	    }
	}
	return lint;
    }
   
    /**
     * Recursive way to fetch the pre-order sequence.
     * 
     * @param root
     * @return
     */
    
    private List<Integer> preOrderList = new ArrayList<>();
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
	 
	if(root==null)
	    return preOrderList;
	preOrderList.add(root.val);
	if(root.left!=null){
	    preorderTraversal(root.left);
	}
	if(root.right!=null){
	    preorderTraversal(root.right);
	}
	return preOrderList;
    }
    
    @Test
    public void test(){
	
    }
    
}
