package util.sorting;

import static org.junit.Assert.*;
import static util.sorting.SortingUtil.swap;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import util.junit.test.PopulateDataUtil;

/**
 * One Pivot QuickSort, unstable sorting algorithm.
 * For stable sorting, check the Merge Sort.
 * 
 * Note: QS not suitable for almost sorted sequence, as it will take a lot meaningless comparison/exchange 
 * in partation when the chosen pivot is almost the least element.
 * And for the situation which has constant number of variants, use the 3 way partition mechanism, as it will
 * reduce a lot of data exchange.
 * 
 * @author epttwxz
 *
 */
public class QuickSortImpl {

	public static final int TWO_WAY = 1;
	public static final int THREE_WAY = 2;
	
	public final static QuickSortImpl instance = new QuickSortImpl();
	private static final int CUTOFF_VALUE = 15;
	
	/**
	 * Quick sort wrapper to accept merely the array itself.
	 * 
	 * @param input
	 * @param partition 
	 */
	void quicksort(int[] input, int partition) {
		if (input == null || input.length == 0)
			return;
		if(partition==TWO_WAY)
			sort(input, 0, input.length - 1);
		if(partition==THREE_WAY)
			sortThreeWay(input, 0, input.length - 1);
	}
	
	void insertionSortOP(int input[], int start, int end){
		for(int r=start+1;r<=end;r++){
			int s = r;
			int copyVal = input[s];
			while(s>start &&input[s]<input[s-1]){
				input[s] = input[s-1];
				s--;
			}
			input[s]= copyVal;
			
		}
	}
	void insertionSort(int input[],int start, int end){
		for(int r=start+1;r<=end;r++){
			for(int s=r;s>start&&input[s]<input[s-1];s--){
				swap(input, s, s-1);
			}
		}
	}
	/**
	 * Quick sort main recursion stub.
	 * 
	 * @param input
	 * @param left
	 * @param right
	 */
	void sort(int[] input, int left, int right) {
		if(right-left<CUTOFF_VALUE){
			insertionSortOP(input, left, right);
		}
		
		int pivot = getPartitionPos(input, left, right);
		
		// exit if sub-array's size >1 
		if (pivot > left) {
			sort(input, left, pivot - 1);
		}
		if (pivot < right) {
			sort(input, pivot + 1, right);
		}
	}
	
	void sortThreeWay(int[] input, int left, int right){
		int pivot = threeWayParitionPost(input, left, right);
		if (pivot > left) {
			sort(input, left, pivot - 1);
		}
		if (pivot < right) {
			sort(input, pivot + 1, right);
		}
	}
	@Test
	public void sortOrg(){
		int arr[] = new int[]{1,1,4,3,2,1};
		QuickSortImpl.instance.sort_original(arr, 0, 5);
		Assert.assertTrue(SortingUtil.isAscending(arr));
		
	}
	@Test
	public void sortOptimized() throws Exception {
		int arr[] = new int[]{1,1,4,3,2,1};
		QuickSortImpl.instance.sort(arr, 0, 5);
		Assert.assertTrue(SortingUtil.isAscending(arr));
	}
	/**
	 * Original Quick Sort which uses two passes.
	 * And skip the situation for many duplicates situation.
	 * @param input
	 * @param i
	 * @param j
	 */
	void sort_original(int []input, int i, int j){
		if(i>=j || input== null|| input.length==0)
			return;
		int pivot = getPartionPos2P(input, i,j);
		sort_original(input, i, pivot-1);
		sort_original(input, pivot+1, j);
	}
	
	/**
	 * Original Partition from Algorithms, 4th, p291.
	 * Two pass : from L to R, from R to L.
	 * @param input
	 * @param lo
	 * @param hi
	 * @return
	 */
	int getPartionPos2P(int input[], int lo, int hi){
		int pivot = lo;
		int i = lo, j = hi+1;
		while(true){
			// to notice, it's best not to stop for the equal to situation,
			// which could be quadratic computation for a input with constant small number of distinct values! 
			while(input[++i]<input[pivot])	if(i==hi) break;
			while(input[--j]>input[pivot]);	//if(j==lo) break;
			
			if(i>=j) break;
			swap(input, i, j);
		}
		
		swap(input, j, lo);
		pivot = j;
		return pivot;
	}
	
