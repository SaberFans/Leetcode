package Tree;

/**
 * Populate Next Right Pointer for each node in
 * any binary tree.
 * Use Non-recursive level traversal solution.
 */
public class PopulateNextRightInEachNodeII {
    public void connect(TreeNode root) {
        TreeNode previous = null;
        TreeNode leftmost = root;
        TreeNode head = null;

        while(leftmost!=null){
            TreeNode curMost = leftmost;
            while(curMost!=null){
                if(curMost.left!=null){
                    if(head==null){
                        head = curMost.left;
                        previous = head;
                    }
                    else{
                        previous.next = curMost.left;
                        previous = curMost.left;
                    }
                }
                if(curMost.right!=null){
                    if(head==null){
                        head = curMost.right;
                        previous = head;
                    }
                    else{
                        previous.next = curMost.right;
                        previous = curMost.right;
                    }
                }
                curMost = curMost.next;
            }
            leftmost = head;
            head = null;
        }
    }

}
