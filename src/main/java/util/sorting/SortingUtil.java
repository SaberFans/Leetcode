package util.sorting;

public class SortingUtil {
	static public void swap(int[] input, int i, int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
	public static boolean isAscending(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1])
                return false;
        }
        return true;
    }
}
