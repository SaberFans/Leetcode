package LinearList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	static int partition(int[]num, int start,int end){
		int index=end-1;
		int pindex=start;
		for(int i=start;i<index;i++){
			if(num[i]<num[index]){
				int tmp = num[i];
				num[i]=num[pindex];
				num[pindex] = tmp;
				pindex++;
			}
		}
		int tmp = num[pindex];
		num[pindex] = num[index];
		num[index] = tmp;
		return pindex;
	}
	static void quicksort(int[]num,int start,int end){
		if(start<end-1){
			int k = partition(num,start,end);
			quicksort(num,start,k);
			quicksort(num,k+1,end);
		}
	}
	public List<List<Integer>> threeSum(int[] num) {
		quicksort(num,0,num.length);
		System.out.println(Arrays.toString(num));
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]={2,1};
		quicksort(num, 0, num.length);
		System.out.println(Arrays.toString(num));
	}

}
