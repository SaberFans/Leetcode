package Array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContainerWithMostWater {
	// TLE solution
	public int maxArea(int[] height) {
		int maxarea = Integer.MIN_VALUE;
		for(int i=0;i<height.length;i++)
			for(int j =i+1;j<height.length;j++){
				int area = Math.abs(i-j)*Math.min(height[i], height[j]);
				maxarea = maxarea>area?maxarea:area;
			}
		return maxarea;
	}
	
	/** Soluttion Key : the volume depends on the ****SHORTEST board****!
	 *  Array: [a1,a2,a3,...,an-1] 
	 *  During narrow down the array from a1 to an-1, the height will be min(ai,aj)     
	 *  The initial area = min(a1,an-1)*(n-1)
	 */
	public int maxAreaP(int[]height){
		int max = Integer.MIN_VALUE;
		int start = 0;
		int end = height.length-1;
		
		while(start<end){
			int area_tmp = Math.min(height[start], height[end])*(end-start);
			
			max = max>area_tmp?max:area_tmp;
			if(height[start]<height[end]){
				start++;
			}
			else{
				end--;
			}
		}
		return max;
	}
	@Test
	public void test1(){
		assertEquals(6, maxAreaP(new int[]{1,2,3,2,4}));
	}
	

}
