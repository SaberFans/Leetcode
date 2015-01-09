package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Given an integer n, return a N-Queen solution Return a board configuration,
 * in which the 'Q' and '.' represent the Queen and the or space in the board respectively.
 * 
 * N-Queen solution requires that no two queens be placed in the same column or row or diagonal.  
 */
public class NQueens {

	boolean isBoardFull(int mark[]){
		for(int a: mark){
			if(a==0)
				return false;
		}
		return true;
	}
	
	
	void calculateNQ(List<String[]> boardres, List<String> board, int row, int markrow[], int markcol[], int n) {
		//if(isBoardFull(markrow)){
		if(row==n+1){
			boardres.add(board.toArray(new String[board.size()]));
			return;
		}
		char line[] = new char[n];
		Arrays.fill(line, '.');
		/*
		 * Don't Forgot to check the diagonal !!
		 */
		for(int i=0;i<n;i++){
			if(markrow[i]==0 && Math.abs(markcol[row-1]-i-1)>1){
				List<String> boardcopy= new ArrayList<>(board);
				
				line[i] = 'Q';
				boardcopy.add(Arrays.toString(line));
				markrow[i] = 1;
				markcol[row] = i+1;
				calculateNQ(boardres, boardcopy,  row+1, markrow, markcol,  n);
				markrow[i] = 0;
//				markcol[col] = 0;
				line[i] = '.';
			}
		}
	}
	
	public List<String[]> solveNQueens(int n) {
		List<String[]> boardres = new ArrayList<>();
		int markrow[] = new int[n];
		int markcol[] = new int[n+1];
		List<String> board = new ArrayList<>(); 
		Arrays.fill(markrow, 0);
		Arrays.fill(markcol, -1);
		
		calculateNQ(boardres, board, 1, markrow, markcol, n);
		return boardres;
	}
	
	@Test
	public void testChar2Str(){
		char charr [] =new char[4];
		Arrays.fill(charr, '1');
		System.out.println(Arrays.toString(charr));
	}
	
	
	@Test
	public void testprintout(){
		List<String[]> boards = solveNQueens(9);
		
		for(String x[]: boards){
			System.out.println(">>>>>>>>");
			for(String t: x){
				System.out.println(t);
			}
			System.out.println(">>>>>>>>");
		}
	}
	
	@Test
	public void validateBoards(){
		
	}
}
