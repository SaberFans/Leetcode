package util.sorting;

import java.util.List;

/**
 * Selection sort which has O(N*2) comparison time for all situation.
 * 
 * @author epttwxz
 * 
 */
public class SelectionSort {

	public <T> void sort(Comparable<T>[] elements) {
		for (int i = 0; i < elements.length - 1; i++) {
			Comparable<T> minValue = elements[i];
			int index = i;
			for (int j = i + 1; j < elements.length; j++) {
				if (elements[j].compareTo((T) minValue) < 0) {
					minValue = elements[j];
					index = j;
				}
			}
			exchange(elements, i, index);
		}
	}

	private <T> void exchange(Comparable<T>[] elements, int i, int j) {
		Comparable<T> i_obj = elements[i];
		Comparable<T> j_obj = elements[j];
		elements[i] = j_obj;
		elements[j] = i_obj;
	}
}
