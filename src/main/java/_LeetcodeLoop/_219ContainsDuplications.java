package _LeetcodeLoop;

import java.util.HashSet;

/**
 * Created by epttwxz on 23/02/17.
 */
public class _219ContainsDuplications {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums!= null && nums.length>1){
            HashSet<Integer> set = new HashSet<>();
            for(int i=0;i<nums.length;i++){
                if(set.size()>k)
                    set.remove(nums[i-k-1]);
                if(!set.add(nums[i]))
                    return true;
            }
        }
        return false;
    }
}
