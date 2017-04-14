package data.structure.Stack;

import java.util.Stack;

import org.junit.Test;

public class LongestValidParentheses {
	
	public final String LEFT_CHARACTERS = "[{(", RIGHT_CHARACTERS = "]})";
	public int longestParentheses(String parentheses){
		int maxSize = 0;
		Stack<Integer> charStack = new Stack<>();
		int lastIndexRightParenthese = -1;
		
		for(int i=0;i<parentheses.length();i++){
			char currentChar = parentheses.charAt(i);
			if(LEFT_CHARACTERS.indexOf(currentChar)>-1){
				charStack.push(i);
			}
			else{
				if(charStack.isEmpty()){
					lastIndexRightParenthese = i;
				}
				else{
					int top = charStack.pop();
					if(parentheses.charAt(top) == LEFT_CHARACTERS.charAt(RIGHT_CHARACTERS.indexOf(currentChar))){
						if(charStack.isEmpty()){
							maxSize = Math.max(maxSize, i-lastIndexRightParenthese);
						}
						else{
							maxSize = Math.max(maxSize, i-charStack.peek());
						}
					}
					else{
						// mis-match, clear the stack
						charStack.clear();
						// reset the index of offset
						lastIndexRightParenthese = i;
					}
				}
			}
		}
		return maxSize;
	}
	@Test
	public void validTest() throws Exception {
		String parentheses = "[[{][[]]";
		org.junit.Assert.assertEquals(new LongestValidParentheses().longestParentheses(parentheses), 4);
	}
	@Test
	public void continuousTest() throws Exception {
		String parentheses = "[][[][][]";
		org.junit.Assert.assertEquals(new LongestValidParentheses().longestParentheses(parentheses), 6);
	}
	@Test
	public void continuousTest2() throws Exception {
		String parentheses = "[][[]";
		org.junit.Assert.assertEquals(new LongestValidParentheses().longestParentheses(parentheses), 2);
	}
}
