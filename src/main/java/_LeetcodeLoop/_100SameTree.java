package _LeetcodeLoop;

import Tree.TreeNode;
import Tree.TreeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yang on 16/04/2017.
 */
public class _100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==q)    return true;
        if(p==null||q==null)    return false;
        return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameNonRecur(TreeNode p, TreeNode q){
        Deque<TreeNode> nodes = new ArrayDeque<>();
        if(p==q)return true;
        if(p==null || q==null)  return false;
        nodes.offer(p);
        nodes.offer(q);
        while(!nodes.isEmpty()){
            TreeNode pNode = nodes.poll();
            TreeNode qNode = nodes.poll();

            if(pNode.val!=qNode.val)
                return false;

            if(pNode.left!=null&&qNode.left!=null){
                nodes.offer(pNode.left);
                nodes.offer(qNode.left);
            }
            else if(pNode.left!=null || qNode.left!=null){
                return false;
            }

            if(pNode.right!=null&&qNode.right!=null){
                nodes.offer(pNode.right);
                nodes.offer(qNode.right);
            }
            else if(pNode.right!=null || qNode.right!=null){
                return false;
            }
        }
        return true;
    }
    @Test
    public void testValid() throws Exception {
        TreeNode input = TreeUtil.convertArrayToTree(new Integer[]{1,2,3,4,5,6,7,8});
        TreeNode target = TreeUtil.convertArrayToTree(new Integer[]{1,2,3,4,5,6,7,8});
        Assert.assertTrue(new _100SameTree().isSameTree(input, target));
        Assert.assertTrue(new _100SameTree().isSameNonRecur(input, target));
    }


}
