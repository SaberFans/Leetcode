package Array;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * Element occurance bigger than n/2
 *
 */
public class MajorityElement {

	private HashMap<Integer, Integer>	occur;

 
	/**
	 * Naive solution using HashMap.
	 * For O(1) space O(n) solution, @see Array.MajorityElementII
	 * @param num
	 * @return
	 */
	public int majorityElement(int[] num) {
		int size = num.length;

		occur = new HashMap<>();
		for (int a : num) {
			Integer val = occur.get(a);
			if (val != null)
				occur.put(a, val + 1);
			else
				occur.put(a, 1);
		}
		for (Entry<Integer, Integer> a : occur.entrySet()) {
			if (a.getValue() > size / 2)
				return a.getKey();
		}
		return -1;
	}
	
	@Test
	public void test1(){
		assertEquals(-1, majorityElement(new int[]{2147483647,1,3,4,5,1,1,1}));
	}
	@Test
	public void test2(){
		assertEquals(4, majorityElement(new int[]{4,5,4,4,4,4,4,4,1,1,1}));
	}
}
