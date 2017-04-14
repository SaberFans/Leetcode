package _LeetcodeLoop;

/**
 * Created by yang on 2017/2/22.
 */
public class _35SearchInsertPos {
    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>target)
                high -=1;
            else if(nums[mid]==target)
                return mid;
            else
                low+=1;
        }
        return low;
    }
}
