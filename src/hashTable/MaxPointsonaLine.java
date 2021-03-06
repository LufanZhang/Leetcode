package hashTable;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsonaLine {
	 public static int maxPoints(Point[] points) {
	        int length = points.length;
	        if(points==null||length==0)
	        return 0;
	        int result = 0;
	        HashMap<Double,Integer> map = new HashMap<Double,Integer>();
	        for(int i=0;i<length;i++){
	            map.clear();
	            int max = 0;
	            int samePoint = 0;
	            for(int j=i+1;j<length;j++){
	                if(points[j].x==points[i].x&&points[j].y==points[i].y)
	                samePoint++;
	                else{
	                double slope = points[j].x - points[i].x == 0 ? 
	                    Integer.MAX_VALUE :
	                    0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
	                if(!map.containsKey(slope))
	                map.put(slope,1);
	                else{
	                    map.put(slope,map.get(slope)+1);
	                }
	                if(map.get(slope)>max)
	                    max = map.get(slope);
	                }
	            }
	            if(max+samePoint+1>result)
	            result = max+samePoint+1;
	             
	        }
	        return result;
	    }
   
	 public static void main(String args[]){
		 Point first = new Point(0,0);
		 Point second = new Point(1,1);
		 Point third = new Point(0,0);
		 Point[] points = new Point[3];
		 points[0] = first;
		 points[1] = second;
		 points[2] = third;
		 int res = maxPoints(points);
		 System.out.println(res);
	 }
}
