package DP;

import org.junit.Test;

/**
 * Minimum Path Sum
 * Find the minimum sum of path from top-left to bottom right.
 * DP solution.
 * <p/>
 * F(xi,xj) = Min(F(xi-1,xj),F(xi,xj-1)) + val(xi,xj);  (i = [1,m) ,j= [1,n))
 * Initial condition:
 * F(0,0) = val(0,0);
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;

        int n = grid[0].length;

        int[][] minsum = new int[m][n];
        minsum[0][0] = grid[0][0];

        for (int i = 1; i < n; i++)
            minsum[0][i] = grid[0][i] + minsum[0][i - 1];
        for (int i = 1; i < m; i++)
            minsum[i][0] = grid[i][0] + minsum[i - 1][0];

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                minsum[i][j] = grid[i][j] + Math.min(minsum[i - 1][j], minsum[i][j - 1]);
            }
        return minsum[m - 1][n - 1];
    }

    @Test
    public void test() {
        System.out.println(minPathSum(new int[][]{{1, 2}, {5, 6}, {1, 1}}));

    }

}
