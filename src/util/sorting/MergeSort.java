package util.sorting;

import java.util.Arrays;

import org.junit.Test;

public class MergeSort {
	public final static MergeSort instance = new MergeSort();
	private static int []auxilary;
	void sort(int A[]){
		if(A==null) return;
		int length = A.length;
		auxilary = new int[length];
		System.arraycopy(A, 0, auxilary, 0, length);

		sort(A, 0, length);
		
	}
	/**
	 * Merge Sort top-down strategy.
	 * @param A
	 * @param low
	 * @param high
	 */
	void sort(int A[], int low, int high){
		if(high-low<=1)
			return;
		int mid = (low+high)/2;
		
		sort(A, low, mid);
		sort(A, mid, high);
		merge(A, low, mid, high);
		
		
	}
	/**
	 * Merge method to merge two sorted sub-array.
	 * 
	 * @param A input array.
	 * @param low  first sub-array start offset
	 * @param mid  second sub-array start offset
	 * @param high right boundary for the current merge
	 */
	void merge(int A[], int low, int mid, int high){
		
		for(int i=low; i<high ;i++){
			auxilary[i] = A[i];
		}
		int r = low, t = mid;
		
		for(int i=low;i<high;){
			if(r==mid){
				while(t<high){
					A[i++] = auxilary[t++];
				}
			}
			else if(t==high){
				while(r<mid){
					A[i++] = auxilary[r++];
				}
			}
			else if(auxilary[r]> auxilary[t]){
				A[i++] = auxilary[t++];
			}
			else{
				A[i++] = auxilary[r++];
			}
		}
	}
	@Test
	public void test(){
		int[]A = {3,2,1};
		new MergeSort().sort(A);
		System.out.println(Arrays.toString(A));
	}
}
