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
		//System.arraycopy(A, 0, auxilary, 0, length);
		auxilary = A.clone();

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
		// copy original array into the axuliary array
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
	
	/*******************************************************************
     *  Version of solution that eliminates the copy into auxiliary 
     *  array.
     *******************************************************************/
	void sortX_entry(int[]src){
		int[] dis = src.clone();
		sortX(dis, src, 0, src.length);
	}
	void sortX(int[] src, int[] dist, int start, int end){
		if(start+1>=end) return;
		
		int mid = (start+end)/2;
		
		sortX(dist, src, start, mid);
		sortX(dist, src, mid+1, end);
		mergeX(src, dist, start, mid, end);
		
	}
	void mergeX(int[]src, int[]dis, int start, int mid, int end){
		int low1 = start, low2 = mid+1;
		for(int i= start;i<end;i++){
			if(low1>mid){
				dis[i] = src[low2++];
			}
			else if(low2>=end){
				dis[i] = src[low1++];
			}
			else if(src[low1]>src[low2]){
				dis[i] = src[low2++];
			}
			else
				dis[i] = src[low1++];
		}
	}
	
	
	@Test
	public void test(){
		int[]A = {3,2,3,3,1};
		new MergeSort().sortX_entry(A);
		System.out.println(Arrays.toString(A));
	}
}
