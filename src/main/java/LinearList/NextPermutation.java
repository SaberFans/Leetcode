package LinearList;

import java.util.Arrays;

public class NextPermutation {
	public static void nextPermutation(int[] num) {
        int partition =-1;
        int index = num.length;
        for(int i=num.length-2;i>=0;i--)
        	if(num[i]<num[i+1]){
        		partition = i;
        		break;
        	}
        if(partition!=-1){
        	for(int i=num.length-1;i>=0;i--){
        		if(num[i]>num[partition]){
        			index = i;
        			int tmp = num[index];
        			num[index]=num[partition];
        			num[partition]=tmp;
        			break;
        		}
        	}
        }
        reverse(num,partition+1);
    }
	static void reverse(int[]num,int index){
		int mid =  index+(num.length-1-index)/2;
		for(int i=num.length-1;i>mid;i--){
			int tmp = num[i];
			num[i]=num[num.length-1+index-i];
			num[num.length-1+index-i]=tmp;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]={1,1,5};
		nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}

}
