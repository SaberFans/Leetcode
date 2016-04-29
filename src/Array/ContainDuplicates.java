package Array;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	@Test
	public void union_Generics_test() throws Exception {
		this.testName(Arrays.asList(new Date[]{new Date()}));
		Set<Integer> integers = new HashSet<>(Arrays.asList(new Integer[]{1,2}));
		Number number_1 = new Integer(1);
		Number number_2 = new Integer(2);
		
		Set<Number> numbers = new HashSet<>(Arrays.asList(number_1, number_2));
		Set<Double> doubles = new HashSet<>(Arrays.asList(new Double(1), new Double(4)));
		numbers = this.<Number>union(doubles, integers);
		System.out.println(numbers);
			
	}
	
	public <T> Set<T> union(Set<? extends T> input1, Set<? extends T> input2){
		Set<T> union= new HashSet<T>();
		union.addAll(input1);
		union.addAll(input2);
		return union;
	}
	
	public <T extends Date> void  testName(List<? extends T> input) throws Exception {
		System.out.println(input);
		
		System.out.println(input);
		
		
	}
}
