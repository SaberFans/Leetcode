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
}
