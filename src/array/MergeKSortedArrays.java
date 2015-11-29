package array;

import java.util.Comparator;
import java.util.PriorityQueue;


public class MergeKSortedArrays {
	class Point{
		int val,row,column;
		public Point(int val,int row,int column){
			this.val = val;
			this.row = row;
			this.column = column;
		}
	}
        public int[] mergeSortedArrays(int [][] a) {
         if(a == null || a.length == 0){
         	return null;
         }
         int m = a.length;
         int n = a[0].length;
         int[] res = new int[m*n];
         int index = m*n-1;
         Comparator<Point> comparator = new Comparator<Point>(){
          	public int compare(Point a,Point b){
          		return b.val - a.val;
          	}
          };
          PriorityQueue<Point> pq = new PriorityQueue<Point>(comparator);
          for(int i=0;i<m;i++){
          	Point last = new Point(a[i][n-1],i,n-1);  	
          	pq.offer(last);
          }
          for(int i=m*n-1;i>=0;i--){
          	Point cur = pq.poll();
          	res[i] = cur.val;
          	if(cur.column > 0){
          		Point newPoint = new Point(a[cur.row][cur.column-1],cur.row,cur.column-1);       		
          		pq.offer(newPoint);
          	}
          	
          }
          return res;
        }
}
