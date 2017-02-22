package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yang on 2017/2/21.
 */
public class _448FindDisappearedNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNums = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] *= -1;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0)   disappearedNums.add(i+1);
        }
        return disappearedNums;
    }

}
