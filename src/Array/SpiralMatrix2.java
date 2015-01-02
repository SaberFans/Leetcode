package Array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 *  Generate N*N size spiral matrix
 *
 */
public class SpiralMatrix2 {
	
	
	@Test
	public void test(){
		assertArrayEquals(
			new int[][]{
					{1,2,3},
					{8,9,4},
					{7,6,5}
					},	generateMatrix(3));
		
	}
	
	 
	@Test
	public void testprint(){
		printArray(generateMatrix(4));
		
	}
	public void printArray(int[][] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++)
				System.out.print(array[i][j]+" ");
			System.out.println();
		}
	}
	
	public int[][] generateMatrix(int n) {
		int[][] arr = new int[n][n];

		int start = 1;
		int spiralstart = 0;
		
		while(n>0) {
			for(int i=spiralstart;i<n+spiralstart-1;i++){
//				System.out.println(spiralstart+ " "+ i);
				arr[spiralstart][i] = start++;
			}
			for(int i=spiralstart;i<n+spiralstart-1;i++){
//				System.out.println(i+ " "+ (n-1-spiralstart));
				arr[i][n-1-spiralstart] = start++;
			}
			
			for(int i=n-spiralstart-1;i>spiralstart;i--){
//				System.out.println(i+ " "+ (n-1-spiralstart));
				arr[n-1-spiralstart][i] = start++;
			}
			
			for(int i=n-spiralstart-1;i>spiralstart;i--){
				//
				arr[i][spiralstart] = start++;
			}
			spiralstart++;
			n-=2;
		}
		return arr;
	}

}
