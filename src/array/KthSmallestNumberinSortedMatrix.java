package array;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
//这个会超时，有一个test case过不去
public class KthSmallestNumberinSortedMatrix {
	 public class Point{
         int val,row,column;
         public Point(int val,int row,int column){
             this.val = val;
             this.column = column;
             this.row = row;
         }
     }
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        Point[][] matrixPoint = new Point[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Point cur = new Point(matrix[i][j],i,j);
                matrixPoint[i][j] = cur;
            }
        }
        Comparator<Point> comparator = new Comparator<Point>(){
            public int compare(Point a,Point b){
                return a.val - b.val;
            }
        };
        HashSet<Point> set = new HashSet<Point>();
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k,comparator);
        pq.offer(matrixPoint[0][0]);
        set.add(matrixPoint[0][0]);
        for(int i=0;i<k-1;i++){
            Point cur = pq.poll();
            if(cur.row + 1 < m && !set.contains(matrixPoint[cur.row+1][cur.column])){
                pq.offer(matrixPoint[cur.row+1][cur.column]);
                set.add(matrixPoint[cur.row+1][cur.column]);
            }
            if(cur.column + 1 < n && !set.contains(matrixPoint[cur.row][cur.column+1])){
                pq.offer(matrixPoint[cur.row][cur.column+1]);
                set.add(matrixPoint[cur.row][cur.column+1]);
            }
        }
        return pq.poll().val;
    }
}
