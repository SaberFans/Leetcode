package _LeetcodeLoop;

import java.util.Arrays;

/**
 * Created by epttwxz on 23/02/17.
 */
public class _27RemoveElements {
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0)
            return 0;
        int pos = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int nums[]={1,2,4,1,2,4,2,4,2,3,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(new _27RemoveElements().removeElement(nums, 2));;
        System.out.println(Arrays.toString(nums));
    }
}
