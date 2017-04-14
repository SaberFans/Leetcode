package _LeetcodeLoop;

/**
 * Created by yang on 2017/2/22.
 */
public class _26RemoveDuplicatesFromSorted {
    public int removeDuplicates(int[]nums){
        if(nums==null)
            return 0;
        if(nums.length<2)
            return nums.length;
        int cursor = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1])
                nums[cursor++] = nums[i];
        }
        return cursor;
    }
}
