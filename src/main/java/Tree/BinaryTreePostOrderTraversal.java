package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {

    /**
     * Keep a previous reference to keep the left/right child, to
     * prevent duplicates nodes to add into Stack.
     * *Needs more optimization on the code*
     *
     * @param root Top-most root
     * @return post-Order traversal of binary tree.
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        if (root == null)
            return tree;

        nodes.push(root);
        TreeNode previous = root;
        while (!nodes.isEmpty()) {
            root = nodes.peek();
            if (root.left == null && root.right == null) {
                tree.add(root.val);
                nodes.pop();
                previous = root;
            } else if (root.left == previous) {
                if (root.right == null) {
                    nodes.pop();
                    tree.add(root.val);
                    previous = root;
                } else {
                    nodes.push(root.right);
                }
            } else if (root.right == previous) {
                nodes.pop();
                tree.add(root.val);
                previous = root;
            } else {
                if (root.left != null) {
                    nodes.push(root.left);
                } else if (root.right != null) {
                    nodes.push(root.right);
                }
            }
        }

        return tree;
    }

    /**
     * Iterative approach, in more neat manner.
     * Commented and Optimized.
     */
    public List<Integer> postOrderTraversalOptimized(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        if (root == null)
            return postOrder;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        // Record the last popped child nodes, from left side or right side.
        TreeNode last = root;
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.peek();
            if (curr != null) {
                // Not Returning from left and right
                if (curr.left != last && curr.right!=last) {
                    nodes.push(curr.left);
                    last = curr.left;
                }
                // Returning from left child, go to right child.
                else if(curr.right!=last) {
                    nodes.push(curr.right);
                    last = curr.right;
                }
                else{
                    postOrder.add(curr.val);
                    nodes.pop();
                    last = curr;
                }
            } else {
                nodes.pop();
                if (nodes.peek().right == last || nodes.peek().right == null) {
                    postOrder.add(nodes.peek().val);
                    last = nodes.peek();
                    nodes.pop();
                } else {
                    last = nodes.peek().right;
                    nodes.push(nodes.peek().right);
                }
            }
        }
        return postOrder;
    }


    /**
     * Recursive way to visit the nodes.
     */
    private List<Integer> postorderTree = new ArrayList<>();

    public List<Integer> postOrderTraversalRecur(TreeNode root) {
        if (root == null)
            return postorderTree;
        postOrderTraversalRecur(root.left);
        postOrderTraversalRecur(root.right);
        postorderTree.add(root.val);
        return postorderTree;
    }

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = null;
        n1.right = n3;
        n2.left = null;
        n2.right = n3.left = n3.right = null;
        List<Integer> tr = postOrderTraversalOptimized(n1);

        System.out.println(tr);
    }

}
