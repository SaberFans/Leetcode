package _ARetroPractice;

import java.util.Arrays;

/**
 * Created by yang on 2016/12/4.
 */
public class SortingPractice {
    public static void selectionsort(int[]arr){
        for(int i=0;i<arr.length;i++){
            int curMin = arr[i];
            int curMinIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<curMin) {
                    curMinIndex = j;
                    curMin = arr[j];
                }
            }
            int swap = arr[i];
            arr[i] = arr[curMinIndex];
            arr[curMinIndex] = swap;
        }
    }
    public static void bubblesort(int[]arr){
        boolean issorted = false;
        while(!issorted){
            issorted = true;
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]) {
                    issorted = false;
                    int swap = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = swap;
                }
            }
        }
    }
    public static void insertionsort(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            int j = i+1;
            while(j>0){
                if(arr[j]>=arr[j-1])
                    break;
                else{
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
                j--;
            }
        }
    }
    static private int getNextPivotIndex(int[] arr, int lo, int hi, int pivot){

        hi = hi-1;
        while(true) {
            while (hi >= 0 && arr[hi--] >= arr[pivot]) ;
            while (lo<=pivot && arr[lo++]<=arr[pivot]);
            lo--;
            hi++;
            if(lo>=hi) {
                break;
            }
            else {
                int tmp = arr[lo];
                arr[lo] = arr[hi];
                arr[hi] = tmp;
            }
            System.out.println(Arrays.toString(arr));
            System.out.println(lo+" "+hi+" "+pivot);
        }

        // swap left and pivot
        int tmp = arr[pivot];
        arr[pivot] = arr[lo];
        arr[lo] = tmp;
        return lo;
    }
    static private void sortinpartition(int[] arr, int lo, int hi, int pivot){
        if(lo<hi){
            int newPivot = getNextPivotIndex(arr, lo, hi, pivot);

            sortinpartition(arr, lo, newPivot-1, newPivot-1);
            sortinpartition(arr, newPivot+1, hi, hi);
        }
    }
    public static void quicksort(int[]arr){
        sortinpartition(arr, 0, arr.length-1,  arr.length-1);
    }

    private static void merge(int[]arr, int start, int mid, int end, int[]copy){
        int firstIndex = start;
        int startIndex = start;
        int midIndex = mid;
        while(startIndex<mid || midIndex<end ){
            if(startIndex<mid && midIndex<end){
                if(arr[startIndex]>arr[midIndex])
                    copy[firstIndex++] = arr[midIndex++];
                else
                    copy[firstIndex++] = arr[startIndex++];
            }
            else if(startIndex<mid){
                copy[firstIndex++] = arr[startIndex++];
            }
            else{
                copy[firstIndex++] = arr[midIndex++];
            }
        }
        // copy back to arr
        for(int i=start;i<end;i++)
            arr[i] = copy[i];
    }

    private static void mergesortImpl(int[]arr, int start, int end, int[]copy){
        if(end-start<=1)
            return;
        int mid = start+(end-start)/2;
        mergesortImpl(arr, start, mid, copy);
        mergesortImpl(arr, mid, end, copy);
        merge(arr, start, mid, end, copy);
    }
    public static void mergesort(int[]arr){
        int copy[] = Arrays.copyOf(arr, arr.length);
        mergesortImpl(arr, 0, arr.length, copy);
    }
    public static void main(String[] args) {
//        int[] values= new int[]{23,2,3,5,1,5,241,5,12,4,51,643,134,1,3,41,5,6};
        int[] values= new int[]{1,1,1,1};
//        int[] values= new int[]{5,5,5};
        int[] target = Arrays.copyOf(values, values.length);
        mergesort(values);
        System.out.println(Arrays.toString(values));
        Arrays.sort(target);
        System.out.println(Arrays.toString(target));
    }
}