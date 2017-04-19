package _LeetcodeLoop;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by yang on 17/04/2017.
 */
public class _532KdiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        if (k < 0 || nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> uniqueNums = new HashMap<>();
        List<Integer> number = Arrays.stream(nums)
                                      .boxed()
                                      .collect(Collectors.toList());
        for (int i : number) {
            uniqueNums.put(i, uniqueNums.getOrDefault(i, 0) + 1);
        }
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : uniqueNums.entrySet()) {
            if (k == 0) {
                count += entry.getValue() > 1 ? 1 : 0;
            } else {
                count += uniqueNums.getOrDefault(entry.getValue() + k, 0) > 1 ? 1 : 0;
            }
        }
        return count;
    }
    public int findPairsWithPointers(int[]sum, int k){
        Arrays.sort(sum);

        int start = 0, end = 1, result = 0;
        while (start < sum.length && end < sum.length) {
            if (start == end || sum[start] + k > sum[end]) {
                end++;
            } else if (sum[start] + k < sum[end]) {
                start++;
            } else {
                start++;
                result++;
                // start
                //  |
                // [1, 1, ....3, 8, 8], target=7
                //              |
                //             end
                while (start < sum.length && sum[start] == sum[start - 1]) start++;
                end = Math.max(end + 1, start + 1);
            }
        }
        return result;
    }
    @Test
    public void test() {
        int[] input = {1, 3, 1, 5, 4};
        Assert.assertEquals(new _532KdiffPairsInArray().findPairs(input, 0), 1);
        Assert.assertEquals(new _532KdiffPairsInArray().findPairsWithPointers(input, 0), 1);
    }

    @Test
    public void test2() {
        int[] input = {1, 3, 1, 5, 4};
        Assert.assertEquals(new _532KdiffPairsInArray().findPairs(input, -1), 0);
        Assert.assertEquals(new _532KdiffPairsInArray().findPairsWithPointers(input, -1), 0);
    }

    @Test
    public void test3() {
        int[] input = {1, 1, 1, 4, 4};
        Assert.assertEquals(new _532KdiffPairsInArray().findPairs(input, 0), 2);
        Assert.assertEquals(new _532KdiffPairsInArray().findPairsWithPointers(input, 0), 2);
    }
}
