package Array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * __--Peak---__
 * 
 * Binary Solution
 *
 */
public class FindPeakElement {

	public int findPeakElement(int[] num) {
		int retInext = -1;
		if(num.length==0) return retInext;
		int max = Integer.MIN_VALUE;
		max = max<num[0]?num[0]:max;
		if(max ==num[0])	retInext = 0;
		max = max<num[num.length-1]?num[num.length-1]:max;
		if(max ==num[num.length-1]) retInext = num.length-1;
		
		for(int i=1;i<num.length-1;i++){
			if(num[i]>num[i-1]&&num[i]>num[i+1])
				if(num[i]>max){
					max = num[i];
					retInext = i;
				}
		}
		
		return retInext;
	}
	@Test
	public void test(){
		assertEquals(1, findPeakElement(new int[]{1,2}));
	}
	@Test
	public void test2(){
		assertEquals(2, findPeakElement(new int[]{0,1,3,2,1,2,2,1}));
	}
}
