package cc.interview.book.problems.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Fill zeroes in same row and column when found a zero element
 * in the matrix.
 */
public class FillZero {

    public void fillZero(int[][] matrix) {

        int row[] = new int[matrix.length];
        int col[] = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (row[i] == 1) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
            if (col[i] == 1) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

    }

    @Test
    public void test() {
        int[][] input = {
                {1, 2, 3, 4},
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 0, 1, 1}

        };
        fillZero(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));

        }
    }
}
