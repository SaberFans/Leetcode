package Tree;

/**
 * Definition for binary tree:
 */
public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    // new att for populating right pointer.
    TreeNode next;

    public TreeNode(int x) {
	    val = x;
    }

    @Override
    public String toString() {
        return TreeUtil.levelTravel(this);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj instanceof TreeNode){
            return this.rec_equals(this, (TreeNode)obj);
        }
        return false;
    }
    private boolean rec_equals(TreeNode target, TreeNode cur){
        if(target==cur) return true;
        if(target==null||cur==null) return false;
        if(target.val == cur.val){
            return rec_equals(target.left, cur.left) && rec_equals(target.right, target.right);
        }
        return false;
    }
}
