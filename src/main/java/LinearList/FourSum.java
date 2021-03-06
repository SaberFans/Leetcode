package LinearList;

import java.util.*;

public class FourSum {
	static int partition(int[]num,int first,int end){
		int pivot = first;
		for(int i=first;i<end-1;i++){
			if(num[i]<num[end-1]){
				int tmp = num[i];
				num[i] = num[pivot];
				num[pivot] = tmp;
				pivot++;
			}
		}
		int tmp = num[end-1];
		num[end-1] = num[pivot];
		num[pivot] = tmp;
		return pivot;
	}
	static void quicksort(int[]num,int first, int end){
		if(first<end-1){
			int pivot = partition(num,first,end);
			quicksort(num,first,pivot);
			quicksort(num,pivot+1,end);
		}
	}
	static public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(num.length<4) return res;
		quicksort(num,0,num.length);
        	for(int i=0;i<num.length-3;i++){
        		for(int j=i+1;j<num.length-2;j++){
	        		int first = j+1, end =num.length-1;
	        		while(first<end){
	        			int sum = num[first]+num[i]+num[j]+num[end];
	        			if(sum>target){
	        				end--;
	        			}
	        			else if(sum<target){
	        				first++;
	        			}
	        			else{
	        				res.add(Arrays.asList(num[i],num[j],num[first],num[end]));
	        				first++;
	        				end--;
	        				//return res;
	        			}
	        		}
        		}
        	}
        	// 1.
        	// HashSet hs = new HashSet();
        	// hs.addAll(res);
        	// res.clear();
        	// res.addAll(hs);
        	HashMap map = new HashMap();
        	Object PRESENT = new Object();
	        /* 2
	         * ConcurrentlyModificationException
	        for(List a: res){
	        	if(map.put(a, PRESENT)!=null)
	        		res.remove(a);
	        }*/
	        Iterator it = res.iterator();
	        while(it.hasNext()){
	            if(map.put(it.next(),PRESENT)!=null)
	                it.remove();
	        }
	        	return res;
	}				
	public static void main(String[] args) {
		int[]num= {1, 0, -1, 0, -2, 2};
		List a =fourSum(num,0);
		System.out.println(a);
	}
}
