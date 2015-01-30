package Tree;

/**
 * Determine if a tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        // explicitly from root to leaf node.
        if(sum==root.val && (root.left==null && root.right==null))
            return true;
        if(root.left!=null){
            boolean isOnLeft = hasPathSum(root.left, sum-root.val);
            if(isOnLeft)
                return true;
        }

        if(root.right!=null){
            boolean isOnRight = hasPathSum(root.right, sum-root.val);
            if(isOnRight)
                return true;
        }

        return false;

    }
}
