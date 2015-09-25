package util.junit.test;

public class PopulateDataUtil {
	public static final int[] empty_array_ints= {};
	public static final int[] one_array_int = {1};
	public static final int[] test_array_ints = {1,2,3,4,5,3,2,1};
	public static final int[] test_array_ints_2 = {-1,-1};
	public static final int[] test_array_ints_3 = {2,9,11, 2, 4};
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
