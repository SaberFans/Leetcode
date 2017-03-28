package _LeetcodeLoop;

import Tree.TreeNode;
import Tree.TreeUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *  LCA problem.
 */
public class _236LeastCommonParentBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode leftSubTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubTree = lowestCommonAncestor(root.right, p, q);
        return leftSubTree!=null? (rightSubTree!=null? root: leftSubTree): rightSubTree;
    }
    @Test
    public void test(){
        TreeNode root = new _108ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{1,2,3,4,5,6,7});

        System.out.println(TreeUtil.levelTravel(root));
        TreeNode node5 = TreeUtil.find(root, 5);
        TreeNode node6 = TreeUtil.find(root, 6);

        TreeNode lca = new _236LeastCommonParentBT().lowestCommonAncestor(root, node5, node6);

        assertEquals(lca, node6);

        TreeNode node1 = TreeUtil.find(root, 1);
        TreeNode node7 = TreeUtil.find(root, 7);

        lca = new _236LeastCommonParentBT().lowestCommonAncestor(root, node1, node7);
        assertEquals(lca, root);
        System.out.println(lca);
    }

}
