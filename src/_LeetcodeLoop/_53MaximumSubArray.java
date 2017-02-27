package _LeetcodeLoop;

/**
 * Created by yang on 2017/2/25.
 */
public class _53MaximumSubArray {
    public int maxSubArray(int[] nums) {

        if(nums!=null&&nums.length>0){
            int cursum, summax;
            cursum = summax = nums[0];
            for(int i=1;i<nums.length;i++){
                cursum += nums[i];
                if(nums[i]>=cursum)
                    cursum = nums[i];
                summax = summax>=cursum?summax:cursum;
            }
            return summax;
        }
        return 0;
    }

    public static void main(String[] args) {
        int []nums = {3,-2,7,-4,-5};
        System.out.println(new _53MaximumSubArray().maxSubArray(nums));
    }
}
