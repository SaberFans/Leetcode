package Array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * Rotate N*N image by clockwise 90 degree
 *
 */
public class RotateImage {

	public void rotate(int[][] matrix) {
		int size = matrix.length;
		// swap over the left and right
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][size - 1 - j];
				matrix[i][size - 1 - j] = tmp;
			}
		}

		// rotate image by the diagonal(right-upside to left-downside)
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[size - 1 - j][size - 1 - i];
				matrix[size - 1 - j][size - 1 - i] = tmp;
			}
		}
	}

	@Test
	public void test() {
		int input[][] = { { 1, 2 }, { 3, 4 } };
		rotate(input);
		int result[][] = { { 3, 1 }, { 4, 2 } };

		for (int i = 0; i < input.length; i++)
			assertArrayEquals(result[i], input[i]);
	}

	@Test
	public void test2() {
		int input[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(input);
		int result[][] = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		for (int i = 0; i < input.length; i++)
			assertArrayEquals(result[i], input[i]);

	}
}
