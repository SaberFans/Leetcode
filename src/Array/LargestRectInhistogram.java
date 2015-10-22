package Array;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

public class LargestRectInhistogram {
	/**
	 * Stack Solution, keeps the width and height stack.
	 * O(N) time Solution.
	 * @param height
	 * @return
	 */
//	public int largestRectangleArea(int[] height) {
//		int maxim_area = 0;
//		int width[] = new int[height.length+1];
//		int stack[] = new int[height.length+1];
//		
//		for(int i=0;i<=height.length;i++){
//			int newHeight;
//			if(i==height.length)
//				newHeight = -1;
//			else
//			
//			
//		}
//		return maxim_area;
//	}
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
	
	/*
	 * Solution using Stack explicitly
	 */
	public int largestRect_withStack(int[]height){
		int max_rect_area = 0;
		Stack<Integer> stack = new Stack<>();
		
		int height_appened_zero[] = Arrays.copyOf(height, height.length+1);
		height = height_appened_zero;
		
		for(int i=0;i<height.length;i++){
			if(stack.empty() || height[i]>height[stack.peek()] ){
				stack.push(i);
			}
			else{
				int poped_top = stack.pop();
				max_rect_area = Math.max(max_rect_area, height[poped_top]* (stack.empty()?i: i-stack.peek()-1));
				i--;
			}
		}
		
		return max_rect_area;
		
		
	}
	
	@Test
	public void test_LargestRect(){
		int[] height = {1};
		new LargestRectInhistogram().largestRect(height);
		
		
	}
}
