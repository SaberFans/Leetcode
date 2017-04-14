package LinearList;

import java.util.ArrayList;

public class SearchInRotatedSortedArray {
	static int search_NoDup(int []A,int search){
		int n = A.length;
		int index = -1;
		if(n==0)return index;
		int left=0, right=n-1;;
		while(left<=right){
			int mid = left+(right-left)/2;
			if(A[mid]==search)
				return mid;
			// ascending, no dup
			if(A[right]>=A[mid]){
				if(A[right]>=search&&A[mid]<search)
					left=mid+1;
				else
					right=mid-1;
			}
			else{
				if(A[mid]>search&&search>=A[left])
					right=mid-1;
				else
					left=mid+1;
			}
		}
		return index;
	}
	static int search_Dup(int []A,int search){
		int n = A.length;
		if(n==0)return -1;
		int left=0, right=n-1;
		while(left<=right){
			int mid = left+(right-left)/2;
			if(A[mid]==search)
				return mid;
			if(A[right]==A[mid])
				right--;
				//left++;
			else if(A[right]>A[mid]){
				if(A[mid]<search&&search<=A[right])
					left=mid+1;
				else{
					right=mid-1;
				}
			}
			else{
				if(A[left]<=search&&search<A[mid])
					right=mid-1;
				else
					left=mid+1;
			}
		}
		return -1;
	}
	public static void main(String[]a){
 		int[]A = {1,2,3,-4,-4,-3,-2};
 		// test #1, mid at front
 		int[]B = {1,1,1,1,3,1,1};
 		// test #2, mid at end
 		int[]C = {1,3,1,1,1};
 		// int[]A={3,1,1};
 		ArrayList<Integer> set = new ArrayList<Integer>();
 		for(int a1:B){
 			int index = search_Dup(C, a1);
 			set.add(index);
 		}
 		for(int a1:set){
 			System.out.println(a1);
 		}
 	}   

}
