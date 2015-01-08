package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Given an integer n, return a n-queue solution Return a board configuration,
 * in which the 'Q' and '.' represent the Queue and the space respectively.
 */
public class NQueens {

	boolean isBoardFull(int mark[]){
		for(int a: mark){
			if(a==0)
				return false;
		}
		return true;
	}
	
	void calculateNQ(List<String[]> boardres, List<String> board, int mark[], int n) {
		if(isBoardFull(mark)){
			boardres.add(board.toArray(new String[board.size()]));
			return;
		}
		char line[] = new char[n];
		Arrays.fill(line, '.');
		for(int i=0;i<n;i++){
			if(mark[i]==0){
				List<String> boardcopy= new ArrayList<>(board);
				
				line[i] = 'Q';
				boardcopy.add(Arrays.toString(line));
				mark[i] = 1;
				calculateNQ(boardres, boardcopy, mark, n);
				mark[i] = 0;
				line[i] = '.';
			}
		}
	}
	
	public List<String[]> solveNQueens(int n) {
		List<String[]> boardres = new ArrayList<>();
		int mark[] = new int[n];
		List<String> board = new ArrayList<>(); 
		Arrays.fill(mark, 0);
		
		calculateNQ(boardres, board, mark, n);
		return boardres;
	}
	
	@Test
	public void testChar2Str(){
		char charr [] =new char[4];
		Arrays.fill(charr, '1');
		System.out.println(Arrays.toString(charr));
	}
	
	
	@Test
	public void test(){
		List<String[]> boards = solveNQueens(3);
		
		for(String x[]: boards){
			System.out.println(">>>>>>>>");
			for(String t: x){
				System.out.println(t);
			}
			System.out.println(">>>>>>>>");
		}
	}
}
