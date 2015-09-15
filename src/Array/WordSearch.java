package Array;

import java.util.Arrays;

/**
 * Word Search
 *    Backtracking, DPS solution, remember to avoid redundant route path, by keep a visited array.
 * @author epttwxz
 *
 */
public class WordSearch {
	
	boolean check(char[][] grid, String word, int start, int i, int j, int m, int n){
		if(start ==word.length())
			return true;
		if(i==m || j==n)
			return false;

		if(word.charAt(start)==grid[i][j]){
			return check(grid, word, start+1, i+1, j, m, n) || check(grid, word, start+1, i, j+1, m, n);
		}
		else{
			return check(grid, word, start, i+1, j, m, n) || check(grid, word, start, i, j+1, m, n);
		}
		
	}
	 
	boolean exist(char[][] grid, String word) {
		char xx[][] = new char[][]{{'h', 'a', 'l','h', 'a', 'l','h', 'y', 'c', 't','y', 'a'},
		                            {'x', 'e', 'b','y', 'c', 't','x', 'e', 'l','h', 'a', 'l'},
		                            {'y', 'c', 't','h', 'a', 'l','h', 'a', 'x', 'e', 'x','l'},
		                            {'y', 'c', 't','h', 'a', 'l','h', 'a', 'x', 'e', 'x','l'},
		                            {'y', 'c', 't','h', 'a', 'l','h', 'a', 'x', 'e', 'x','l'}};
		word= "hycalhaxexl";
		boolean visited[][] = new boolean[xx.length][xx[0].length];
		
		return check(xx, word, 0, 0, 0, xx.length, xx[0].length);
	}

	public static void main(String[] args) {
		System.out.println(new WordSearch().exist(null, null));
	}

}
