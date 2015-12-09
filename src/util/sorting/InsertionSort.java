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
			for (int j = i; j > 0 && input[j]<input[j-1]; j--) {    /*** expensive exchange ***/
				// swap until it gets its final position.
				SortingUtil.swap(input, j-1, j);
			}
		}
	}

	/**
	 * Fast solution, which saves one assignment in the inner loop.
	 * @param input
	 */
	public void sort2(int[] input) {
		if (input == null || input.length <= 1)
			return;

		for (int i = 1; i < input.length; i++) {
			int j = i;
			int cmp = input[j];
			for (; j > 0 && cmp<input[j-1]; j--) {
				input[j] = input[j-1];
			}
			input[j] = cmp;
		}
	}
	
}
