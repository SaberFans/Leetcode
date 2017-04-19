package _LeetcodeLoop;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by yang on 19/04/2017.
 */
public class _189RotateArray {
    /*
     * For example, with n = 7 and k = 3,
     * the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     */
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length<2||k==0)
            return;
        int[] cp = Arrays.copyOf(nums, nums.length);
        for(int i=0;i<nums.length;i++){
            nums[(k+i)%nums.length] = cp[i];
        }
    }
    public void rotateJugglingAlgo(int[] nums, int k){
        if(nums!=null && nums.length>=2 && k!=0){
            int nextRotated = nums[0];
            int start = 0;
            int curStart = 0;
            int rotationCt = 0;
            while(rotationCt<nums.length){
                do{
                    curStart = (curStart+k)%nums.length;
                    int tmp = nums[curStart];
                    nums[curStart] = nextRotated;
                    nextRotated = tmp;
                    rotationCt++;
                }while(start!=curStart);
                start++;
                curStart = start;
                if(curStart>=nums.length)
                    break;
                nextRotated = nums[curStart];
            }
        }
    }
    @Test
    public void test1(){
        int nums[] = {1,2};
        int cp[] = Arrays.copyOf(nums, nums.length);
        int res[] = {1,2};
        new _189RotateArray().rotate(nums, 2);
        new _189RotateArray().rotateJugglingAlgo(cp, 2);
        Assert.assertArrayEquals(res, nums);
        Assert.assertArrayEquals(res, cp);
    }

    @Test
    public void test(){
        int nums[] = {1,2,3,4,5};
        int cp[] = Arrays.copyOf(nums, nums.length);
        int res[] = {3,4,5,1,2};
        new _189RotateArray().rotate(nums, 3);
        new _189RotateArray().rotateJugglingAlgo(cp, 3);
        Assert.assertArrayEquals(res, nums);
        Assert.assertArrayEquals(res, cp);
     }
}
