package Array;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Generate Well formed parenthesis
 * 
 * @Backtracking
 * @Array
 */
public class GenerateParentheses {
	void produceParenthesis(List<String> str, String parenthesis, int size, int leftcount,
			int rightcount) {
		if (2 * size == leftcount + rightcount) {
			str.add(parenthesis);
			return;
		}
		if (leftcount < size)
			produceParenthesis(str, parenthesis + "(", size, leftcount + 1, rightcount);

		if (leftcount > rightcount)
			produceParenthesis(str, parenthesis + ")", size, leftcount, rightcount + 1);

	}

	public List<String> generateParenthesis(int n) {

		List<String> pairsParenthesis = new ArrayList<>();
		produceParenthesis(pairsParenthesis, "", n, 0, 0);

		return pairsParenthesis;
	}
	
	@Test
	public void test() {
		List<String> str = new ArrayList<String>();
		str.addAll(Arrays.asList(new String[] { "((()))", "(()())", "()(())","(())()", "()()()" }));
		Collections.sort(str);

		List<String> actual = generateParenthesis(3);
		Collections.sort(actual);

		assertTrue(str.equals(actual));

	}
}
