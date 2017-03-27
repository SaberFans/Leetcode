package _LeetcodeLoop;

import Tree.TreeNode;
import Tree.TreeUtil;
import org.junit.Test;

/**
 * Created by yang on 27/03/2017.
 */
public class _235LeastCommonParentBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while( ((long) root.val - p.val) * ((long)root.val -q.val) >0)
            root = (root.val-(long)p.val) >0? root.left: root.right;
        return root;
    }
    @Test
    public void test(){
        TreeNode lca = new _235LeastCommonParentBST().lowestCommonAncestor(TreeUtil.convertArrayToTree(new Integer[]{1,3,5,7}), new TreeNode(3), new TreeNode(5));
        System.out.println(lca);
    }
}
