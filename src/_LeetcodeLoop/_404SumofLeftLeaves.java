package _LeetcodeLoop;

import Tree.TreeNode;
import Tree.TreeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by epttwxz on 14/03/17.
 */
public class _404SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumUpLeaves(root, false);
    }
    private int sumUpLeaves(TreeNode root, boolean fromLeft){
        if(root==null)
            return 0;
        if(root.left==null &&root.right==null){
            return fromLeft? root.val: 0;
        }
        return sumUpLeaves(root.left, true)+sumUpLeaves(root.right, false);
    }

    private int easySumUpLeftLeaves(TreeNode root){
        int res = 0;
        if(root==null)
            return 0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null)
            res += root.left.val;
        res += sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
        return res;
    }

    @Test
    public void test(){
        TreeNode root = TreeUtil.convertArrayToTree(new Integer[]{1,2,3,null,null, 5});
        Assert.assertEquals(new _404SumofLeftLeaves().sumOfLeftLeaves(root), 7);
        Assert.assertEquals(new _404SumofLeftLeaves().easySumUpLeftLeaves(root), 7);
    }
}
