package Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

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
    static public void levelTravel(TreeNode node){
        Deque<TreeNode> nodes = new ArrayDeque<>();
        int count = 1;
        int level = 1;
        nodes.addFirst(node);
        while(!nodes.isEmpty()){
            TreeNode curNode = nodes.pollFirst();
            if(curNode!=null){

                System.out.print(curNode.val+" ");
                if(count++ ==Math.pow(2, level)-1) {
                    level++;
                    System.out.println();
                }

                if(curNode.left!=null) nodes.addLast(curNode.left);
                if(curNode.right!=null) nodes.addLast(curNode.right);
            }
        }
    }
    static public TreeNode convertArrayToTree(int []array){
        TreeNode root = null;
        if(array!=null && array.length>0) {
            Deque<TreeNode> nodes = new ArrayDeque<>();
            root = new TreeNode(array[0]);
            nodes.addLast(root);
            for(int i=1;i<array.length;) {
                TreeNode curRoot = nodes.pollFirst();
                TreeNode left = new TreeNode(array[i++]);
                nodes.addLast(left);
                curRoot.left = left;
                if(i<array.length) {
                    TreeNode right = new TreeNode(array[i++]);
                    nodes.addLast(right);
                    curRoot.right = right;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int [] tree={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        levelTravel(convertArrayToTree(tree));

    }
}
