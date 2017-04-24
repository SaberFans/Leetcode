package Tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class BinaryTreePostOrderTraversal {

    /**
     * Keep a last visited tree node reference.
     * @param root
     * @return postorder traversal of binary tree.
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root!=null){

            Deque<TreeNode> nodes = new ArrayDeque<>();
            nodes.add(root);

            TreeNode prev = null;

            while(!nodes.isEmpty()){
                TreeNode rt = nodes.peekLast();

                // going down to fetch all the nodes.
                if(prev==null || prev.left==rt|| prev.right==rt){
                    if(rt.left!=null){
                        nodes.add(rt.left);
                    }
                    else if(rt.right!=null){
                        nodes.add(rt.right);
                    }
                    else{
                        ret.add(nodes.pollLast().val);
                    }
                }
                // going up from left sub tree
                else if(rt.left==prev){
                    if(rt.right!=null){
                        nodes.add(rt.right);
                    }
                    else{
                        ret.add(nodes.pollLast().val);
                    }
                }
                // going up from right sub tree
                else if(rt.right==prev){
                    ret.add(nodes.pollLast().val);
                }

                prev = rt;
            }
        }
        return ret;
    }
    @Test
    public void test_postorder_iterative1(){
        TreeNode node = TreeUtil.convertArrayToTree(new Integer[]{1,2,3,4,5,6,7});
        List<Integer> expected = Arrays.asList(4,5,2,6,7,3,1);

        Assert.assertEquals(expected, new BinaryTreePostOrderTraversal().postOrderTraversal(node));
        Assert.assertEquals(expected, new BinaryTreePostOrderTraversal().postOrderTraversalOptimized(node));
    }
    @Test
    public void test_postorder_iterative2(){
        TreeNode node = TreeUtil.convertArrayToTree(new Integer[]{1,2,3,null,5,6,7,8,9});
        List<Integer> expected = Arrays.asList(8,9,5,2,6,7,3,1);

        Assert.assertEquals(expected, new BinaryTreePostOrderTraversal().postOrderTraversal(node));
        Assert.assertEquals(expected, new BinaryTreePostOrderTraversal().postOrderTraversalOptimized(node));
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
                // going down
                if (curr.left != last && curr.right!=last) {
                    nodes.push(curr.left);
                    last = curr.left;
                }
                // Returning from left child, go to right child.
                else if(curr.left==last) {
                    nodes.push(curr.right);
                    last = curr.right;
                }
                else{
                    postOrder.add(curr.val);
                    nodes.pop();
                    last = curr;
                }
            } else {
                nodes.pop();//nodes.peek().right == last ||
                if (nodes.peek().right == null) {
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

}
