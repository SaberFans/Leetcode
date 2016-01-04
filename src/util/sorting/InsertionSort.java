package util.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import util.junit.test.PopulateDataUtil;


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
	
	@Test
	public void testName() throws Exception {
		int []src = PopulateDataUtil.getRandomData(5, 10);
		int []head = {1,2,3};
		int target[] = new int[src.length+head.length];
		System.arraycopy(head, 0, target, 0, head.length);
		System.arraycopy(src, 0, target, head.length, src.length);
		pairInsertion(target);
		System.out.println(Arrays.toString(target));
	}
	
	@Test
	public void testPairInsert(){
		int arr[] = {1, 4,3,2, 7, 9,8};
		new InsertionSort().pairInsertion(arr);
	}
	
	public void pairInsertion(int[]input){
		int left = 0, right = input.length-1;
		int a[]	 = input;
		
		 /*
         * Skip the longest ascending sequence.
         */
        do {
            if (left >= right) {
                return;
            }
        } while (a[++left] >= a[left - 1]);

        /*
         * Every element from adjoining part plays the role
         * of sentinel, therefore this allows us to avoid the
         * left range check on each iteration. Moreover, we use
         * the more optimized algorithm, so called pair insertion
         * sort, which is faster (in the context of Quicksort)
         * than traditional implementation of insertion sort.
         */
        for (int k = left; ++left <= right; k = ++left) {
            int a1 = a[k], a2 = a[left];

            if (a1 < a2) {
                a2 = a1; a1 = a[left];
            }
            while (a1 < a[--k]) {
                a[k + 2] = a[k];
            }
            a[++k + 1] = a1;

            while (a2 < a[--k]) {
                a[k + 1] = a[k];
            }
            a[k + 1] = a2;
        }
        int last = a[right];

        while (last < a[--right]) {
            a[right + 1] = a[right];
        }
        a[right + 1] = last;
	}
	
}
