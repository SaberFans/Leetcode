package Tree;

/**
 * Definition for binary tree:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    // new att for populating right pointer.
    TreeNode next;

    TreeNode(int x) {
	val = x;
    }
}
