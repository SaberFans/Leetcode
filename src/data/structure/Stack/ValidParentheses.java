package data.structure.Stack;

import static org.junit.Assert.assertEquals;

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
		assertEquals(true, _isValid(s));
	}

	@Test
	public void test3() {
		String s = "()())";
		assertEquals(false, isValid(s));
		assertEquals(false, _isValid(s));
	}

	@Test
	public void test4() {
 		String s = "([]{}){[]}{}";
 		System.out.println('{'-'}');
 		System.out.println('['-']');
 		System.out.println('('-')');
 		assertEquals(true, isValid(s));
 		assertEquals(true, _isValid(s));
 		
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
					if(dis!=1 && dis!=2){
                        stack.push(ch);
                        break;
                    }
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
	public final String LEFT_CHARACTERS = "[{(", RIGHT_CHARACTERS = "]})";
	// []()
	public boolean _isValid(String s){
		
		Stack<Character> charStack = new Stack<>();
		for(int i=0;i<s.length();i++){
			char currentChar = s.charAt(i);
			if(LEFT_CHARACTERS.indexOf(currentChar)>-1) {
				charStack.push(currentChar);
			}
			else if(RIGHT_CHARACTERS.indexOf(currentChar)>-1){
				if(charStack.isEmpty())
					return false;
				char top = charStack.pop();
				if(top!=LEFT_CHARACTERS.charAt(RIGHT_CHARACTERS.indexOf(currentChar))){
					return false;
				}
			}
		}
		return charStack.isEmpty();
	}
	
	
}
