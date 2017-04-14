package _LeetcodeLoop;

/**
 * Created by epttwxz on 23/02/17.
 */
public class _268MissingNumber {
    public int missingNumber(int[] nums) {
        int xor = 0, i ;
        for(i=0;i<nums.length;i++){
            xor = xor ^ nums[i] ^ i;
        }
        return xor^i;
    }

    public static void main(String[] args) {
        int nums[]={0,3,1};
        System.out.println(new _268MissingNumber().missingNumber(nums));
    }

}
