package _LeetcodeLoop;

import Tree.TreeNode;
import Tree.TreeUtil;

import java.util.HashMap;

/**
 * Created by epttwxz on 02/03/17.
 */
public class _437PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> occurrence = new HashMap<>();
        occurrence.put(0,1);
        return subPathSum(root, 0, sum, occurrence);
    }
    private int subPathSum(TreeNode root, int cursum, int target, HashMap<Integer, Integer> occurrence){
        if(root!=null){
            cursum += root.val;
            int res = 0;

            if(occurrence.containsKey(cursum-target))
                res = occurrence.get(cursum-target);
            int cur_pathSum = 0;
            if(occurrence.containsKey(cursum))
                cur_pathSum= occurrence.get(cursum);
            occurrence.put(cursum, cur_pathSum+1);
            res += subPathSum(root.left, cursum, target, occurrence)+subPathSum(root.right, cursum, target, occurrence);
            occurrence.put(cursum, occurrence.get(cursum)-1);
            return res;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new _437PathSumIII().pathSum(TreeUtil.convertArrayToTree(new int[]{0,0,0,0}), 0));
    }
}
