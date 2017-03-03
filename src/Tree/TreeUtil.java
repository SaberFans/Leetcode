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
    // for incomplete tree, this method won't work perfectly
    // as to correctly handle when to print on the next level...
    static public void levelTravel(TreeNode node){
        Deque<TreeNode> nodes = new LinkedList<>();
        int count = 0;

        nodes.add(node);
        while(!nodes.isEmpty()){
            TreeNode curNode = nodes.pollFirst();
            String val = curNode==null? "null": Integer.toString(curNode.val);
            System.out.print(val+" ");

            if(curNode!=null){
                nodes.add(curNode.left);
                nodes.add(curNode.right);
                count+=2;
            }
            if(count==nodes.size())
                System.out.println();
        }
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

    public static void main(String[] args) {
        Integer [] tree={3,9,20,null,null,15,7};
        TreeNode root = convertArrayToTree(tree);
        System.out.println(root);

    }
}
