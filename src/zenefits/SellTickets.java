package zenefits;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SellTickets {
//	public int maxProfit(int[] windows,int n){
//		if(windows == null || windows.length == 0 || n <= 0){
//			return 0;
//		}
//		int length = windows.length;
//		Comparator<Integer> comparator = new Comparator<Integer>(){
//			public int compare(Integer i,Integer j){
//				return j-i;
//			}
//		};
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(length,comparator);
//		for(int i=0;i<length;i++){
//			pq.offer(windows[i]);
//		}
//		int res = 0;
//		for(int i=0;i<n && !pq.isEmpty();i++){
//			int cur = pq.poll();
//			pq.offer(cur-1);
//			res += cur;
//		}
//		return res;
//	}
}
