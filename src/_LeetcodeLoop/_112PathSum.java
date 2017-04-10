package _LeetcodeLoop;

import Tree.TreeNode;
import Tree.TreeUtil;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * PathSum checks if a root-to-leaf path sums up to target sum.
 * Only if root has no children, you compare its val with the sum.
 * Created by yang on 29/03/2017.
 */
public class _112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root!=null){
            if(root.left==null && root.right==null)
                return sum==root.val;
            return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
        }
        return false;
    }
    public boolean hasPathSum_non_re(TreeNode root, int sum){
        if(root!=null) {
            Deque<Integer> sum_q = new ArrayDeque<>();
            Deque<TreeNode> visited_t = new ArrayDeque<>();
            sum_q.offerFirst(sum);
            visited_t.offerFirst(root);
            while(!visited_t.isEmpty()){
                TreeNode node_c = visited_t.pollFirst();
                Integer sum_t = sum_q.pollFirst();
                if(node_c.left==null && node_c.right==null){
                    if(sum_t==node_c.val)   return true;
                }
                if(node_c.right!=null){
                    sum_q.offerFirst(sum_t-node_c.val);
                    visited_t.offerFirst(node_c.right);
                }
                if(node_c.left!=null){
                    sum_q.offerFirst(sum_t-node_c.val);
                    visited_t.offerFirst(node_c.left);
                }

            }
            return false;
        }
        return false;
    }
    @Test
    public void test(){
        TreeNode root = TreeUtil.convertArrayToTree(new Integer[]{1, 2, null, 3, null, 4, null});
        assertTrue(new _112PathSum().hasPathSum(root, 10));
        TreeNode root_r = TreeUtil.convertArrayToTree(new Integer[]{1, 2, null});
        assertFalse(new _112PathSum().hasPathSum(root_r, 1));
    }
    @Test
    public void non_rec_test(){
        ArrayList<Integer> elems = new ArrayList<>();
        int targetSum =0;
        for(int i=0;i<100000;i++){
            elems.add(i+1);
            elems.add(null);
            targetSum+=i+1;
        }
        Integer[] elemData = elems.toArray(new Integer[]{});
        TreeNode bigtree_r = TreeUtil.convertArrayToTree(elemData);

        assertTrue(new _112PathSum().hasPathSum_non_re(bigtree_r, targetSum));
    }
}