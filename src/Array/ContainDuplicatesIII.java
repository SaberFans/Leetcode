package Array;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import util.junit.test.PopulateDataUtil;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 * 
 * There're 3 solutions available, quicksort, BST, and bucket.
 * @author epttwxz
 * 
 */
public class ContainDuplicatesIII {
	/**
	 * Quick sort solution. 
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length == 0 || nums.length == 1)
			return false;
		int length = nums.length;
		int[] index = new int[length];
		for (int i = 0; i < length; i++)
			index[i] = i;
		quickSort(nums, 0, length - 1, index);

		int stat = 0;
		for (int i = 1; i < length; i++) {
			long difValue = Math.abs((long) nums[i] - (long) nums[stat]);
			while ((i != stat) && (difValue > t)) {
				stat++;
				difValue = Math.abs((long) nums[i] - (long) nums[stat]);
			}
			/*Print out in OJ will cause Time Limit Excess !!!
			 * System.out.println(i + " " + stat);
			 * */
			
			if (i != stat) {
				for (int j = stat; j < i; j++) {

					difValue = Math.abs((long) nums[i] - (long) nums[j]);
					long difindex = Math.abs((long) index[i] - (long) index[j]);
					if ((difindex <= k) && (difValue <= t))
						return true;
				}
			}
		}
		return false;

	}

	void quickSort(int[] a, int low, int high, int[] ind) {
		int p = get(a, low, high, ind);

		if (low <= (p - 1))
			quickSort(a, low, p - 1, ind);
		if (high >= (p + 1))
			quickSort(a, p + 1, high, ind);
	}

	int get(int[] a, int low, int high, int[] ind) {
		int pivot = high;  // move the first to the rightmost, as pivot

        int swap_temp_var = a[low];
        a[low] = a[pivot];
        a[pivot] = swap_temp_var;

        int swap_ind_var = ind[low];
        ind[low] = ind[pivot];
        ind[pivot] = swap_ind_var;

        int pivot_value = a[pivot];
        int pivot_pos = low;
        while(low<high){
            if(a[low]<=pivot_value){

                swap_temp_var = a[pivot_pos];
                a[pivot_pos] = a[low];
                a[low] = swap_temp_var;

                swap_ind_var = ind[pivot_pos];
                ind[pivot_pos] = ind[low];
                ind[low] = swap_ind_var;
                pivot_pos++;
            }
            low++;
        }
        swap_temp_var = a[pivot_pos];
        a[pivot_pos] = a[pivot];
        a[pivot] = swap_temp_var;

        swap_ind_var = ind[pivot_pos];
        ind[pivot_pos] = ind[pivot];
        ind[pivot] = swap_ind_var;

        return pivot_pos;

		/*while (low < high) {
			while (low < high && a[high] >= compare)
				high--;

			int temp = a[low];
			int temp1 = ind[low];
			a[low] = a[high];
			a[high] = temp;
			ind[low] = ind[high];
			ind[high] = temp1;

			while (low < high && a[low] <= compare)
				low++;

			temp = a[low];
			a[low] = a[high];
			a[high] = temp;
			temp1 = ind[low];
			ind[low] = ind[high];
			ind[high] = temp1;
		}
		return low;
		*/

	}
    @Test
    public void valid_test() throws Exception {
        new ContainDuplicatesIII().containsNearbyAlmostDuplicate(
                PopulateDataUtil.test_array_ints, 1, 1);
    }
    boolean isAscending(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1])
                return false;
        }
        return true;
    }
    @Test
    public void qsort_stack_overflow_test() throws Exception{
        int[] big_array = new int[1000000];
        for(int test_occur = 0;test_occur<10;test_occur++) {
            for (int i = 0; i < big_array.length; i++) {
                Random randomGenerator = new Random();
                big_array[i] = randomGenerator.nextInt(100) + randomGenerator.nextInt(100) * 100;

            }
            new ContainDuplicatesIII().quickSort(big_array, 0, big_array.length-1,
                    PopulateDataUtil.getAscendingNums(big_array.length));
            assertTrue(isAscending(big_array));
        }

    }
    @Test
    public void sort_test() throws Exception {
        System.out.println(Arrays.toString(PopulateDataUtil.qs_arry));

        new ContainDuplicatesIII().quickSort(PopulateDataUtil.qs_arry, 0, PopulateDataUtil.qs_arry.length-1,
                PopulateDataUtil.getAscendingNums(5));
        System.out.println(Arrays.toString(PopulateDataUtil.qs_arry));
    }
}
