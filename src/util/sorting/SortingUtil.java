package util.sorting;

public class SortingUtil {
	static public void swap(int[] input, int i, int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
}
