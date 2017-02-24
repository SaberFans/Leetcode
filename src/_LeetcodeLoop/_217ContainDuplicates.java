package _LeetcodeLoop;

import java.util.HashSet;

/**
 * Created by epttwxz on 23/02/17.
 */
public class _217ContainDuplicates {
    public boolean containsDuplicate(int[] nums) {
        if(nums!=null && nums.length>1){
            HashSet<Integer> list = new HashSet<>();
            for(int i:nums)
                if(!list.add(nums[i]))
                    return true;
        }
        return false;
    }
}
