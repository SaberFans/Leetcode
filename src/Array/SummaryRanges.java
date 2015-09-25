package Array;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import util.junit.test.PopulateDataUtil;

public class SummaryRanges {
	@Test
	public void boundary_test1(){
		List<String> res = new SummaryRanges().summaryRanges(PopulateDataUtil.empty_array_ints);
		List<String> match = Collections.emptyList();
		assertTrue(match.equals(res));
		
	}
	@Test
	public void boundary_test2(){
		List<String> res = new SummaryRanges().summaryRanges(PopulateDataUtil.one_array_int);
		List<String> match = Arrays.asList("1");
		assertTrue(match.equals(res));
	}
	@Test
	public void valid_test3(){
		List<String> res = new SummaryRanges().summaryRanges(PopulateDataUtil.getAscendingNums(5));
		List<String> match = Arrays.asList("1->5");
		assertTrue(match.equals(res));
	}
	@Test
	public void valid_test4(){
		List<String> res = new SummaryRanges().summaryRanges(PopulateDataUtil.getAllSameNums(10, 10));
		List<String> match = Arrays.asList("10");
		assertTrue(match.equals(res));
	}
	@Test
	public void valid_test5(){
		List<String> res = new SummaryRanges().summaryRanges(new int[]{1,2,4,6});
		List<String> match = Arrays.asList("1->2","4", "6");
		System.out.println(res);
		assertTrue(match.equals(res));
	}
	@Test
	public void valid_test7(){
		List<String> res = new SummaryRanges().summaryRanges(new int[]{1,2,4,5,6,8,10});
		System.out.println();
		List<String> match = Arrays.asList("1->2","4->6","8", "10");
		
		assertTrue(match.equals(res));
	}
	
	@Test
	public void valid_test6(){
		List<String> res = new SummaryRanges().summaryRanges(new int[]{1,2,4,6,7,8,10});
		System.out.println();
		List<String> match = Arrays.asList("1->2","4", "6->8", "10");
		
		assertTrue(match.equals(res));
	}
	@Test
	public void integer_overflow_test(){
		List<String> res = new SummaryRanges().summaryRanges(new int[]{-2147483648,-2147483647,2147483647});
		System.out.println();
		List<String> match = Arrays.asList("-2147483648->-2147483647","2147483647");
		
		assertTrue(match.equals(res));
	}
	public List<String> summaryRanges(int[] nums) {
		List<String> ranges = new ArrayList<>();
		if(nums==null || nums.length==0)
			return ranges;
		int start_num = nums[0];
		int end_num = start_num;
		
		for(int i=0;i<nums.length;i++){
			if(i==nums.length-1){
				if(nums[i]==end_num+1){
					ranges.add(start_num+"->"+nums[i]);
				}
				else{
					if(end_num!=nums[i]){
						if(start_num==end_num)
							ranges.add(""+start_num);
						else
							ranges.add(start_num+"->"+end_num);
					}
					ranges.add(""+nums[i]);
				}
			}
			else if(nums[i]>end_num+1){
				if(end_num==start_num){
					ranges.add(""+end_num);
				}
				else{
					ranges.add(start_num+"->"+end_num);
				}
				end_num = nums[i];
				start_num= nums[i];
			}
			else
				end_num = nums[i];
			
		}
		 
		return ranges;
	}
}
