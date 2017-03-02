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

    TreeNode(int x) {
	val = x;
    }
}
