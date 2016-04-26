package sorting.utest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import util.junit.test.PopulateDataUtil;
import util.sorting.SortingAlgorithm;
import util.sorting.SortingUtil;

public class SortingAlgorithmUnitTest {
	@Test
	public void ordinaryTest() throws Exception {
		int input[] = { 1, 3, 4, 3, 2, 1, 2, 4, 3, 1 };
		
		Integer[] inputObj_arr = { 1, 3, 4, 3, 2, 1, 2, 4, 3, 1 };
		
		int compareTo[] = Arrays.copyOf(input, input.length);

		int input_cp1[] = Arrays.copyOf(input, input.length);
		int input_cp2[] = Arrays.copyOf(input, input.length);
		int input_cp3[] = Arrays.copyOf(input, input.length);
		
		Integer input_cp4[] = Arrays.copyOf(inputObj_arr, input.length, Integer[].class);
		int input_cp5[] = Arrays.copyOf(input, input.length);

		Arrays.sort(compareTo);
		Arrays.sort(inputObj_arr);
		
		// practice bubble sort
		SortingAlgorithm.bubblesort(input_cp1);
		assertTrue(Arrays.equals(compareTo, input_cp1));

		// practice insertion sort
		SortingAlgorithm.insertSort(input_cp2);
		assertTrue(Arrays.equals(compareTo, input_cp2));

		// practice quick sort
		SortingAlgorithm.quicksort((input_cp3));
		assertTrue(Arrays.equals(compareTo, input_cp3));

		// practice selection sort
		SortingAlgorithm.selectSort(input_cp4);
		assertTrue(Arrays.equals(inputObj_arr, input_cp4));
		
		// practice merge sort
		SortingAlgorithm.mergesort(input_cp5);
		assertTrue(Arrays.equals(compareTo, input_cp5));
		
		
	}
	
	@Test
	public void randomInput() throws Exception {
		int[] input = PopulateDataUtil.getRandomData(1000, 100);
		Integer []inputObj_arr = PopulateDataUtil.getRandomDataObjs(1000, 100);
		
		int compareTo[] = Arrays.copyOf(input, input.length);

		int input_cp1[] = Arrays.copyOf(input, input.length);
		int input_cp2[] = Arrays.copyOf(input, input.length);
		int input_cp3[] = Arrays.copyOf(input, input.length);
		Integer input_cp4[] = Arrays.copyOf(inputObj_arr, input.length, Integer[].class);
		int input_cp5[] = Arrays.copyOf(input, input.length);

		// library sort
		Arrays.sort(compareTo);
		Arrays.sort(inputObj_arr);
		
		// practice bubble sort
		SortingAlgorithm.bubblesort(input_cp1);
		assertTrue(Arrays.equals(compareTo, input_cp1));

		// practice insertion sort
		SortingAlgorithm.insertSort(input_cp2);
		assertTrue(Arrays.equals(compareTo, input_cp2));

		// practice quick sort
		SortingAlgorithm.quicksort((input_cp3));
		assertTrue(Arrays.equals(compareTo, input_cp3));

		// practice select sort
		SortingAlgorithm.selectSort(input_cp4);
		assertTrue(Arrays.equals(inputObj_arr, input_cp4));
		
		// practice merge sort
		SortingAlgorithm.mergesort(input_cp5);
		assertTrue(Arrays.equals(compareTo, input_cp5));
	}
	
	/**
	 * One million big array test.
	 * used as time comparison as well.
	 * @throws Exception
	 */
	@Test
    public void qsort_stack_overflow_test() throws Exception{
        int[] big_array = PopulateDataUtil.getRandomData(1000000, 100);     // one million big array input will bring in StackOverflow.
        for(int test_occur = 0;test_occur<10;test_occur++) {
//			QuickSortUtil.quickSort(big_array, 0, big_array.length-1,
//          PopulateDataUtil.getAscendingNums(big_array.length));
        	/*SortingAlgorithm.bubblesort(big_array);
            assertTrue(SortingUtil.isAscending(big_array));*/
        }

    }
    
}
