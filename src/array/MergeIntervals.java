package array;
/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals.size()==0)
        return result;
        //first we need sort the intervals
        Collections.sort(intervals,new IntervalComparator());
        Interval cur = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start>cur.end){
                result.add(cur);
                cur = intervals.get(i);
            }
            else{
                cur.end = Math.max(cur.end,intervals.get(i).end);
            }
        }
        result.add(cur);
        return result;
    }
    public class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a,Interval b){
            return a.start-b.start;
        }
    }
}
