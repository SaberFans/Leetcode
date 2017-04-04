package _LeetcodeLoop;

import Tree.TreeNode;
import Tree.TreeUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class _110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return getNodeDepthDiff(root)!=-1;
    }
    private int getNodeDepthDiff(TreeNode root){
        if(root==null)
            return 0;
        int lDiff = getNodeDepthDiff(root.left);
        if(lDiff==-1)   return -1;
        int rDiff = getNodeDepthDiff(root.right);
        if(rDiff==-1)   return -1;
        if(Math.abs(lDiff-rDiff)<2)
            return Math.max(lDiff,rDiff)+1;
        return -1;
    }
    @Test
    public void test(){
        TreeNode root = TreeUtil.getBalancedBST(new int[]{1,2,3,4,5}, 0, 4);
        assertTrue(new _110BalancedBinaryTree().isBalanced(root));
        TreeNode unbalanced = TreeUtil.convertArrayToTree(new Integer[]{1,null, 2,null, 3,null, 4,null});
        assertFalse(new _110BalancedBinaryTree().isBalanced(unbalanced));
    }
}
