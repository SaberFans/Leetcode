package util.junit.test;

public class PopulateDataUtil {
	
	public static final int[] test_array_ints = {1,2,3,4,5,3,2,1};
	public static final int[] qs_arry = {3, 4, 5, 2, 1};
	
	public static int[] getAscendingNums(int size){
		int []nums = new int[size];
		
		for(int i=0;i<size;i++)
			nums[i] = i+1;
		return nums;
	}
	public static int[] getAllSameNums(int size, int value){
		int []nums = new int[size];
		for(int i=0;i<size;i++)
			nums[i] = value;
		return nums;
	}
	
}
