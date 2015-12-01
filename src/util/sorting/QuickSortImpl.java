package util.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * One Pivot QuickSort, unstable sorting algorithm.
 * For stable sorting, check the Merge Sort.
 * @author epttwxz
 *
 */
public class QuickSortImpl {
	/**
	 * Quick sort wrapper to accept merely the array itself.
	 * 
	 * @param input
	 */
	void quicksort(int[] input) {
		if (input == null || input.length == 0)
			return;
		sort(input, 0, input.length - 1);
	}

	/**
	 * Quick sort main recursion stub.
	 * 
	 * @param input
	 * @param left
	 * @param right
	 */
	void sort(int[] input, int left, int right) {
		int pivot = getPartitionPos(input, left, right);
		if (pivot > left) {
			sort(input, left, pivot - 1);
		}
		if (pivot < right) {
			sort(input, pivot + 1, right);
		}
	}

	/**
	 * Partition operation to return the final index of the picked pivot.
	 * 
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
			if (input[left] <= pivotVal) {
				int tmp = input[left];
				input[left] = input[pivotPos];
				input[pivotPos] = tmp;

				pivotPos++;
			}

			left++;
		}
		// set the final position for the Pivot.
		int tmp = input[right];
		input[right] = input[pivotPos];
		input[pivotPos] = tmp;

		return pivotPos;
	}

	@Test
	public void testQS() throws Exception {
		int input[] = { 1, 3, 4, 3, 2, 1, 2, 4, 3, 1 };
		int input_copy[] = Arrays.copyOf(input, input.length);

		new QuickSortImpl().quicksort(input);
		Arrays.sort(input_copy);
		assertTrue(Arrays.equals(input, input_copy));
	}

	@Test
	public void testEmpty() throws Exception {
		int[] input = {};
		int input_copy[] = Arrays.copyOf(input, input.length);

		new QuickSortImpl().quicksort(input);
		Arrays.sort(input_copy);
		assertTrue(Arrays.equals(input, input_copy));
	}
	@Test
	public void testOneElem() throws Exception {
		int []input = {1};
		int input_copy[] = Arrays.copyOf(input, input.length);

		new QuickSortImpl().quicksort(input);
		Arrays.sort(input_copy);
		assertTrue(Arrays.equals(input, input_copy));
	}

}
