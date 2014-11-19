package array;

import java.util.ArrayList;

/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
 */
public class InsertInterval {
	   public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	        if(intervals==null||newInterval==null)
	        return intervals;
	        int pos = 0;
	        ArrayList<Interval> result = new ArrayList<Interval>();
	        for(int i=0;i<intervals.size();i++){
	            Interval cur = intervals.get(i);
	            if(cur.end<newInterval.start){
	                result.add(cur);
	                pos++;
	            }
	            else if(cur.start>newInterval.end)
	            result.add(cur);
	            else{
	                if(cur.start<newInterval.start)
	                newInterval.start = cur.start;
	                if(cur.end>newInterval.end)
	                newInterval.end = cur.end;
	            }
	        }
	        result.add(pos,newInterval);
	        return result;
	    }
}
