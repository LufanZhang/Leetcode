package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

	 public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        List<Interval> res = new ArrayList<Interval>();
	        if(intervals == null){
	            return res;
	        }
	        intervals.add(newInterval);
	        System.out.println("intervals = "+intervals.get(0));
	        Comparator<Interval> comparator = new Comparator<Interval>(){
	            public int compare(Interval a,Interval b){
	                return a.start - b.start;
	            }
	        };
	        Collections.sort(intervals,comparator);
	        Interval pre = intervals.get(0);
	        int length = intervals.size();
	        for(int i=1;i<length;i++){
	            Interval cur = intervals.get(i);
	            if(cur.start > pre.end){
	                res.add(pre);
	                pre = cur;
	            }
	            else{
	                pre.end = Math.max(pre.end,cur.end);
	            }
	        }
	        res.add(pre);
	        return res;
	    }
	 public static void main(String args[]){
		 List<Interval> intervals = new ArrayList<Interval>();
		 Interval newInterval = new Interval(5,7);
		 List<Interval> res = insert(intervals,newInterval);
		 System.out.println(res);
	 }
}
