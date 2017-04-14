package Tree;

/**
 * Check if a binary tree is symmetric around its center.
 */
public class SymmetricTree {
    
    /**
     * Recursive Solution.
     * @param left
     * @param right
     * @return isSymmetric true or false
     */
    boolean validate(TreeNode left, TreeNode right){
	boolean valid = false;
	
	// return true if both are null.
	if(left==null && right==null)
	    return true;
	
	// return false if only one of them is null
	if(left==null || right==null)
	    return false;
	
	valid = left.val==right.val;
	// continue to check if they are equivalent but not null
	valid = valid && validate(left.left, right.right) && validate(left.right, right.left);
	return valid;
	 
    }
    public boolean isSymmetric(TreeNode root) {
	boolean isSymmetric = false;
	if(root==null)
	    return true;
	
	isSymmetric = validate(root.left, root.right);
	
	return isSymmetric;
    }
}
