package Array;

import java.util.Arrays;


/**
 * Word Search
 *    Backtracking, DPS solution, remember to avoid redundant route path, by keep a visited array.
 * @author epttwxz
 *
 */
public class WordSearch {
	
	boolean check(char[][] grid, String word, int start, int i, int j, int m, int n, boolean[][] visited){
		
		if(start ==word.length())
			return true;
		if(i==m || j==n || i<0 ||j<0){
			return false;
		}
		if(visited[i][j])
			return false;
		
		
		if(word.charAt(start)==grid[i][j]){
			start++;
			visited[i][j] = true;
		} 
		else{
			
//			for(boolean[] a:visited)
//				Arrays.fill(a, false);
			return false;
		}
		// somehow to remove visited flag...for each direction...
		return check(grid, word, start, i+1, j, m, n, visited) 
				|| check(grid, word, start, i, j+1, m, n, visited)
				|| check(grid, word, start, i-1, j, m, n, visited)
				|| check(grid, word, start, i, j-1, m, n, visited);
		
	}
	 
	boolean exist(char[][] grid, String word) {
		char xx[][] = new char[][] { 
									{ 'b', 'z','b', 'z' }, 
									{ 'x', 'b','c', 'x'},
									{ 'c', 'z','a', 'z' } };
		word= "bcb";
		boolean visited[][] = new boolean[xx.length][xx[0].length];

		return check(xx, word, 0, 0, 0, xx.length, xx[0].length, visited);
	}

	public static void main(String[] args) {
		
		System.out.println(new WordSearch().exist(null, null));
	}

}
