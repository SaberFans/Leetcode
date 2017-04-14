package Array;

import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 * N= 7, K= 3, if array like this: [1,2,3,4,5,6,7]
 * the array should be rotated to [5,6,7,1,2,3,4].
 * @author epttwxz
 *
 */
public class RotateArray {
	
	/**
	 * O(N) solution
	 * @param num
	 * @param k
	 */
	public void rotate(int[] num, int k){
		if(num.length==0)
			return;
		int[] output = new int[num.length];
		
		k = (2*num.length-k) % num.length;
		
		for(int i=0;i<num.length;i++){
			if(k<num.length)
				output[i] = num[k++];
			else
				output[i] = num[k++ -num.length];
			
		}
		//num = output;
		for(int i=0;i<num.length;i++)
			num[i]= output[i];	
		
	}
	
	void reverse(int []num, int start, int end){
		for(int i=start;i<start+(end-start)/2;i++){
			int reverse_tmp = num[i];
			num[i] = num[end-(i-start)-1];
			num[end-(i-start)-1] = reverse_tmp;
		}
	}
	
	/**
	 * Reverse solution with less space cost
	 * @param num
	 * @param k
	 */
	public void rotate_reverse_zerospace(int[] num,int k){
		k = k%num.length;
		reverse(num, 0, num.length);
		reverse(num, 0, k);
		reverse(num, k, num.length);
		
	}
	
	public static void main(String[] args) {
		int[] num = new int[]{1,2,3,4};
		//new RotateArray().roate(num, 4);
		new RotateArray().rotate_reverse_zerospace(num, 4);
		System.out.println(Arrays.toString(num));
	}
}
