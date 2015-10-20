package Array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class FirstMissingPositive {

	/**
	 * Easy solution but extra O(n) space
	 * @param nums
	 * @return
	 */
	public int firstMissingPositive(int[] nums) {
		if(nums==null || nums.length==0)
			return 1;
		Integer miss_minimum = 1;
		HashSet<Integer> hash = new HashSet<>();
		Integer[] ints = new Integer[nums.length];
		for(int i=0;i<ints.length;i++)
			ints[i] = nums[i];
		
		hash.addAll(Arrays.asList(ints));
		while(hash.contains(miss_minimum)){
			miss_minimum++;
		}
		
		return miss_minimum;
	}
	/**
	 * K balls into k+1 bins
	 * @param nums
	 * @return first missing positive INT
	 */
	public int firstMissingPositive_const_space(int[] nums) {
		if(nums==null || nums.length==0)
			return 1;
				
		int k = parition_by_zero(nums);
		for(int i=0;i<k;i++){
			int posVal = Math.abs(nums[i]); // get the actual value
			
			posVal--;
			if(posVal<k)
				nums[posVal] = nums[posVal]<0 ? nums[posVal]:-1*nums[posVal];
		}
		/*int minimum = 0;
		for(int i=0;i<k;i++, minimum = i){
			if(nums[i]>0){
				return minimum+1; 
			}
		}*/
		int minimum = k;   // if from a[0] to a[k-1], non of them >0, use this value
		for(int i=0;i<k;i++)
			if(nums[i]>0){
				minimum = i;
				break;
			}
				
		return minimum+1;
		
	}
	private int parition_by_zero(int A[]){
		if(A==null || A.length==0)
			throw new RuntimeException("Input array cannot be null or empty");
		
		int q = 0;
		for(int i=0;i<A.length;i++){
			if(A[i]>0){
				swap(A, i, q++);
			}
		}
		return q;
	}
	private void swap(int[]A , int i, int j){
		if (A == null || A.length == 0 || i < 0 || j < 0)
			return;

		if (i != j) {
			A[i] ^= A[j];
			A[j] ^= A[i];
			A[i] ^= A[j];
		}
	}
	
	
	@Test
	public void test() {
		assertEquals(2, new FirstMissingPositive().firstMissingPositive(new int[]{3,4, -1 ,1}));
		assertEquals(2, new FirstMissingPositive().firstMissingPositive_const_space(new int[]{3,4, -1 ,1}));
		assertEquals(3, new FirstMissingPositive().firstMissingPositive(new int[]{2,4, -1 ,1}));
		assertEquals(3, new FirstMissingPositive().firstMissingPositive_const_space(new int[]{2,4, -1 ,1}));

	}
	@Test
	public void boundary_test(){
		assertEquals(1, new FirstMissingPositive().firstMissingPositive(new int[]{}));
		assertEquals(1, new FirstMissingPositive().firstMissingPositive_const_space(new int[]{}));
		assertEquals(1, new FirstMissingPositive().firstMissingPositive(new int[]{2}));
		assertEquals(1, new FirstMissingPositive().firstMissingPositive_const_space(new int[]{2}));
	}
	@Test
	public void all_postive_test(){
		assertEquals(5, new FirstMissingPositive().firstMissingPositive_const_space(new int[]{1,2,3,4}));
	}
}
