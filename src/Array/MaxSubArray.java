package Array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxSubArray {
	// O(n) generic solution
	public int maxSubArray(int[] A) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > sum && sum < 0)
				sum = A[i];
			else
				sum += A[i];
			max = sum > max ? sum : max;
		}
		return max;
	}

	// Divide and Conquer method
	public int maxSubArrayDC(int[] A) {
		int max = Integer.MIN_VALUE;

		return max;
	}

	@Test
	public void test() {
		assertEquals(2, new MaxSubArray().maxSubArray(new int[] { -1, 2 }));
	}

	@Test
	public void test2() {
		assertEquals(5, new MaxSubArray().maxSubArray(new int[] { 1, 2, 2 }));
	}
}
