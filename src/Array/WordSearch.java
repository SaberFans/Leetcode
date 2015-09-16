package Array;
 

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
		if(i==m || j==n || i<0 ||j<0)
			return false;
		
		if(visited[i][j])
			return false;
		
		if(word.charAt(start)==grid[i][j]){
			start++;
			visited[i][j] = true;
			
		}
		/* As the strategy is to iterate over each of element as the first.
		 * once, there's a failed match, then exit immediately.
		 */
		else{
			return false;
		}
		
		if( check(grid, word, start, i+1, j, m, n, visited)|| 
				 check(grid, word, start, i, j+1, m, n, visited)||
				 check(grid, word, start, i-1, j, m, n, visited)||
				 check(grid, word, start, i, j-1, m, n, visited))
			return true;

		// reset the visited to be false
		visited[i][j] = false;
		
		return false;
	}

	boolean exist(char[][] grid, String word) {
		if(word.length()==0)
			return false;
		
		if(grid.length==0)
			return false;
		
		int grid_row_size = grid.length;
		int grid_column_size = grid[0].length;
		
		// To verify each element of the array as the start of string to match.
		for (int i = 0; i < grid.length; i++) {
			boolean[][] visited = new boolean[grid_row_size][grid_column_size];
			for (int j = 0; j < grid[i].length; j++) {
				if (check(grid, word, 0, i, j, grid_row_size, grid_column_size,
						visited))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char xx[][] = new char[][] {
				{ '2', 'a', 'l', 'h', 'a', 'l', 'h', 'y', 'c', 't', 'y', 'a' },
				{ '4', '1', 'b', 'y', '2', 't', 'x', 'e', 'l', 'h', 'a', 'l' },
				{ 'y', '6', '6', 'h', '4', '3', 'h', 'a', 'x', 'e', 'x', 'l' },
				{ 'y', 'c', 't', 'h', 'a', 'l', 'h', 'a', 'x', 'e', 'x', 'l' },
				{ 'y', 'c', 't', 'h', 'a', 'l', 'h', 'a', 'x', 'e', 'x', 'l' } };
		String word = "243";
		
		xx = new char[][] { { 'z', 'z', 'a', 'x' }, 
							{ 'x', 'b', 'a', 'x' },
							{ 'c', 'z', 'a', 'a' } };

		word = "aaazzz";
		System.out.println(new WordSearch().exist(xx, word));
 
	}

}
