package util.sorting;

import java.util.Arrays;

import org.junit.Test;

public class MergeSort {
	public final static MergeSort instance = new MergeSort();
	
	void sort(int A[]){
		if(A==null) return;
		int length = A.length;
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
		int auxilary[] = new int[high-low];
		for(int i=low, j=0; i<high ;i++,j++){
			auxilary[j] = A[i];
		}
		int r = low, t = mid;
		
		for(int i=low;i<high;){
			if(r==mid){
				while(t<high){
					A[i++] = auxilary[t++ -low];
				}
			}
			else if(t==high){
				while(r<mid){
					A[i++] = auxilary[r++ -low];
				}
			}
			else if(auxilary[r-low]> auxilary[t-low]){
				A[i++] = auxilary[t++ -low];
			}
			else{
				A[i++] = auxilary[r++ -low];
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
