package Tree;

/**
 * Given a binary tree, find its minimum depth.
 */
public class MinimumDepthofBinaryTree {
    int getMinDepth(TreeNode root, int depth){
        if(root==null)
            return depth;
        return Math.min(getMinDepth(root.left, depth + 1), getMinDepth(root.right, depth + 1));
    }
    public int minDepth(TreeNode root) {
        int depth = 0;
        if(root==null)
            return depth;
        if(root.left==null && root.right==null){
            return 1;
        }
        else if(root.left!=null && root.right!=null){
            return Math.min(getMinDepth(root.left, 1), getMinDepth(root.right, 1));
        }
        else if(root.left!=null)
            return getMinDepth(root.left, 1);
        else{
            return getMinDepth(root.right, 1);
        }

    }
}

