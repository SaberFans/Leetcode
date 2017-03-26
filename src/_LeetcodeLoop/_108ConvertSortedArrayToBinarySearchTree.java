package _LeetcodeLoop;

import Tree.TreeNode;
import org.junit.Test;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * Refer <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/#/description">here</a>
 */
public class _108ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums!=null){
            return getNextNode(nums, 0, nums.length-1);
        }
        return null;
    }
    private TreeNode getNextNode(int[] nums, int low, int high){
        if(low>high)
            return null;
        if(low==high){
            return new TreeNode(nums[low]);
        }
        int mid = low+(high-low)/2;;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getNextNode(nums, low, mid-1);
        root.right = getNextNode(nums, mid+1, high);
        return root;
    }
    @Test
    public void test(){
        System.out.println(new _108ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{1,3}));
    }
}
