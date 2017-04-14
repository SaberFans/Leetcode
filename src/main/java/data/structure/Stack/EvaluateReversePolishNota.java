package data.structure.Stack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

 

import org.junit.Test;

public class EvaluateReversePolishNota {

	int evalRPN(List<String> tokens) {
		Stack<String> notations = new Stack<>();
		 
		int ret = 0;
		String plus = "+", minus = "-", multiply = "*", divide= "/";
		for(int i=0;i<tokens.size();i++){
			if(tokens.get(i)==plus || tokens.get(i)==minus || tokens.get(i)==multiply || tokens.get(i)==divide){
				
				int R = Integer.parseInt(notations.pop());
				int L = Integer.parseInt(notations.pop());
				if(tokens.get(i)==plus)
					notations.push(Integer.toString(L+R));
				if(tokens.get(i)==minus)
					notations.push(Integer.toString(L-R));
				if(tokens.get(i)==multiply)
					notations.push(Integer.toString(L*R));
				if(tokens.get(i)==divide)
					notations.push(Integer.toString(L/R));
			}
			else{
				notations.push(tokens.get(i));
			}
		}
		
		return Integer.parseInt(notations.pop());
	}
	@Test
	public void testValidation() throws Exception {
		String[] notations = {"2", "1", "+", "3", "*"};
		String[] notations2 = {"4", "13", "5", "/", "+"};
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		for(String a: notations){
			list1.add(a);
		}
		for(String a : notations2)
			list2.add(a);
		assertEquals(evalRPN(list1), 9);
		assertEquals(evalRPN(list2), 6);
		
	}
}
