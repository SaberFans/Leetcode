package _LeetcodeLoop;
import Tree.TreeNode;
import Tree.TreeUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/#/description">543</a>
 */
public class _543DiameterOfBinaryTree {
    private class MaxLength{
        private Integer curMax = 0;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        MaxLength length = new MaxLength();
        getMaxDiameter(root, length);
        return length.curMax;
    }
    private int getMaxDiameter(TreeNode root, MaxLength curMax){
        if(root==null)
            return 0;
        Integer leftL = getMaxDiameter(root.left, curMax);
        Integer rightL= getMaxDiameter(root.right, curMax);
        curMax.curMax = curMax.curMax> leftL+rightL? curMax.curMax: leftL+rightL;
        return Math.max(leftL, rightL)+1;
    }
    @Test
    public void test(){
        assertEquals(3, new _543DiameterOfBinaryTree().diameterOfBinaryTree(TreeUtil.convertArrayToTree(new Integer[]{1,2,5,3,4})));
        assertEquals(4, new _543DiameterOfBinaryTree().diameterOfBinaryTree(TreeUtil.convertArrayToTree(new Integer[]{1,2,null,5,3,4,8,9,10})));
    }
}
