package Array;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import util.junit.test.ArrayUtil;

/**
 * Find elements' whose occurrence time > N/3.
 * 
 * @author epttwxz
 * 
 */
public class MajorityElementII {
	/**
	 * 
	 * Naive solution using sort to find the three potential majorities elements.
	 * And then verify each of them.
	 * @param nums
	 * @return
	 */
	public List<Integer> majorityElement_Simple(int[] nums) {
		List<Integer> majority = new ArrayList<>();
		if(nums.length==0)
			return majority;
		Arrays.sort(nums);
		
		// all possible positions to check
		int majorityOne = nums[0];
		int majorityTwo = nums[nums.length/2];
		int majorityThree = nums[nums.length-1];
		
		//verify the occurrence of 2 assumed majority.
		int countM1 = 0, countM2 =0, countM3 = 0;
		for(int i=0;i<nums.length;i++){
			countM1 = nums[i]== majorityOne?++countM1: countM1;
			countM2 = nums[i]==majorityTwo?++countM2:countM2; 
			countM3 = nums[i]==majorityThree?++countM3:countM3; 
		}
		
		if(countM1>nums.length/3)
			majority.add(majorityOne);
		if(majorityTwo!= majorityOne && countM2>nums.length/3)
			majority.add(majorityTwo);
		if(majorityThree!= majorityTwo && countM3> nums.length/3)
			majority.add(majorityThree);
		
		return majority;
	}
	
	
	/**
	 * Boyer-Moore Majority Vote algorithm.
	 * 
	 * @param nums
	 * @return list majorities elements which has occurrence > 3/N.
	 */
	public List<Integer> majorityElementBoyerMoore(int[]nums){
		List<Integer> majority = new ArrayList<>();
		if(nums.length==0)
			return majority;
		
		int majOne =0, majTwo=0, 
			countM1=0, countM2 =0;
		
		for(int i=0;i<nums.length;i++){
			if(nums[i]==majOne){
				countM1++;
			}
			else if(nums[i]==majTwo){
				countM2++;
			}
			else if(countM1==0){
				majOne = nums[i];
				countM1++;
			}
			else if(countM2 ==0){
				majTwo = nums[i];
				countM2++;
			}
			
			else{
				countM1--; countM2--;
			}
		}
		
		countM1 = 0;
		countM2 = 0;
		
		for(int i=0;i<nums.length;i++){
			if(nums[i]==majOne)
				countM1++;
			else if(nums[i]==majTwo)
				countM2++;
		}
		
		if(countM1>nums.length/3)
			majority.add(majOne);
		if(countM2>nums.length/3)
			majority.add(majTwo);
		
		return majority;
	}
	
	@Test
	public void testMajorityMethod() throws Exception {
		List<Integer> result = new ArrayList<>();
		result.add(1);
		
		int num[]={0,1,1,2};
		
		Arrays.equals(ArrayUtil.toArray(result.toArray(new Integer[0])), ArrayUtil.toArray(new MajorityElementII().majorityElement_Simple(num).toArray(new Integer[0])));
		
		Arrays.equals(ArrayUtil.toArray(result.toArray(new Integer[0])), ArrayUtil.toArray(new MajorityElementII().majorityElementBoyerMoore(num).toArray(new Integer[0])));
	}
	@Test
	public void testMajorityMethod2() throws Exception {
		List<Integer> result = new ArrayList<>();
		result.add(1);
		result.add(2);
		
		int num[]={0,1,1,2,2};
		
		int[] result1= ArrayUtil.toArray(result.toArray(new Integer[0]));
		int[] result2 = ArrayUtil.toArray((new MajorityElementII().majorityElement_Simple(num)).toArray(new Integer[0]));
		
		assertEquals(true, Arrays.equals(result1, result2));
		
		result2 = ArrayUtil.toArray((new MajorityElementII().majorityElementBoyerMoore(num)).toArray(new Integer[0]));
		
		Arrays.sort(result2);  // the outcome maybe not in the order
		assertEquals(true, Arrays.equals(result1, result2));
		
	}
	@Test
	public void testMajorityMethod4() throws Exception {
		List<Integer> result = new ArrayList<>();
		result.add(7);
		result.add(8);
		
		int num[]={8,8,7,7,7};
		
		int[] result1= ArrayUtil.toArray(result.toArray(new Integer[0]));
		int[] result2 = ArrayUtil.toArray((new MajorityElementII().majorityElement_Simple(num)).toArray(new Integer[0]));
		
		assertEquals(true, Arrays.equals(result1, result2));
		 
		num=new int[]{8,8,7,7,7};
		result2 = ArrayUtil.toArray((new MajorityElementII().majorityElementBoyerMoore(num)).toArray(new Integer[0]));
		Arrays.sort(result2);  // the outcome maybe not in the order
		assertEquals(true, Arrays.equals(result1, result2));
	}
	
	@Test
	public void testMajorityMethod3() throws Exception {
		List<Integer> result = new ArrayList<>();
		result.add(1);
		result.add(2);
		
		int num[]={1,1,2,2};
		
		int[] result1= ArrayUtil.toArray(result.toArray(new Integer[0]));
		int[] result2 = ArrayUtil.toArray((new MajorityElementII().majorityElement_Simple(num)).toArray(new Integer[0]));
		
		assertEquals(true, Arrays.equals(result1, result2));
		
		result2 = ArrayUtil.toArray((new MajorityElementII().majorityElementBoyerMoore(num)).toArray(new Integer[0]));
		Arrays.sort(result2);  // the outcome maybe not in the order
		assertEquals(true, Arrays.equals(result1, result2));
	}
	
}
