package google;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindLeastCombination {
	class Point{
		char val;
		int index;
		public Point(char val,int index){
			this.val = val;
			this.index = index;
		}
	}
	public String findCombination(String s,int k){
		StringBuilder sb = new StringBuilder();
		if(s == null || s.length() == 0){
			return sb.toString();
		}
		int length = s.length();
		Comparator<Point> comparatorVal = new Comparator<Point>(){
			public int compare(Point a,Point b){
				if(a.val == b.val){
					return a.index - b.index;
				}
				else{
					return a.val - b.val;
				}
			}
		};
		Comparator<Point> comparatorIndex = new Comparator<Point>(){
			public int compare(Point a,Point b){
				return a.index - b.index;
			}
		};
		PriorityQueue<Point> pqVal = new PriorityQueue<Point>(comparatorVal);
		PriorityQueue<Point> pqIndex = new PriorityQueue<Point>(comparatorIndex);
		for(int i=0;i<Math.min(length, k);i++){
			Point cur = new Point(s.charAt(i),i);
			pqVal.offer(cur);
			pqIndex.offer(cur);
		}
		for(int i=0;i<length;i++){
			int add = i + k;
			if(add < length){
				Point cur = new Point(s.charAt(add),add);
				pqVal.offer(cur);
				pqIndex.offer(cur);
			}
			if(pqIndex.peek().index < i-k){
				sb.append(pqIndex.peek().val);
				pqVal.remove(pqIndex.poll());
			}
			else{
				sb.append(pqVal.peek().val);
				pqIndex.remove(pqVal.poll());
			}
		}
		return sb.toString();
	}
	public static void main(String args[]){
		FindLeastCombination test = new FindLeastCombination();
		String s = "bcdaea";
		int k = 2;
		String res = test.findCombination(s,k);
		System.out.println("res="+res);
	}
}
