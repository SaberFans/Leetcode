package Array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

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
	public int firstMissingPositive_const_space(int[] nums) {
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
	
	@Test
	public void test() {
		assertEquals(2, new FirstMissingPositive().firstMissingPositive(new int[]{3,4, -1 ,1}));
		assertEquals(3, new FirstMissingPositive().firstMissingPositive(new int[]{2,4, -1 ,1}));

	}
	@Test
	public void boundary_test(){
		assertEquals(1, new FirstMissingPositive().firstMissingPositive(new int[]{}));
		assertEquals(1, new FirstMissingPositive().firstMissingPositive(new int[]{2}));
	}
}
