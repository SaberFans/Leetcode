package sorting.utest;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import util.junit.test.PopulateDataUtil;
import util.sorting.InsertionSort;

public class InsertionSortTest {
	@Test
	public void testIS() throws Exception {
		int input[] = { 1, 3, 4, 3, 2, 1, 2, 4, 3, 1 };
		int compareTo[] = Arrays.copyOf(input, input.length);
		
		int input_cp1[] = Arrays.copyOf(input, input.length);
		
		Arrays.sort(compareTo);
		new InsertionSort().sort(input_cp1);
		assertTrue(Arrays.equals(compareTo, input_cp1));
	}
	
	@Test
	public void randomInput() throws Exception {
		int []input = PopulateDataUtil.getRandomData(1000, 100);
		int compareTo[] = Arrays.copyOf(input, input.length);
		
		int input_cp1[] = Arrays.copyOf(input, input.length);
		
		Arrays.sort(compareTo);
		new InsertionSort().sort(input_cp1);
		assertTrue(Arrays.equals(compareTo, input_cp1));
	}
}
