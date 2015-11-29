package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 给所有会议的interval时间，看一共最少需要多少个meeting room
 * 先按start时间排序
 * 然后一个priorityqueue，队列里面装着现在进行的会议的结束时间，在前面的最先结束
 * 每次用当前的interval的start时间和queue里面最先结束的时间比较，如果start比较小，说明这个当前会议开始的时候，
 * 还有queue里面的这些会议还没有结束，所以queue的size就是需要的房间数目，也就是说在这个时间里，queue里面的会议正在同时进行
 * 如果start较大，就说明在start的时刻，queue里面已经有一部分的会议已经结束，结束就不需要再占用房间了，所以把结束的pop出来，当前的
 * push进去
 */
public class MeetingRommII {
	class Interval{
		int start,end;
		public Interval(int start,int end){
			this.start = start;
			this.end = end;
		}
	}
	public int minMeetingRooms(Interval[] intervals){
		if(intervals == null || intervals.length == 0){
			return 0;
		}
		Comparator<Interval> comparator = new Comparator<Interval>(){
			public int compare(Interval a,Interval b){
				return a.start - b.start;
			}
		};
		Arrays.sort(intervals,comparator);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int length = intervals.length;
		int res = 0;
		for(int i=0;i<length;i++){
			Interval cur = intervals[i];
			while(!pq.isEmpty() && cur.start > pq.peek()){
				pq.poll();
			}
			pq.offer(cur.end);
			if(pq.size() > res){
				res = pq.size();
			}
		}
		return res;
	}
}
