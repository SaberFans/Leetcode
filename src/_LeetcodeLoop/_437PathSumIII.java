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

    public int pathSumSlow(TreeNode root, int sum){
        if(root!=null)
            return recursivePathSum(root, sum, 0)+ pathSumSlow(root.left, sum)+pathSumSlow(root.right, sum);
        return 0;
    }
    private int recursivePathSum(TreeNode root, int target, int sum){
        if(root!=null){
            sum += root.val;
            int res = sum==target? 1: 0;
            return  res + recursivePathSum(root.left, target, sum) + recursivePathSum(root.right, target, sum);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new _437PathSumIII().pathSumSlow(TreeUtil.convertArrayToTree(new Integer[]{0,0,0}), 0));
    }
}
