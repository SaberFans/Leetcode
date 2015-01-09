package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Given an integer n, return a N-Queen solution Return a board configuration,
 * in which the 'Q' and '.' represent the Queen and the or space in the board
 * respectively.
 * 
 * N-Queen solution requires that no two queens be placed in the same column or
 * row or diagonal.
 */
public class NQueens {

	void calculateNQ(List<String[]> boardres, int row, int markcol[], int n) {
		if (row == n + 1) {
			String[] line = new String[n];
			for (int i = 0; i < n; i++) {
				String str = new String();
				for (int j = 0; j < n; j++) {
					if (j + 1 == markcol[i + 1]) {
						str = str.concat("Q");
					} else {
						str = str.concat(".");
					}
					line[i] = str;
				}
			}
			boardres.add(line);
			return;
		}

		for (int i = 0; i < n; i++) {
			boolean allow = true;
			for (int j = 0; j < row-1; j++) {
				if (markcol[j] == i+1 || Math.abs(markcol[row - 1] - i - 1) > 1) {
					allow = false;
					break;
				}
			}
			if (allow) {
				markcol[row] = i + 1;
				calculateNQ(boardres, row + 1, markcol, n);
				// markcol[col] = 0;
			}

		}
	}

	public List<String[]> solveNQueens(int n) {
		List<String[]> boardres = new ArrayList<>();

		int markcol[] = new int[n + 1];

		Arrays.fill(markcol, -1);

		calculateNQ(boardres, 1, markcol, n);
		return boardres;
	}

	@Test
	public void testChar2Str() {
		char charr[] = new char[4];
		Arrays.fill(charr, '1');
		System.out.println(Arrays.toString(charr));
	}

	@Test
	public void testprintout() {
		List<String[]> boards = solveNQueens(9);

		for (String x[] : boards) {
			System.out.println(">>>>>>>>");
			for (String t : x) {
				System.out.println(t);
			}
			System.out.println(">>>>>>>>");
		}
	}

	@Test
	public void validateBoards() {

	}
}
