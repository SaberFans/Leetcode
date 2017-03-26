package _LeetcodeLoop;

import Tree.TreeNode;
import Tree.TreeUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Refer <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/#/description">here</a>
 */
public class _111MinimumTreeDepth {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        return (leftMin==0? rightMin: (rightMin==0?leftMin: Math.min(leftMin,rightMin))) +1;
    }
    @Test
    public void test(){
        assertEquals(new _111MinimumTreeDepth().minDepth(TreeUtil.convertArrayToTree(new Integer[]{1,2})), 2);
        assertEquals(new _111MinimumTreeDepth().minDepth(TreeUtil.convertArrayToTree(new Integer[]{1})), 1);
        assertEquals(new _111MinimumTreeDepth().minDepth(TreeUtil.convertArrayToTree(new Integer[]{1,null,2})), 2);
        assertEquals(new _111MinimumTreeDepth().minDepth(TreeUtil.convertArrayToTree(new Integer[]{1,3,2,null,null,5,null})), 2);
    }
}
