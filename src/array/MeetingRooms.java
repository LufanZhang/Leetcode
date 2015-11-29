package array;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
 * (si < ei), determine if a person could attend all meetings.
 */
public class MeetingRooms {
	class Interval{
		int start,end;
		public Interval(int start,int end){
			this.start = start;
			this.end = end;
		}
	}
	public boolean canAttendMeetings(Interval[] intervals){
		if(intervals == null || intervals.length == 0){
			return true;
		}
		Comparator<Interval> comparator = new Comparator<Interval>(){
			public int compare(Interval a,Interval b){
				return a.start - b.start;
			}
		};
		Arrays.sort(intervals,comparator);
		int length = intervals.length;
		int pre = Integer.MIN_VALUE;
		for(int i=0;i<length;i++){
			Interval cur = intervals[i];
			if(cur.start < pre){
				return false;
			}
			pre = cur.end;
		}
		return true;
	}
}
