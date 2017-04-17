package _LeetcodeLoop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * created by yang on 15 Apr 2017
 */
public class _78Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> numSets = new ArrayList<>();
		if (nums != null) {
			subSetHelper(nums, 0, numSets, new ArrayList<Integer>());
		}
		return numSets;
	}
	
	private void subSetHelper(int[] nums, 
							  int startIndex, 
							  List<List<Integer>> numSets, 
							  List<Integer> set) {
		numSets.add(new ArrayList<>(set));
		for(int i=startIndex; i<nums.length; i++){
			set.add(nums[i]);
			subSetHelper(nums, i+1, numSets, set);
			set.remove(set.size()-1);	
		}
	}
	@Test
	public void test(){
		List<List<Integer>> listofLists = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		listofLists.add(new ArrayList<>(list));
		listofLists.add(Arrays.asList(0));
		listofLists.add(Arrays.asList(1));
		listofLists.add(Arrays.asList(2));
		listofLists.add(Arrays.asList(0,1));
		listofLists.add(Arrays.asList(0,2));
		listofLists.add(Arrays.asList(1,2));
		listofLists.add(Arrays.asList(0,1,2));
		System.out.println(listofLists);
		
		int[]nums = {0,1,2};
		List<List<Integer>> result = new _78Subsets().subsets(nums);
		System.out.println(result);
		System.out.println(listofLists.containsAll(result));
		
		
	}
	
}
