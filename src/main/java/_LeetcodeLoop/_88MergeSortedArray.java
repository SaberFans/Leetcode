package _LeetcodeLoop;

import java.util.Arrays;

/**
 * Created by epttwxz on 23/02/17.
 */
public class _88MergeSortedArray {
    public void merge_slow(int[] nums1, int m, int[] nums2, int n) {
        if(nums1!=null && nums2!=null){
            int merged[] = new int[m+n];
            int pos = 0;
            int pos1=0, pos2 = 0;
            while(pos<m+n && pos1<m && pos2<n){
                merged[pos++] = nums1[pos1]<=nums2[pos2]? nums1[pos1++]: nums2[pos2++];
            }
            while(pos1<m){
                merged[pos++] = nums1[pos1++];
            }
            while(pos2<n){
                merged[pos++] = nums2[pos2++];
            }
            System.arraycopy(merged, 0, nums1, 0, m+n);
        }
    }
    public void merge(int[]nums1, int m, int[] nums2, int n){
        if(nums1!=null && nums2!=null){
            int pos = m+n-1;
            int i = m-1;
            int j = n-1;
            while(i>=0 && j>=0){
                nums1[pos--] = nums1[i]> nums2[j]? nums1[i--]: nums2[j--];
            }
            while(j>=0){
                nums1[pos--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int nums1[]={1,3,5,7,0,0,0,0};
        int nums2[]={2,4,6,8};
        new _88MergeSortedArray().merge(nums1, 4, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }
}
