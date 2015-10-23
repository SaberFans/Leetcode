package Array;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

import org.junit.Test;

public class LargestRectInhistogram {

	/**
	 * Not pass the Time Limit, though...
	 * @param height
	 * @return
	 */
	public int largestRect(int[] height) {
		int stack[] = new int[height.length + 1], width[] = new int[height.length + 1];
		if (height.length == 0)
			return 0;
		int top = 0, area = Integer.MIN_VALUE;
		stack[0] = 0;
		width[0] = 0;
		int newHeight;
		for (int i = 0; i <= height.length; i++) {
			if (i < height.length)
				newHeight = height[i];
			else
				newHeight = -1;
			if (newHeight >= stack[top]) {
				stack[++top] = newHeight;
				width[top] = 1;
			} else {
				int minV = Integer.MAX_VALUE;
				int wid = 0;
				while (stack[top] > newHeight && top>0) {  // what's this complexity?? 
					minV = Math.min(minV, stack[top]);
					wid += width[top];
					area = Math.max(area, minV * (wid));
					top--;
				}
				
				stack[++top] = newHeight;
				width[top] = wid + 1;
			}
		}
		return area; 
	}
	
	/**
	 * Stack Solution, keeps the width and height stack.
	 * O(N) time Solution.
	 * @param height
	 * @return
	 */
	public int largestRect_withStack(int[]height){
		int max_rect_area = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		
		int height_appened_zero[] = Arrays.copyOf(height, height.length+1);
		height = height_appened_zero;
		
		for(int i=0;i<height.length;i++){
			if(stack.isEmpty() || height[i]>height[stack.peek()] ){
				stack.push(i);
			}
			else{
				int poped_top = stack.pop();
				max_rect_area = Math.max(max_rect_area, height[poped_top]* (stack.isEmpty()?i: i-stack.peek()-1));
				i--;
			}
		}
		return max_rect_area;
		
		
	}
	
	@Test
	public void big_dataset_LargestRect1(){
		int[] height = {1};
		height = new int[Integer.MAX_VALUE/200];
		for(int i=0;i<Integer.MAX_VALUE/200;i++)
		{
			height[i] = 1;
		}
		assertEquals(Integer.MAX_VALUE/200, new LargestRectInhistogram().largestRect_withStack(height));
		
	}
	@Test
	public void big_dataset_LargestRect2(){
		int[] height = {1};
		height = new int[Integer.MAX_VALUE/200];
		for(int i=0;i<Integer.MAX_VALUE/200;i++)
		{
			height[i] = 1;
		}
		
		assertEquals(Integer.MAX_VALUE/200, new LargestRectInhistogram().largestRect(height));
		
		
	}
	@Test
	public void java_stack_time_test(){
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<Integer.MAX_VALUE/200;i++)
		{
			stack.push(i);
			stack.pop();
			
		}
	}
	@Test
	public void deque_stack_time_test(){
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i=0;i<Integer.MAX_VALUE/200;i++)
		{
			stack.push(i);
			stack.pop();
			
		}
	}
	@Test
	public void java_arraylist_stack_time_test(){
		ArrayList<Integer> stack = new ArrayList<>();
		for(int i=0;i<Integer.MAX_VALUE/200;i++)
		{
			stack.add(i);
			stack.remove(stack.size()-1);
			
		}
	}
}
