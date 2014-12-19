package DP;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * Unique Paths
 * Robot located at top-left corner, 
 * is trying to reach the bottom-right corner.
 * 
 * |X---------------|
 * |-*******--------|
 * |-------***------|
 * |---------******-|
 * |--------------*Y|
 * 
 * How many unique paths exist from X to Y
 */
public class FindUniquePath {
	
	/**
	 *  Two demensional Dynamic Programming
	 */
 
	public int uniquePaths(int m, int n) {
		int step [][] = new int[m][n];
		for(int[] a:step)
			Arrays.fill(a, 1);
		
		for(int i=1;i<m;i++)
			for(int j=1;j<n;j++){
				step [i][j] = step [i-1][j]+ step[i][j-1];
			}
		
		
		return step[m-1][n-1];
	}
	public void setOne(int[]A){
		
	}
	
	@Test
	public void test(){
		assertEquals(2, uniquePaths(2, 2));
	}
	
	@Test
	public void test1(){
		assertEquals(3, uniquePaths(2, 3));
	}
	
	@Test
	public void test2(){
		assertEquals(6, uniquePaths(3, 3));
	}

}
