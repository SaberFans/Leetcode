package Array;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SpiralMatrix {

	/**
	 * Generate the spiral order of M*N matrix.
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> lists = new ArrayList<>();
		if(matrix.length==0 && matrix[0].length==0)
			return lists;
		
		int width = matrix[0].length;
		int height = matrix.length;
		int start_i = 0;
		int start_j = 0;

		while (width > 0 && height > 0) {
			int i = start_i;
			int j = start_j;
			while(j < width+start_j) {
				lists.add(matrix[i][j]);
				j++;
			}
			j--;
			i++;
			while(i<start_i+height) {
				lists.add(matrix[i][j]);
				i++;
			}
			i--;
			j--;
			if(height!=1) 
				while(j>=start_j) {
					lists.add(matrix[i][j]);
					j--;
				}
			
			j++;
			i--;
			if(width!=1)
				while (i>start_i) {
					lists.add(matrix[i][j]);
					i--;
				}
			
			start_i++;
			start_j++;
			width -= 2;
			height -= 2;
		}
		return lists;
	}
	@Test
	public void testOneElemMatrix() throws Exception {
		int[][]matrix = {{1}};
		List<Integer> output = Arrays.asList(1);
		assertEquals(output, spiralOrder(matrix));	
	}
	@Test
	public void test1_2Matrix() throws Exception {
		int matrix[][]= {{2,3}};
		List<Integer> output = Arrays.asList(2,3);
		assertEquals(output, spiralOrder(matrix));
	}
	
	@Test
	public void test2_1Matrix() throws Exception{
		int matrix[][] = {{2},{3}};
		List<Integer> output = Arrays.asList(2,3);
		assertEquals(output, spiralOrder(matrix));
	}
	@Test
	public void test3_1Matrix() throws Exception{
		int matrix[][] = {{2},{3},{4}};
		List<Integer> output = Arrays.asList(2,3,4);
		assertEquals(output, spiralOrder(matrix));
	}
	@Test
	public void test1_3Matrix() throws Exception{
		int matrix[][] = {{2,3,4}};
		List<Integer> output = Arrays.asList(2,3,4);
		assertEquals(output, spiralOrder(matrix));
	}
	@Test
	public void test2_2Matrix() throws Exception{
		int matrix[][] = {{2,3},{4,5}};
		List<Integer> output = Arrays.asList(2,3,5,4);
		assertEquals(output, spiralOrder(matrix));
	}
	@Test
	public void test2_3Matrix() throws Exception {
		int matrix[][] = { 
				{ 2, 3, 4 }, 
				{ 5, 6, 7 }};
		List<Integer> output = Arrays.asList(2,3,4,7,6,5);
		assertEquals(output, spiralOrder(matrix));
		
	}
	@Test
	public void test3_2Matrix() throws Exception {
		int matrix[][] = { 
				{ 2, 3 }, 
				{ 4, 5},
				{ 6, 7 }};
		List<Integer> output = Arrays.asList(2,3,5,7,6,4);
		assertEquals(output, spiralOrder(matrix));
		
	}
	@Test
	public void test3_3Matrix() throws Exception {
		int matrix[][] = { 
				{ 2, 3, 4 }, 
				{ 5, 6, 7 }, 
				{ 8, 9, 10 } };
		List<Integer> output = Arrays.asList(2,3,4,7,10,9,8,5,6);
		assertEquals(output, spiralOrder(matrix));
	}
	
	@Test
	public void test4_4Matrix() throws Exception {
		int matrix[][] =new SpiralMatrix2().generateMatrix(4);
		
		
		List<Integer> output = new ArrayList<>();
		for(int i=1;i<17;i++)
			output.add(i);
		
		assertEquals(output, spiralOrder(matrix));
	}
}
