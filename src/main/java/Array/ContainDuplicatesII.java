package Array;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;

import util.junit.test.PopulateDataUtil;

public class ContainDuplicatesII {
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer,Integer> number_ticker = new HashMap<>();
		Set<Integer> numbers = number_ticker.keySet();
		for(int i=0;i<nums.length;i++){
			if(numbers.contains(nums[i])){
				if(Math.abs(number_ticker.get(nums[i])-i) <= k){
					return true;
				}
			}
			
			number_ticker.put(nums[i], i);
		
		}
		return false;
	}
	@Test
	public void function_test_ordinary() throws Exception {
		assertTrue(new ContainDuplicatesII().containsNearbyDuplicate(PopulateDataUtil.test_array_ints_1, 3));
		
	}
	@Test
	public void assert_false_test() throws Exception {
		assertFalse(new ContainDuplicatesII().containsNearbyDuplicate(PopulateDataUtil.test_array_ints_1, 1));
		assertFalse((new ContainDuplicatesII().containsNearbyDuplicate(PopulateDataUtil.getAscendingNums(10),10)));
	}

}
