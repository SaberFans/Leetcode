package Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary). You may assume that the intervals were
 * initially sorted according to their start times.
 * <p/>
 * Example 1: Given [1,3],[6,9], insert and merge with [2,5]===> [1,5],[6,9]
 * <p/>
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16] insert and merge with [4,9]
 * ===> [1,2],[3,10],[12,16]
 *
 * @author epttwxz
 */
public class InsertInterval {

	// Definition for an interval.
	private class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this)
				return true;
			if (!(obj instanceof Interval))
				return false;
			return ((Interval) obj).start == this.start
					&& ((Interval) obj).end == this.end;
		}
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> merged_inter = new ArrayList<>();
		if (intervals == null || intervals.size() == 0 && newInterval != null) {
			if (newInterval != null)
				merged_inter.add(newInterval);
			return merged_inter;
		}

		for (int i = 0; i < intervals.size(); i++) {
			Interval lastInter = null;
			if (merged_inter.size() != 0)
				lastInter = merged_inter.get(merged_inter.size() - 1);
			Interval curInter = intervals.get(i);
			int curStart = curInter.start;
			int curEnd = curInter.end;

			// no previous interval added in the list
			if (lastInter == null) {

				// newInter<< curInter, add newInter to the list, and exit the
				// merge
				if (newInterval.end <= curStart) {

					if (newInterval.end == curStart) {
						// merge the curInter and newInter, and insert
						merged_inter
								.add(new Interval(newInterval.start, curEnd));
						while (i < intervals.size() - 1) {
							merged_inter.add(intervals.get(++i));
						}
						break;
					} else {
						merged_inter.add(newInterval);
						merged_inter.addAll(intervals);
						break;
					}
				}
				// newInter is covered by curInter, add the curInter into list
				if (newInterval.end <= curEnd ) {
					merged_inter.add(new Interval(Math.min(newInterval.start, curStart), curEnd));
					while (i < intervals.size() - 1) {
						merged_inter.add(intervals.get(++i));
					}
					//break;
				}
				// curInter is covered by newInter
				if (newInterval.end > curEnd && newInterval.start<=curEnd) {
					merged_inter.add(new Interval(Math.min(newInterval.start, curStart), newInterval.end));
					continue;
				}
//				// newInter<curInter, exit the loop then
//				if (newInterval.end < curEnd) {
//					merged_inter.add(new Interval(newInterval.start, curEnd));
//					while (i < intervals.size() - 1) {
//						merged_inter.add(intervals.get(++i));
//					}
//				}
				// newInter>= curInter, will have following concatenation.
				if (newInterval.start > curEnd ) {
				        merged_inter.add(curInter);
				        boolean set = false;
				        boolean more = false;
						while(i<intervals.size()-1){
						    more = true;
							curInter = intervals.get(++i);
							if(newInterval.start>curInter.end){
								merged_inter.add(curInter);
								
							}
							else if( (newInterval.end>=curInter.start&& newInterval.end<=curInter.end) ||(newInterval.start>=curInter.start&&newInterval.start<=curInter.end)){
								merged_inter.add(new Interval(Math.min(newInterval.start, curInter.start),Math.max(newInterval.end, curInter.end)));
								set =true;
								//i--;
								break;
								
							}
							else{
							    set =true;
							    merged_inter.add(newInterval);
							    i--;
							    break;
							}
						}
						//if(more) i--;
						    
						if(!set)  merged_inter.add(newInterval);
				}
			}
			// has intervals in the list
			else {
				int left = lastInter.start, right = lastInter.end;
				// curInter covers the last Inter
				if (curStart<=right) {
					merged_inter.remove(merged_inter.size() - 1);
					merged_inter.add(new Interval(Math.min(left, curStart),
							Math.max(right, curEnd)));

				} else {
					merged_inter.add(curInter);
					// concatenate the left...
					while (i < intervals.size() - 1) {
						merged_inter.add(intervals.get(++i));
					}
				}

			}
		}

		return merged_inter;
	}

	@Test
	public void test1() throws Exception {
		/*
		 * Example 1: Given [1,3],[6,9], insert and merge with [2,5]===>
		 * [1,5],[6,9]**
		 */
		List<Interval> intervals = Arrays.asList(new Interval(1, 3),
				new Interval(6, 9));
		Interval newInterval = new Interval(2, 5);
		List<Interval> expected = Arrays.asList(new Interval(1, 5),
				new Interval(6, 9));
		Interval[] exp = new Interval[expected.size()];

		List<Interval> output = new InsertInterval().insert(intervals,
				newInterval);

		Interval[] oput = new Interval[output.size()];
		exp = expected.toArray(exp);
		oput = output.toArray(oput);

		assertArrayEquals(exp, oput);

	}

	@Test
	public void test2() throws Exception {
		/*
		 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16] insert and merge
		 * with [4,9] ===> [1,2],[3,10],[12,16]
		 */
		List<Interval> intervals = Arrays.asList(new Interval(1, 2),
				new Interval(3, 5), new Interval(6, 7), new Interval(8, 10),
				new Interval(12, 16));
		Interval newInterval = new Interval(4, 9);
		List<Interval> expected = Arrays.asList(new Interval(1, 2),
				new Interval(3, 10), new Interval(12, 16));
		Interval[] exp = new Interval[expected.size()];

		List<Interval> output = new InsertInterval().insert(intervals,
				newInterval);

		Interval[] oput = new Interval[output.size()];
		exp = expected.toArray(exp);
		oput = output.toArray(oput);

		assertArrayEquals(exp, oput);
	}

	@Test
	public void empty_test() throws Exception {
		List<Interval> intervals = Arrays.asList();
		Interval newInterval = new Interval(4, 9);
		List<Interval> expected = Arrays.asList(new Interval(4, 9));
		Interval[] exp = new Interval[expected.size()];

		List<Interval> output = new InsertInterval().insert(intervals,
				newInterval);

		Interval[] oput = new Interval[output.size()];
		exp = expected.toArray(exp);
		oput = output.toArray(oput);

		assertArrayEquals(exp, oput);
	}

}
