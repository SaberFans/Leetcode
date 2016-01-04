package util.sorting;

class BubbleSort {
	
	void sort(int []arr){
		if(arr==null || arr.length==0)
			return;
		bubbleSort(arr, 0, arr.length-1);
	}
	
	void bubbleSort(int []arr, int start, int end){
		boolean swapped = true;
		while(swapped){
			swapped = false;
			for(int i=start;i<end;i++){
				if(arr[i]>arr[i+1]){
					SortingUtil.swap(arr, i, i+1);
					swapped = true;
				}
			}
		}
	}
	
	void bubbleSortOptimized(int[]arr, int start, int end){
		boolean sorted = false;
		while(!sorted){
			for(int i=1;i<end;i++){
				if(arr[i]<arr[i+1]){
					SortingUtil.swap(arr, i, i+1);
					sorted = false;
				}
			}
			end--;          // avoid looking at the last n-1 element for n-th pass.
		}
	}
	
}
