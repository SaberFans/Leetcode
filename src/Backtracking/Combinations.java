package Backtracking;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Combinations {

	/**
	 * Backtracking way to generate combinations
	 * 
	 * @param combinations
	 * @param index
	 * @param n
	 * @param k
	 */
	void generateCombination(List<List<Integer>> combinations, List<Integer> set, int index,
			int n, int k) {
		if(set.size() ==k){
			combinations.add(set);
			return;
		}
		for(int i=index; i<=n; i++){
			 
			set.add(i);
			generateCombination(combinations, set, i+1, n, k);
			set.remove(set.size()-1);
		}
	}

	@Test
	public void test() {
		List<List<Integer>> lofsets = new ArrayList<>();
		lofsets = combine(4, 3);
		System.out.println(lofsets);
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> lofsets = new ArrayList<>();
		List<Integer> set = new ArrayList<>();

		generateCombination(lofsets, set, 1, n, k);
		
		return lofsets;
	}
}
