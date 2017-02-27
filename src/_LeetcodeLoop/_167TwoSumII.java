package _LeetcodeLoop;

import java.util.Arrays;

/**
 * Created by epttwxz on 27/02/17.
 */
public class _167TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int ind[] = new int[2];
        if(numbers!=null && numbers.length>=2){
            int start = 0, end = numbers.length-1;
            while(start<end){
                int sum = numbers[start] + numbers[end];
                if(sum==target) {
                    ind[0] = start + 1;
                    ind[1] = end + 1;
                    return ind;
                }
                if(sum<target){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        return ind;
    }

    public static void main(String[] args) {
        int []integers = {1,2,3,4,5};
        System.out.println(Arrays.toString(new _167TwoSumII().twoSum(integers, 6)));
    }
}
