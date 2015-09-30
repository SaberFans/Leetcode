package DP;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Puzzle for getting max of continuous product of sub-array
 * @author epttwxz
 *
 */
public class MaximumProductSubArray {
	
	/**
	 * Brute-force to get all combinations.
	 * @param nums
	 * @return maximum of product of sub-array
	 */
	@Deprecated
	public int maxProduct_brute_force(int[] nums) {
		int MAX_VALUE = Integer.MIN_VALUE;
		
		for(int i=0;i<nums.length;i++){
			MAX_VALUE = nums[i]>MAX_VALUE?nums[i]:MAX_VALUE;
			int last_max = nums[i];
			for(int j=i+1;j<nums.length;j++){
				last_max *= nums[j]; 
				MAX_VALUE = last_max>MAX_VALUE?last_max:MAX_VALUE;
			}
		}
		return MAX_VALUE;
	}
	
	/**
	 * Programming Pearls' DP Solution:
	 * 
	 * 	MAX[0] = DP[0] = a[0]
	 *  MAX[N] = MAX(MAX[N-1], DP[N]); 
	 * 
	 * 	if a[i]>0 
	 * 			DP[i] = DP[i-1]+a[i]
	 *  else     
	 *  		DP[i] = a[i];

	 * @param nums
	 * @return maximum of product of sub-array
	 */
	public int maxProduct_dp(int nums[]){
		if(nums.length==0)
			return 0;
		int cur_min_value = nums[0];
		int cur_max_value = nums[0];
		
		int max = cur_max_value;
		for(int i=1;i<nums.length;i++){
			int cur_max_tmp = cur_max_value;
			cur_max_value = Math.max(nums[i], Math.max(cur_max_value*nums[i], cur_min_value * nums[i]));
			cur_min_value = Math.min(nums[i], Math.min(cur_max_tmp*nums[i], cur_min_value * nums[i]));
			max = Math.max(max, cur_max_value);
		}
		
		return max;
	}
	
	@Test
	public void valid_test5(){
		assertEquals(2, new MaximumProductSubArray().maxProduct_brute_force(new int[]{2, -4}));
		assertEquals(2, new MaximumProductSubArray().maxProduct_dp(new int[]{2, -4}));
	}
	
	@Test
	public void valid_test3(){
		assertEquals(40, new MaximumProductSubArray().maxProduct_brute_force(new int[]{2, 4, 5}));
		assertEquals(40, new MaximumProductSubArray().maxProduct_dp(new int[]{2, 4, 5}));
	}
	@Test
	public void valid_test4(){
		assertEquals(20, new MaximumProductSubArray().maxProduct_brute_force(new int[]{-2, -4, -5}));
		assertEquals(20, new MaximumProductSubArray().maxProduct_dp(new int[]{-2, -4, -5}));
	}
	@Test
	public void valid_test6(){
		assertEquals(240, new MaximumProductSubArray().maxProduct_brute_force(new int[]{-2, -4, -5,-6}));
		assertEquals(240, new MaximumProductSubArray().maxProduct_dp(new int[]{-2, -4, -5,-6}));
	}
	@Test
	public void valid_test2(){
		assertEquals(30, new MaximumProductSubArray().maxProduct_brute_force(new int[]{2,3,-4, 5,6}));
		assertEquals(30, new MaximumProductSubArray().maxProduct_dp(new int[]{2,3,-4, 5,6}));
	}
	@Test
	public void zero_test(){
		assertEquals(30, new MaximumProductSubArray().maxProduct_brute_force(new int[]{2,3,0, 5,6}));
		assertEquals(30, new MaximumProductSubArray().maxProduct_dp(new int[]{2,3,0, 5,6}));
	}
}
