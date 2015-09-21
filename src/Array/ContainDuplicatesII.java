package Array;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import util.junit.test.PopulateDataUtil;

public class ContainDuplicatesII {
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer,Integer> number_ticker = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(number_ticker.containsKey(nums[i])){
				if(Math.abs(number_ticker.get(nums[i])-i) <= k)
					return true;
				else
					number_ticker.put(nums[i], i);
			}
			else
				number_ticker.put(nums[i], i);
		}
		return false;
	}
	@Test
	public void function_test_ordinary() throws Exception {
		assertTrue(new ContainDuplicatesII().containsNearbyDuplicate(PopulateDataUtil.test_array_ints, 3));
		
	}
	@Test
	public void assert_false_test() throws Exception {
		assertFalse(new ContainDuplicatesII().containsNearbyDuplicate(PopulateDataUtil.test_array_ints, 1));
		assertFalse((new ContainDuplicatesII().containsNearbyDuplicate(PopulateDataUtil.getAscendingNums(10),10)));
	}

}
