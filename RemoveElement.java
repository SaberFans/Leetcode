package LinearList;

import java.util.Arrays;

public class RemoveElement {

	public static int removeElement(int[] A, int elem) {
        int length = A.length;
        for(int i=0;i<length;i++){
        	if(A[i]==elem){
        		int l = length;
        		int j=i;
        		int t=i;
        		while(j<l&&A[j]==elem){
        			j++;
        			length--;
        		}
        		for(;j<l;j++,t++){
        			A[t]=A[j];
        		}
        	}
        }
        return length;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]num ={1,3,3,3,3,4,5,2};
		System.out.println(Arrays.toString(num));
		removeElement(num,3);
		System.out.println(Arrays.toString(num));
	}
}
