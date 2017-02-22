package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yang on 2017/2/21.
 */
public class _1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int solutions[] = null;
        HashMap<Integer, Integer> maps= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int bal = target-nums[i];
            if(maps.containsKey(nums[i])){
                solutions = new int[2];
                solutions[0] = maps.get(nums[i]);
                solutions[1] = i;
            }
            else{
                maps.put(bal, i);
            }
        }
        return solutions;
    }

    public static void main(String[] args) {
        int solutions[] = new int[2];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.toArray(new Integer[]{});

        System.out.println(Arrays.toString(solutions));
    }

}
