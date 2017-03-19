package Tree;

/**
 * Given all the distances from root to each leaf node,
 * and determine the balanced tree based on difference of those distances.
 */
public class StrictBalancedBinaryTree {
    public boolean isBalancedBinaryTree(TreeNode node){
        return node != null && getMaxDepth(node) - getMinDepth(node) <= 1;
    }
    private int getMinDepth(TreeNode node){
        if(node==null)
            return Integer.MAX_VALUE;     // ignore the non leaf node
        if(node.left==null&& node.right==null)
            return 1;
        return Math.min(getMinDepth(node.left), getMinDepth(node.right))+1;
    }
    private int getMaxDepth(TreeNode node){
        if(node==null)
            return 0;
        if(node.left==null&&node.right==null)
            return 1;
        return Math.max(getMaxDepth(node.left), getMaxDepth(node.right))+1;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.convertArrayToTree(new Integer[]{1,2,3,null,null,4,5,6});
        System.out.println(new StrictBalancedBinaryTree().isBalancedBinaryTree(node));
    }
}