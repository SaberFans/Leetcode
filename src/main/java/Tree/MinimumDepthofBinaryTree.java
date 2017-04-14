package Tree;

/**
 * Given a binary tree, find its minimum depth.
 */
public class MinimumDepthofBinaryTree {
    int getMinDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null)
            return depth;
        else if (root.left != null && root.right != null) {
            return Math.min(getMinDepth(root.left, depth + 1), getMinDepth(root.right, depth + 1));
        } else if (root.left == null) {
            return getMinDepth(root.right, depth + 1);
        } else {
            return getMinDepth(root.left, depth + 1);
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return getMinDepth(root, 1);
    }
}

