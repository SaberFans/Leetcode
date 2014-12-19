package Array;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Find min element in Rotated Array 
 * i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2
 */
public class FindMinInRotatedArray {
	
	public int findMin(int[] num) {
		
		if (num.length == 0)
			return Integer.MAX_VALUE;
		int min = num[0];
		
		for(int i=0;i<num.length-1;i++){
			if(num[i]>num[i+1])
				min = (min>num[i+1])?num[i+1]:min;
		}
		return min;
	}
	@Test
	public void test(){
		int min = findMin(new int[]{4,5,6,0,1,2});
		assertEquals(min,0);
	}
	@Test
	public void test1(){
		int min = findMin(new int[]{1,2,3,4});
		assertEquals(min,1);
	}
	@Test
	public void test2(){
		int min = findMin(new int[]{9,8});
		assertEquals(min,8);
	}

}
