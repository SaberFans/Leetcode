package util.sorting;


public class SortingAlgorithm {
	public static void quicksort(int[] input){
		new QuickSortImpl().sort(input, 0, input.length-1);
	}
	
}
