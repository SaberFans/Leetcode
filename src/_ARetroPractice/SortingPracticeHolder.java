package _ARetroPractice;

import java.util.Arrays;

/**
 * Created by epttwxz on 05/12/16.
 */
public class SortingPracticeHolder {
    private static int findPivot(int arr[], int start, int end){
        int pivot = end;
        end --;
        while(start<=end){
            while(end>=0 && arr[end--]>=arr[pivot]);
            while(start<=pivot&& arr[start++]<=arr[pivot]);
            end++;
            start--;
            if(start>=end)
                break;
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }

        int tmp = arr[start];
        arr[start] = arr[pivot];
        arr[pivot] = tmp;
        return start;
    }

    public static void quicksort(int[]arr, int start, int end){
        if(start<end){
            int pivot = findPivot(arr, start, end);
            quicksort(arr, start, pivot-1);
            quicksort(arr, pivot+1, end);
        }
    }
    private void merge(int[]arr, int []copy, int left, int mid, int end){

    }

    public static void mergesortImpl(int[]arr, int []copy, int start, int end){
        if(end-start<=1)
            return;
        int mid = (start+end)/2;
        mergesortImpl(arr, copy, start, mid);
        mergesortImpl(arr, copy, mid, end);

    }
    public static void mergesort(int arr[]){
        int []copy = new int[arr.length];

    }
    public static void main(String[] args) {
        int[] input = new int[]{1,23,14,23,421,41,31,532,213,21,53,312,21,532,1,631,123,54,2,213};
        int[] referinput = Arrays.copyOf(input, input.length);

        quicksort(input, 0, input.length-1);
        System.out.println(Arrays.toString(input));
        Arrays.sort(referinput);
        System.out.println(Arrays.toString(referinput));

        String[] aempty = new String[]{null, "","ab"};
        for(String str: aempty){
            if(str!=null &&!str.trim().isEmpty())
                System.out.println(str);
        }
    }
}
