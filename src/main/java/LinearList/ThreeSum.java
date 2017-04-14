package LinearList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
	// Wrong solution, can't narrow down the range by right strategy!
	static public List<List<Integer>> my3Sum(int[]num){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num.length<3) return res;
		quicksort(num,0,num.length);
		int target = 0;
		
		for(int i=1;i<num.length-1;i++)
		{
			int first, end;
			first = i-1;
			end = num.length-1;
			while(first<i&&i<end)
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
	// Right Strategy
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
					res.add(Arrays.asList(num[i],num[first],num[end]));
					first++;
					end--;
				}
		}
		/*for(int i=0;i<res.size();i++){
		    List<Integer> orig = res.get(i);
			for(int j=i+1;j<res.size();j++){
			    List<Integer> tmp  = res.get(j);
				if(tmp.get(0)==orig.get(0) &&orig.get(1)==tmp.get(1))
					res.remove(j);
			}
		}*/
		/**********************************
		/* Efficient way to remove duplicate tuple.
		 * check the implementation. 
		 * ********************************/
		HashSet hs = new HashSet();
		hs.addAll(res);
		res.clear();
		res.addAll(hs);
		return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]={-2,0,1,1,2};
		
		System.out.println(threeSum(num));
	}

}
