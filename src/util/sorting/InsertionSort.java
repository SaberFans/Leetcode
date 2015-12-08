package util.sorting;


public class InsertionSort {
	/**
	 * Original Insertion Sort.
	 * Comparison times up to 
	 * @param input
	 */
	public void sort(int[] input) {
		if (input == null || input.length <= 1)
			return;

		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0 && input[j]>input[j-1]; j--) {
				// swap until it gets its final position.
				SortingUtil.swap(input, j-1, j);
			}
		}
	}
	
	/*
	 * Improvement to the original one.
	 */

	
}
