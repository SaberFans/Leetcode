package Array;

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

		for (int i = 0; i < A.length/2; i++) {
			int j = 0, k = A.length - 1;
			if (A[i] == 0){
				j++;
				continue;
			}
			if (A[A.length - i - 1] == 2){
				k--;
				continue;
			}
			if (A[i] == 2) {
				 swapArray(A, i, j);
				 k--;
			}

			if (A[A.length - i - 1] == 1) {
				swapArray(A, i, k);
				j++;
			}

		}
	}
	
	@Test
	public void test(){
		int input[]= {0,0,1,1,2,2};
		sortColors(input);
		assertArrayEquals(new int[]{0,0,1,1,2,2},  input);
	}
	@Test
	public void test2(){
		int input[]= {0,1,2,0,1};
		sortColors(input);
		assertArrayEquals(new int[]{0,0,1,1,2},  input);
	}
}
