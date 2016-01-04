package util.sorting;

/**
 * Selection sort which has O(N*2) comparison time for all situation.
 * @author epttwxz
 *
 */
public class SelectionSort {
	
	void sort(int[]arr){
		for(int i=0;i<arr.length-1;i++){
			int min = arr[i];
			int pos = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<min){
					pos = j;
					min = arr[j];
				}
			}
			SortingUtil.swap(arr, i, pos);
		}
	}
}
