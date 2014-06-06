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
	static public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num.length<3) return res;
		quicksort(num,0,num.length);
		int target = 0;
		
		for(int i=0;i<num.length-2;i++)
		{
			int first, end;
			first = i+1;
			end = num.length-1;
			while(first<end)
				if(num[first]+num[i]+num[end]>target){
					end--;
				}
				else if(num[first]+num[i]+num[end]<target){
					first++;
				}	
				else{
					res.add(Arrays.asList(i,first,end));
					first++;
					end--;
				}
		}
		return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]={-4,1,2,2,3};
		
		System.out.println(threeSum(num));
	}

}
