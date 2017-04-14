package DP;

/**
 * Structurally unique BST's that store values 1...n. Input value is n;
 *
 */

// Marker to be solved today.
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
	int num = 0;
        int count[] = new int[n+1];
        count[0] = count[1] =1;
        for(int i=2;i<=n;i++){
            int sum = 0;
            for(int k=0;k<i;k++ ){
                sum += count[k]*count[i-1-k];
            }
            count[i] = sum;
        }

        return count[n];
    }
}
