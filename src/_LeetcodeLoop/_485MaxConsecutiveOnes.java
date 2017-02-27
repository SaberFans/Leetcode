package _LeetcodeLoop;

/**
 * Created by yang on 2017/2/25.
 */
public class _485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxL = 0;
        int curL = 0;
        if(nums!=null){
            for(int i:nums){
                if(i==1) {
                    curL++;
                }
                else if(curL!=0){
                    maxL = maxL>=curL?maxL:curL;
                    curL = 0;
                }
            }
            maxL = maxL>=curL?maxL:curL;
        }
        return maxL;
    }
}
