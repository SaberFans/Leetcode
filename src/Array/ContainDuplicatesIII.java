package Array;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import org.junit.Test;

import util.junit.test.PopulateDataUtil;
import util.sorting.SortingAlgorithm;

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
	public static void main(String[] args) {

		
		//new ContainDuplicatesIII().containsNearbyAlmostDuplicate_bst(null, 0,0);
		
	}
	public boolean containsNearbyAlmostDuplicate_bst(int[] nums, int k, int t){
		if(nums==null || k==0){
			return false;
		}
		TreeSet<Long> set = new TreeSet<>();
				
		for(int i=0;i<nums.length;i++){
			Long floor = set.floor((long)nums[i]+t);
			Long ceil = set.ceiling((long)nums[i]-t);
			if( (floor!=null && floor>= nums[i])
					|| (ceil!=null && ceil<=nums[i])){
				return true;
				
			}
			if(set.size()==k){

				//set.pollFirst(); it's not polling always the first, it's polling the k window size difference element 
				set.remove((long)nums[i-k]); 
			}
			set.add((long)nums[i]);
		}
		
		 
		return false;
	}
	/**
	 * Bucketing partition algorithm, O(N) time, constant max space cost
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate_bucketing(int[] nums, int k, int t){
		if (k == 0 || t < 0)
			return false;
		int bucket_size = k;
		int bucket_divider = Math.abs(t)+1; 
		Map<Long, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			Long curr_bucket = ((long)nums[i]-Integer.MIN_VALUE)/bucket_divider;
			if(map.containsKey(curr_bucket)){
				return true;
			}
			else if( ( map.containsKey(curr_bucket+1)&& Math.abs((long)nums[i]-map.get(curr_bucket+1))<=t)){
				return true;
			}
			else if( (map.containsKey(curr_bucket-1)&& Math.abs((long)nums[i]-map.get(curr_bucket-1))<=t)){
				return true;
			}
			if(map.entrySet().size()==bucket_size){
				long last_bucket_ind = ((long)nums[i-k]-Integer.MIN_VALUE)/bucket_divider;
				map.remove(last_bucket_ind);
			}
			map.put(curr_bucket, nums[i]);
			
		}
		
		return false;
	}
	
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
		SortingAlgorithm.quickSort(nums, 0, length - 1, index);

		int stat = 0;
		for (int i = 1; i < length; i++) {
			long difValue = Math.abs((long) nums[i] - (long) nums[stat]);
			while ((i != stat) && (difValue > t)) {
				stat++;
				difValue = Math.abs((long) nums[i] - (long) nums[stat]); // continuously move forward the stat index
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
	@Test
	public void boundary_test() throws Exception{
		int[][] test = { PopulateDataUtil.test_array_ints,
				PopulateDataUtil.test_array_ints_2 };

		boolean bool_1 = new ContainDuplicatesIII()
				.containsNearbyAlmostDuplicate(test[0], 0,2);

		boolean bool_2 = new ContainDuplicatesIII()
				.containsNearbyAlmostDuplicate_bucketing(test[0], 0,2);
		System.out.println(bool_1 + " " + bool_2);
		assertTrue(bool_2 == bool_1);
	}
    @Test
    public void valid_test() throws Exception {
    	
		int[][] test = { PopulateDataUtil.test_array_ints,
						PopulateDataUtil.test_array_ints_2};
 
			boolean bool_1 = new ContainDuplicatesIII()
					.containsNearbyAlmostDuplicate(test[0], 1, -1);

			boolean bool_2 = new ContainDuplicatesIII()
					.containsNearbyAlmostDuplicate_bucketing(test[0], 1, -1);
			System.out.println(bool_1+" "+bool_2);
			assertTrue(bool_2 == bool_1);
	 
	}
    
    @Test
    public void valid_test_2() throws Exception {
    	
		int[][] test = { PopulateDataUtil.test_array_ints,
						PopulateDataUtil.test_array_ints_2};
 
			boolean bool_1 = new ContainDuplicatesIII()
					.containsNearbyAlmostDuplicate(test[1], 2, 2);

			boolean bool_2 = new ContainDuplicatesIII()
					.containsNearbyAlmostDuplicate_bucketing(test[1], 2, 2);
			boolean bool_3 = new ContainDuplicatesIII()
			.containsNearbyAlmostDuplicate_bst(test[1], 2, 2);
			assertTrue(bool_2 == bool_1 && bool_1==bool_3);
	 
	}
    @Test
    public void valid_test_3() throws Exception {
 
			boolean bool_1 = new ContainDuplicatesIII()
					.containsNearbyAlmostDuplicate(PopulateDataUtil.test_array_ints_3, 2, 2);

			boolean bool_2 = new ContainDuplicatesIII()
					.containsNearbyAlmostDuplicate_bucketing(PopulateDataUtil.test_array_ints_3, 2, 2);
			boolean bool_3 = new ContainDuplicatesIII()
					.containsNearbyAlmostDuplicate_bst(
							PopulateDataUtil.test_array_ints_3, 2, 2);
			assertTrue(bool_2 == bool_1 && bool_1 == bool_3);
	 
	}
    /**
     * Boundary test to verity if the difference will make the representation of integer to overflow.
     * 
     * @throws Exception
     */
    @Test
    public void valid_test_4() throws Exception {
    		int [] test={-1,  2147483647};
			boolean bool_1 = new ContainDuplicatesIII()
					.containsNearbyAlmostDuplicate(test, 1,2147483647);

			boolean bool_2 = new ContainDuplicatesIII()
					.containsNearbyAlmostDuplicate_bucketing(test, 1,2147483647);
			boolean bool_3 = new ContainDuplicatesIII()
			.containsNearbyAlmostDuplicate_bst(test, 2, 2);
			assertTrue(bool_2 == bool_1 && bool_1 == bool_3);
	 
	}
    
}
