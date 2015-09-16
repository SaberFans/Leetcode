package Array;

import java.util.Arrays;

/**
 * Word Search
 *    Backtracking, DPS solution, remember to avoid redundant route path, by keep a visited array.
 * @author epttwxz
 *
 */
public class WordSearch {
	
	boolean check(char[][] grid, String word, int start, int i, int j, int m, int n, boolean visited[][]){
	
		if(start ==word.length())
			return true;
		if(i==m || j==n)
			return false;
		
		if(visited[i][j])
			return false;
		
		visited[i][j]=true;
		
		if(word.charAt(start)==grid[i][j]){
			boolean cp = check(grid, word, start+1, i+1, j, m, n, visited) || check(grid, word, start+1, i, j+1, m, n, visited);
			if(cp==false){
				// reset the visited data
				for(boolean a[]: visited){
					for(boolean aa: a){
						aa = false;
					}
				}
				return check(grid, word, 0, i+1, j, m, n, visited) || check(grid, word, 0, i, j+1, m, n, visited);
			}
			else
				return cp;
		}	
		else{
			// reset the visited data
			for(boolean a[]: visited){
				for(boolean aa: a){
					aa = false;
				}
			}
			return check(grid, word, 0, i+1, j, m, n, visited) || check(grid, word, 0, i, j+1, m, n, visited);
		}
		
	}
	 
	boolean exist(char[][] grid, String word) {
		char xx[][] = new char[][]{{'2', 'a', 'l','h', 'a', 'l','h', 'y', 'c', 't','y', 'a'},
		                            {'4', '1', 'b','y', '2', 't','x', 'e', 'l','h', 'a', 'l'},
		                            {'y', '6', '6','h', '4', '3','h', 'a', 'x', 'e', 'x','l'},
		                            {'y', 'c', 't','h', 'a', 'l','h', 'a', 'x', 'e', 'x','l'},
		                            {'y', 'c', 't','h', 'a', 'l','h', 'a', 'x', 'e', 'x','l'}};
		word= "243";
		boolean visited[][] = new boolean[xx.length][xx[0].length];
		
		return check(xx, word, 0, 0, 0, xx.length, xx[0].length, visited);
	}

	public static void main(String[] args) {
		System.out.println(new WordSearch().exist(null, null));
	}

}
