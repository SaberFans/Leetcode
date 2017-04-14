package Array;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Sort arrays by input colors in the order red, white, and blue 
 * 0, 1, 2
 * represent R, W, B respectively.
 */
public class SortColors {
	public void swapArray(int A[], int i, int k) {
		int tmp = A[i];
		A[i] = A[k];
		A[k] = tmp;

	}
	
	public void sortColors(int[] A) {
		int j = 0, k = A.length-1;
		for(int i=0;i<=k;){
			if(A[i]==0){
				swapArray(A, i, j);
				i++;
				j++;
			}
			else if(A[i]==2){
				swapArray(A, i, k);
				k--;

			}
			else
				i++;
		}
		
	}
	
	@Test
	public void test(){
		int input[]= {0,0,1,1,2,2};
		sortColors(input);
		assertArrayEquals(new int[]{0,0,1,1,2,2},  input);
	}
	
	@Test
	public void test3(){
		int input[]={0,1,2,1,0,2,0};
		sortColors(input);
		assertArrayEquals(new int[]{0,0,0,1,1,2,2},input);
	}
	@Test
	public void test2(){
		int input[]= {0,2,2,1,2,0,1,1};
		sortColors(input);
		System.out.println(Arrays.toString(input));
		assertArrayEquals( (new int[]{0,0,1,1,1,2,2,2}),  input);
	}
}
