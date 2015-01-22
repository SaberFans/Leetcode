package Tree;

import org.junit.Test;

/**
 * Convert sorted array to height balanced binary search tree.
 */
public class ConvertSortedArrayToBST {

    /**
     * Recursive solution, binary search technique to split the array.
     * And add left/child to current root.
     * @param start
     * @param end
     * @param num  sorted array to convert
     * @param root current level sub-tree's root 
     * @return the root of current level 
     */
    TreeNode splitIntoTree(int start, int end, int num[], TreeNode root) {

	TreeNode left, right;
	left = right = null;

	int mid = start + (end - start) / 2;
	if (root == null) {
	    root = new TreeNode(num[mid]);

	    splitIntoTree(start, mid - 1, num, root);
	    splitIntoTree(mid + 1, end, num, root);

	}
	if (start > end)
	    return root;

	if (num[mid] > root.val) {

	    root.right = new TreeNode(num[mid]);
	    right = root.right;

	    splitIntoTree(start, mid - 1, num, right);
	    splitIntoTree(mid + 1, end, num, right);

	} else if (num[mid] < root.val) {
	    root.left = new TreeNode(num[mid]);
	    left = root.left;

	    splitIntoTree(start, mid - 1, num, left);
	    splitIntoTree(mid + 1, end, num, left);
	}

	return root;
    }

    public TreeNode sortedArrayToBST(int[] num) {
	TreeNode root = null;
	int start = 0;
	int end = num.length - 1;
	if (num.length == 0)
	    return root;
	root = splitIntoTree(start, end, num, root);

	return root;

    }

    @Test
    public void test() {
	int[] a = new int[6];
	for (int i = 0; i < a.length; i++) {
	    a[i] = i;
	}

	TreeNode root = sortedArrayToBST(a);

	System.out.println(root);
    }

}
