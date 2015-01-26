package Tree;

/**
 * Balanced Binary Search Tree problem. Difference of left branch's depth and
 * right branch's depth of every node isn't bigger than 1.
 */
public class BalancedBST {
    /***********************************************************************/
    /**********Slow Implementation, redundant calculation for depth*********/
    int depth(TreeNode root) {
	if (root == null)
	    return 0;
	int letfDepth = 1 + depth(root.left);
	int rightDepth = 1 + depth(root.right);

	return Math.max(letfDepth, rightDepth);
    }

    public boolean isBalanced(TreeNode root) {
	boolean depthBalanced = false;
	
	if(root==null)
	    return true;
	
	int left = depth(root.left);
	int right = depth(root.right);
	
	depthBalanced = Math.abs(left-right)>1?false:true;
	
	    
	return depthBalanced && isBalanced(root.left) && isBalanced(root.right);
    }
    /***********************************************************************/
    
    /**
     * Another quick bottom-up implementation
     * 
     * @param root
     * @return
     */
    public boolean isBalancedQuick(TreeNode root){
	boolean balance = false;
	if(root==null)
	    return false;

	
	return balance;
    }
    
}
