package Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Gray Code stands for a successive values which differ only in one bit Given n
 * = 2, return [0,1,3,2] 0 - 00 1 - 01 3 - 11 2 - 10
 */
public class GrayCode {
	
	void generateGrayCode(int grayvalue, boolean mark[], HashSet<Integer> checker, List<Integer> graynums, int size, int n) {
		if(checker.size()==size)
			return;
        for (int i = 0; i < n; i++) {
        	int diff = (int) Math.pow(2, i);
        	int next;
        	// if the digit is 0
            if(mark[n-1-i]==false){
            	next = grayvalue+diff;
            	if(!checker.contains(next)&& next<size){
            		graynums.add(next);
            		mark[n-1-i]=true;
            		checker.add(next);
            		generateGrayCode(next, mark, checker, graynums, size, n);
            	}
            }
            // if the digit is 0
            else{
            	next = grayvalue -diff;
            	if(!checker.contains(next)&& next>=0){
            		graynums.add(next);
            		checker.add(next);
            		mark[n-1-i] = false;
            		generateGrayCode(next, mark, checker, graynums, size, n);
            	}
            }
        }
    }

	public List<Integer> grayCode(int n) {
		List<Integer> graynums = new ArrayList<>();
		HashSet<Integer> set = new HashSet<Integer>();
		graynums.add(0);
		set.add(0);
		boolean checker[] = new boolean[n];
		Arrays.fill(checker, false);
		
		
		generateGrayCode(0, checker, set, graynums, (int) Math.pow(2, n), n);

		return graynums;
	}

	@Test
	public void test() {
		System.out.println(grayCode(0).toString());
	}

	@Test
	public void test2() {

	}

}
