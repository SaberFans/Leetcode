package _LeetcodeLoop;


import Tree.TreeNode;
import Tree.TreeUtil;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertTrue;


/**
 * created by yang on 16 Apr 2017
 */
public class _101SymmetricTree {
    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null)
            return true;   // empty tree here is symmetrical...
        return isSymmetricRecur(root.left, root.right);

    }

    private boolean isSymmetricRecur(TreeNode left, TreeNode right) {
        if (left == right) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val) {
            return isSymmetricRecur(left.left, right.right)
                    && isSymmetricRecur(left.right, right.left);
        }
        return false;
    }

    public boolean isSymmetricalNonRecur(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root == null || root.left == root.right) return true;
        if (root.left == null || root.right == null) return false;
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode right = queue.pollLast();
            TreeNode left = queue.pollLast();
            if (right.val != left.val)
                return false;

            // the symmetric check 1
            if (left.left != null && right.right != null) {
                queue.offer(left.left);
                queue.offer(right.right);
            } else if (left.left != null || right.right != null) {
                return false;
            }

            // the symmetric check 2
            if (left.right != null && right.left != null) {
                queue.offer(left.right);
                queue.offer(right.left);
            } else if (left.right != null || right.left != null) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void unit_test() throws Exception {
        TreeNode root = TreeUtil.convertArrayToTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        assertTrue(new _101SymmetricTree().isSymmetricRecursive(root));
        assertTrue(new _101SymmetricTree().isSymmetricalNonRecur(root));
    }
}
