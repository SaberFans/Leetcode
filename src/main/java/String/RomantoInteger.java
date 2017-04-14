package String;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomantoInteger {
	int c2Integer(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	} 

	@Test
	public void test() {
		assertEquals(4, romanToInt("IV"));
	}

	public int romanToInt(String s) {
		int intVal = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && c2Integer(s.charAt(i)) > c2Integer(s.charAt(i - 1))) {
				intVal += c2Integer(s.charAt(i)) - 2 * c2Integer(s.charAt(i - 1));
			} else {
				intVal += c2Integer(s.charAt(i));
			}
		}
		return intVal;
	}
}
