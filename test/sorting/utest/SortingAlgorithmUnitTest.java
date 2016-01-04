package sorting.utest;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import util.junit.test.PopulateDataUtil;
import util.sorting.SortingAlgorithm;

public class SortingAlgorithmUnitTest {
	@Test
	public void test() throws Exception {
		int input[] = { 1, 3, 4, 3, 2, 1, 2, 4, 3, 1 };
		int compareTo[] = Arrays.copyOf(input, input.length);

		int input_cp1[] = Arrays.copyOf(input, input.length);
		int input_cp2[] = Arrays.copyOf(input, input.length);
		int input_cp3[] = Arrays.copyOf(input, input.length);
		int input_cp4[] = Arrays.copyOf(input, input.length);
		int input_cp5[] = Arrays.copyOf(input, input.length);

		Arrays.sort(compareTo);

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
		assertTrue(Arrays.equals(compareTo, input_cp4));
		
		// practice merge sort
		SortingAlgorithm.mergesort(input_cp5);
		assertTrue(Arrays.equals(compareTo, input_cp5));
	}

	@Test
	public void randomInput() throws Exception {
		int[] input = PopulateDataUtil.getRandomData(1000, 100);
		int compareTo[] = Arrays.copyOf(input, input.length);

		int input_cp1[] = Arrays.copyOf(input, input.length);
		int input_cp2[] = Arrays.copyOf(input, input.length);
		int input_cp3[] = Arrays.copyOf(input, input.length);
		int input_cp4[] = Arrays.copyOf(input, input.length);
		int input_cp5[] = Arrays.copyOf(input, input.length);

		// library sort
		Arrays.sort(compareTo);

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
		assertTrue(Arrays.equals(compareTo, input_cp4));
		
		// practice merge sort
		SortingAlgorithm.mergesort(input_cp5);
		assertTrue(Arrays.equals(compareTo, input_cp5));
	}
}
