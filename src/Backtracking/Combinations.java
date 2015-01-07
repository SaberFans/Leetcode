package Backtracking;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Combinations {

	/** recursive way to generate combinations
	 * @param combinations
	 * @param index
	 * @param n
	 * @param k
	 */
	void generateCombination(List<List<Integer>> combinations, int index, int n, int k) {
		if(k==0){
			return;
		}
		List<Integer> set = new ArrayList<Integer>();
		
		for(int i=index; i<n-k; i++){
			set.add(i);
		}
		combinations.add(set);
		generateCombination(combinations, index+1, n, k);
		
	}

	@Test
	public void test(){
		List<List<Integer>> lofsets = new ArrayList<>();
		
		 
		
		System.out.println(lofsets);
	}
	
	@Test
	public void test2(){
		
	}
	
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> lofsets = new ArrayList<>();

		return lofsets;
	}
}
