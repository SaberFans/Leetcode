package _LeetcodeLoop;


import Tree.TreeUtil;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by epttwxz on 28/02/17.
 */
public class _145BinaryTreePostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        travelPostOrder(nodes, root);
        return nodes;
    }
    void travelPostOrder(List<Integer> nodes, TreeNode root){
        if(root!=null){
            travelPostOrder(nodes, root.left);
            travelPostOrder(nodes, root.right);
            nodes.add(root.val);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _145BinaryTreePostOrder().postorderTraversal(TreeUtil.getTree()));
    }

}

