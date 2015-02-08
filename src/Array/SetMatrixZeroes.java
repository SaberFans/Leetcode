package Array;

/**
 * Given a m*n array, if an element is 0, set its entire row and column to be
 * zero. Required to be in-place and no-extra space.
 */
public class SetMatrixZeroes {

	// In place operation, and no extra space
	public void setZeroes(int[][] matrix) {
		boolean firstRow = false, firstColumn = false;
		// scan the first row and column
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				firstRow = true;
				break;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstColumn = true;
				break;
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (firstRow)
			for (int i = 0; i < matrix[0].length; i++)
				matrix[0][i] = 0;
		if (firstColumn)
			for (int i = 0; i < matrix.length; i++)
				matrix[i][0] = 0;

	}

}
