package _LeetcodeLoop;

/**
 * Created by yang on 2017/2/22.
 */
public class _414ThirdMax {
    public int thirdMax(int[] nums) {
        if(nums==null || nums.length==0)
            return Integer.MIN_VALUE;
        Integer max = null;
        Integer max_second = null;
        Integer max_third = null;

        for(Integer integer : nums){
            if(integer.equals(max) || integer.equals(max_second) || integer.equals(max_third) )
                continue;
            if(max==null || integer>max){
                max_third = max_second;
                max_second = max;
                max = integer;
            }
            else if(max_second==null || integer>max_second){
                max_third = max_second;
                max_second = integer;
            }
            else if(max_third==null || integer>max_third){
                max_third = integer;
            }
        }

        return max_third==null? max: max_third;
    }

    public static void main(String[] args) {
        int []nums = {3,2,1};
        System.out.println(new _414ThirdMax().thirdMax(nums));
    }
}
