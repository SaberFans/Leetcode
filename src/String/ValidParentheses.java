package String;

import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Test;

/**
 * Validate the parentheses string input using stack
 */
public class ValidParentheses {
	@Test
	public void test() {
		char c = 'c';
		Character cc = new Character('c');
		System.out.println(c == cc);
	}

	@Test
	public void test2() {
		String s = "(())";
		assertEquals(true, isValid(s));
	}

	@Test
	public void test3() {
		String s = "()())";
		assertEquals(false, isValid(s));
	}

	@Test
	public void test4() {
//		String s = "([]{}){[]}{}";
//		assertEquals(true, isValid(s));
		System.out.println('('-')');
		System.out.println('{'-'}');
		System.out.println('['-']');
	}
	
	
	
	public boolean isValid(String s) {

		char leftparenthesis = '(', rightparenthesis = ')';
		char leftcurly = '{', rightcurly = '}';
		char leftbracket = '[', rightbracket = ']';

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == leftbracket || ch ==leftcurly || ch ==leftparenthesis) {
				stack.push(s.charAt(i));
			} else if (ch == rightbracket || ch ==rightcurly || ch ==rightparenthesis) {
				try {
					char left = stack.pop();
					int dis = ch -left;
					if(dis==1&&ch==leftparenthesis || dis==2&&ch!=leftparenthesis){
						
					}
					else{
						stack.push(ch);
					}
					// pull should be leftbracket '('
				} catch (Exception e) {
					// ommit the exception
					stack.push(rightbracket);
				}
			}
		}

		if (stack.size() != 0)
			return false;

		else
			return true;

	}
}
