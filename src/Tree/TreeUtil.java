package Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by epttwxz on 28/02/17.
 */
public class TreeUtil {
    static public TreeNode getTree(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n2.right = n3.left = n3.right = null;
        return n1;
    }
    static public TreeNode getBalancedBST(int []array, int low, int high){
        if(low>high)
            return null;
        int mid = low+ ((high-low)>>1);
        TreeNode node = new TreeNode(array[mid]);
        node.left =  getBalancedBST(array, low, mid-1);
        node.right = getBalancedBST(array, mid+1, high);
        return node;
    }

    static public String levelTravel(TreeNode node){
        Deque<Object> nodes = new LinkedList<>();
        StringBuilder output = new StringBuilder();
        nodes.add(node);
        nodes.add("stop");   // as a control flag for new line.
        while(!nodes.isEmpty()){
            Object curNode = nodes.pollFirst();
            if(curNode!=null){
                TreeNode curTNode = (TreeNode) curNode;
                output.append(Integer.toString(curTNode.val)).append(" ");
                nodes.add(curTNode.left);
                nodes.add(curTNode.right);
                if(nodes.peekFirst()!=null && nodes.peekFirst() instanceof String){
                    output.append("\n");
                    nodes.pollFirst();
                    nodes.add("stop");
                }
            }
            else {
                output.append("null ");
                if(nodes.peekFirst()!=null && nodes.peekFirst() instanceof String){
                    output.append("\n");
                    nodes.pollFirst();
                }
            }
        }
        return output.toString();
    }
    static public TreeNode convertArrayToTree(Integer []array){
        TreeNode root = null;
        if(array!=null && array.length>0) {
            Deque<TreeNode> nodes = new ArrayDeque<>();
            root = new TreeNode(array[0]);
            nodes.addLast(root);
            for(int i=0;i<array.length-1;) {
                TreeNode curRoot = nodes.pollFirst();
                TreeNode left = array[++i]==null?null: new TreeNode(array[i]);
                if(left!=null)
                    nodes.addLast(left);
                curRoot.left = left;
                if(i<array.length-1) {
                    TreeNode right = array[++i]==null?null: new TreeNode(array[i]);
                    if(right!=null)
                        nodes.addLast(right);
                    curRoot.right = right;
                }
            }
        }
        return root;
    }
    /* delete min for BST */
    static private TreeNode deleteMin(TreeNode root){
        if(root==null)
            return null;
        if(root.left==null){
            return root.right==null?null: root.right;
        }
        else {
            root.left = deleteMin(root.left);
            return root;
        }
    }

    public static void main(String[] args) {
        Integer [] tree={10,6,14,4,8,12,16,2,5,7,9,11,13,15,17};
        TreeNode root = convertArrayToTree(tree);
        levelTravel(root);
        root = deleteMin(root);
        System.out.println();
        levelTravel(root);


    }
}
