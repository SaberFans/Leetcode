package Array;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import Array.InsertInterval.Interval;

/**
 * Merge overlapped intervals.
 * @author epttwxz
 *
 */
public class MergeIntervals {
	/**
	 * Merge the overlapped intervals.
	 * As the input may be not sorted, needs sort by interval's start value.
	 * @param intervals
	 * @return merged Interval
	 */
	public List<Interval> mergeInterval(List<Interval> intervals ){
		
		List<Interval> merged_intervals = new ArrayList<>();
		Map<Integer, Integer> sortedIntervals = sortAndMerged(intervals);
		for(Entry<Integer, Integer> entry: sortedIntervals.entrySet()){
			if(merged_intervals.isEmpty()){
				merged_intervals.add(new Interval(entry.getKey(), entry.getValue()));
				continue;
			}
			Interval lastMerged = merged_intervals.get(merged_intervals.size()-1);
			if(entry.getKey()>lastMerged.end){
				merged_intervals.add(new Interval(entry.getKey(), entry.getValue()));
			}
			else{
				lastMerged.end =  Math.max(lastMerged.end, entry.getValue());
			}
			
		}
		
		return merged_intervals;
	}
	/**
	 * Sort and merge at the same time.
	 * Take use of TreeMap to sort according to the key.
	 * @param intervals
	 */
	private Map<Integer, Integer> sortAndMerged(List<Interval> intervals ){
		Map<Integer, Integer> sortedIntervals = new TreeMap<>();
		for(Interval interval: intervals){
			sortedIntervals.put(interval.start, sortedIntervals.containsKey(interval.start)?Math.max(interval.end, sortedIntervals.get(interval.start)): interval.end);
		}
		return sortedIntervals;
	}
	@Test
	public void test_validity() throws Exception {
		List<Interval> intervals = Arrays.asList(new Interval(1, 3), new Interval(2, 7), new Interval(3, 5));
		List<Interval> expected = Arrays.asList(new Interval(1,7));
		System.out.println(intervals+ ": "+expected);
		assertEquals(mergeInterval(intervals), expected);
		
	}
}
