package Array;


import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import util.junit.test.PopulateDataUtil;

public class ContainDuplicates {
	public boolean containsDuplicate(int[] nums) {
		boolean hasDups = false;
		HashSet<Integer> hashSet = new HashSet<>();
		for(int num: nums){
			if(hashSet.contains(num))
				return true;
			else
				hashSet.add(num);
		}
		return hasDups;
	}
	@Test
	public void test(){
		assertFalse(new ContainDuplicates().containsDuplicate(PopulateDataUtil.getAscendingNums(10)));
	}
	@Test
	public void testAllSameValue() throws Exception {
		assertTrue("Didn't pass the all same value test.", new ContainDuplicates().containsDuplicate(PopulateDataUtil.getAllSameNums(10, 5)));
	}


}
