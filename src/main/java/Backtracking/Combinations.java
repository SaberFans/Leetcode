package Backtracking;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Combinations {

	/**
	 * Backtracking to generate combinations
	 * 
	 * @param combinations
	 * @param index
	 * @param n
	 * @param k
	 */
	void generateCombination(List<List<Integer>> combinations, List<Integer> set, int index,
			int n, int k) {
		if(set.size() ==k){
			// only add in the reference, not copy the value
			combinations.add(set);
			return;
		}
		for(int i=index; i<=n; i++){
			// Java, need to allocate another copy to work
			List<Integer> copyofset = new ArrayList<>(set);
			// this copyset gets reset every iteration
			copyofset.add(i);
			generateCombination(combinations, copyofset, i+1, n, k);
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
