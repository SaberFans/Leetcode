package LinearList;

import java.util.Arrays;

public class ThreeSumClosest {
	static int partition(int[]sum,int first,int end){
		int pivot = end-1;
		int index = first;
		for(int i=first;i<end;i++){
			if(sum[i]<sum[pivot]){
				int tmp = sum[i];
				sum[i]=sum[index];
				sum[index]=tmp;
				index++;
			}
		}
		int tmp = sum[pivot];
		sum[pivot]=sum[index];
		sum[index]=tmp;
		pivot = index;
		return pivot;
	}
	static void quicksort(int[]sum,int first,int end){
		if(first<end){
			int pivot = partition(sum,first,end);
			quicksort(sum,first,pivot);
			quicksort(sum,pivot+1,end);
		}
	}
	static public int threeSumClosest(int[] num, int target) {
        int max=Integer.MAX_VALUE;
        quicksort(num,0,num.length);
        int res = max;
        for(int i=0;i<num.length-2;i++){
        	int first = i+1, end = num.length-1;
        	while(first<end){
        		int sum = num[i]+num[first]+num[end];
        		int gap = Math.abs(sum-target);
        		if(gap<max){
        			max = gap;
        			res = sum;
        		}
        		if(sum>target){
        			end--;
        		}
        		if(sum==target){
        			return target;
        		}
        		if(sum<target){
        			first++;
        		}
        		
        	}
        }
		return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]sum ={-1,2,1,4};
		System.out.println(threeSumClosest(sum,1));
		
	}
	

}
