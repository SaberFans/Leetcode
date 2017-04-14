package Tree;

/**
 * Given two binary trees, write a function to check
 * if they are equal or not.
 * Two trees are identical if same structure and same values.
 * <p/>
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==q && p==null){
            return true;
        }
        else if(p==null ||q==null){
            return false;
        }
        else{
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
