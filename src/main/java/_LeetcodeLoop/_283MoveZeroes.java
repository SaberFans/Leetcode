package _LeetcodeLoop;

/**
 * Created by epttwxz on 23/02/17.
 */
public class _283MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums!=null && nums.length>=2){
            int zeropos = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    int tmp = nums[i];
                    nums[i] = nums[zeropos];
                    nums[zeropos] = tmp;
                    zeropos++;
                }
            }
        }
    }
}
