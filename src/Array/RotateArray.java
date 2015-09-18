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
	
	public void roate(int[] num, int k){
		if(num.length==0)
			return;
		int[] output = new int[num.length];
		k = k%num.length;
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
	public static void main(String[] args) {
		int[] num = new int[]{1,2};
		new RotateArray().roate(num, 1);
		System.out.println(Arrays.toString(num));
	}
}
