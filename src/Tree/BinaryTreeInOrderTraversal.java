package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * In-Order Binary tree traversal
 */
public class BinaryTreeInOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        Stack<TreeNode> visited = new Stack<>();
        if(root==null)
            return tree;

        nodes.push(root);
        TreeNode oleft = null;
        while(!nodes.isEmpty()){
            root = nodes.peek();
            if(!visited.isEmpty()){
                oleft = visited.peek();
            }
            if(root.left==null){
                tree.add(root.val);
                nodes.pop();
                if(root.right!=null)
                    nodes.push(root.right);
            }
            else if(root.left!=oleft){
                visited.push(root.left);
                nodes.push(root.left);
            }
            else{
                tree.add(root.val);
                nodes.pop();
                visited.pop();
            }
        }

        return tree;
    }

    @Test
    public void test(){

    }

}