	/**
	 * Ordinary partition operation to return the final index of the picked pivot.
	 * One pass approach.
	 * @param input
	 * @param left
	 * @param right
	 * @return final position for the pivot
	 */
	int getPartitionPos(int[] input, int left, int right) {
		// simple pivot pick strategy, can optimize this by choosing the median
		// of first/last/mid elems.
		int pivotVal = input[right];

		int pivotPos = left;
		while (left < right) {
			if (input[left] < pivotVal) {   // skip the equal to case.
				swap(input, left, pivotPos++);
			}

			left++;
		}
		// set the final position for the Pivot.
		int tmp = input[right];
		input[right] = input[pivotPos];
		input[pivotPos] = tmp;

		return pivotPos;
	}
	
	/**
	 * Three way partition to reduce the duplicates case.
	 * @param input
	 * @param low
	 * @param high
	 * @return
	 */
	int threeWayParitionPost(int input[], int low, int high){
		
		int pivotVal = input[high];
		int pivotPos = low;
		int k = high;  
		while(low<high){
			if(input[low]>pivotVal)
				swap(input, low, --high);
			else if(input[low] < pivotVal){
				swap(input, low++, pivotPos++);
			}
			else{
				low++;
			}
		}
		swap(input, pivotPos, k);
		
		return pivotPos;
	}
	
	@Test
	public void testQS() throws Exception {
		int input[] = { 1, 1, 3, 4, 3, 2, 1, 2, 4, 3, 1 };
		int compareTo[] = Arrays.copyOf(input, input.length);
		
		int input_cp1[] = Arrays.copyOf(input, input.length);
		
		int input_cp2[] = Arrays.copyOf(input, input.length);
		
		int input_cp3[] = Arrays.copyOf(input, input.length);
		
		Arrays.sort(compareTo);
		new QuickSortImpl().quicksort(input_cp1, QuickSortImpl.TWO_WAY);
		assertTrue(Arrays.equals(compareTo, input_cp1));
		
		new QuickSortImpl().quicksort(input_cp2, QuickSortImpl.THREE_WAY);
		assertTrue(Arrays.equals(compareTo, input_cp2));
		
		instance.sort_original(input_cp3, 0, input.length-1);
		assertTrue(Arrays.equals(compareTo, input_cp3));
		
	}

	@Test
	public void testEmpty() throws Exception {
		int[] input = {};
		int compareTo[] = Arrays.copyOf(input, input.length);
		
		int input_cp1[] = Arrays.copyOf(input, input.length);
		
		int input_cp2[] = Arrays.copyOf(input, input.length);
		
		Arrays.sort(compareTo);
		new QuickSortImpl().quicksort(input_cp1, QuickSortImpl.TWO_WAY);
		assertTrue(Arrays.equals(compareTo, input_cp1));
		
		new QuickSortImpl().quicksort(input_cp2, QuickSortImpl.THREE_WAY);
		assertTrue(Arrays.equals(compareTo, input_cp2));
	}
	@Test
	public void testOneElem() throws Exception {
		int []input = {1};
		int compareTo[] = Arrays.copyOf(input, input.length);
		
		int input_cp1[] = Arrays.copyOf(input, input.length);
		
		int input_cp2[] = Arrays.copyOf(input, input.length);
		
		Arrays.sort(compareTo);
		new QuickSortImpl().quicksort(input_cp1, QuickSortImpl.TWO_WAY);
		assertTrue(Arrays.equals(compareTo, input_cp1));
		
		new QuickSortImpl().quicksort(input_cp2, QuickSortImpl.THREE_WAY);
		assertTrue(Arrays.equals(compareTo, input_cp2));
	}
	
	@Test
	public void randomInput() throws Exception {
		int []input = PopulateDataUtil.getRandomData(1000, 100);
		int compareTo[] = Arrays.copyOf(input, input.length);
		
		int input_cp1[] = Arrays.copyOf(input, input.length);
		
		int input_cp2[] = Arrays.copyOf(input, input.length);
		
		int input_cp3[] = Arrays.copyOf(input, input.length);
		
		Arrays.sort(compareTo);
		
		instance.quicksort(input_cp1, QuickSortImpl.TWO_WAY);
		assertTrue(Arrays.equals(compareTo, input_cp1));
		
		instance.quicksort(input_cp2, QuickSortImpl.THREE_WAY);
		assertTrue(Arrays.equals(compareTo, input_cp2));
		
		
		instance.sort_original(input_cp3, 0, input.length-1);
		assertTrue(Arrays.equals(compareTo, input_cp3));
	}

}
