package Array;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Return products of for the elements in the array except for the element
 * itself.
 * 
 * @author epttwxz
 * 
 */
public class ProductOfArrayExceptSelf {

	/**
	 * O(N^2) solution, and no extra space.
	 * Time Limit Exceeded.
	 * No division used.
	 * 
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int output[] = new int[nums.length];
		if(nums.length<=1)
			return output;
		// from left to right
		for(int i=0;i<nums.length;i++){
			output[i] =1;
			for(int j=i+1;j<nums.length;j++){
				output[i] *= nums[j];
			}
		}
		// from right to left
		for(int i = nums.length-1;i>=0;i--){
			for(int j = i-1;j>-0;j--){
				output[i] *= nums[j];
			}
		}
		
		return output;
	}
	
	/**
	 * Smart Solution without division and in O(N).
	 * Aggregate the product within two loops of iteration.
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf_QuickSolution(int[] nums) {
		int output[] = new int[nums.length];
		if(nums.length<=1)
			return output;
		// from left to right
		int left = 1;
		for(int i=0;i<nums.length;i++){
			output[i] = left;
			left *= nums[i];
			 
		}
		// from right to left
		int rightmost = nums[nums.length-1];
		for(int i = nums.length-2;i>=0;i--){
			output[i] *= rightmost;
			rightmost*= nums[i];
		}
		
		return output;
	}
	
	@Test
	public void test_valid1() throws Exception{
		int[] arr = {1,2,3,4};
		int[] res = {24, 12, 8, 6};
		
		assertArrayEquals(res, new ProductOfArrayExceptSelf().productExceptSelf(arr));
		assertArrayEquals(res, new ProductOfArrayExceptSelf().productExceptSelf_QuickSolution(arr));
	}
	@Test
	public void test_time_limit() throws Exception {
		int arr[] = new int[100000];
		for(int i=0;i<arr.length;i++){
			arr[i] =(int) Math.pow(-1, i);
		}
		int output1[] = new ProductOfArrayExceptSelf().productExceptSelf(arr);
		int output2[] = new ProductOfArrayExceptSelf().productExceptSelf_QuickSolution(arr);
		assertArrayEquals(output1, output2);
	}
	/**
	 * Just to test how long it takes
	 * @throws Exception
	 */
	@Test
	public void test_time_limit2() throws Exception {
		int arr[] = new int[100000];
		for(int i=0;i<arr.length;i++){
			arr[i] =(int) Math.pow(-1, i);
		}
		new ProductOfArrayExceptSelf().productExceptSelf_QuickSolution(arr);
	}
}
