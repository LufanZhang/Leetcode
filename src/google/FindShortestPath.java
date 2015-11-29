package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindShortestPath {
	//1 represent there is a wall
//	public List<Point> findPath(int[][] matrix){
//		List<Point> res = new ArrayList<Point>();
//		if(matrix == null || matrix.length == 0){
//			return res;
//		}
//		Queue<Point> queue = new LinkedList<Point>();
//		//List<Point>[] path = new ArrayList<Point>[];
//	}
	public static void main(String args[]){
		HashMap<Point,Integer> map = new HashMap<Point,Integer>();
		Point a = new Point(1,2);
		Point b = new Point(3,4);
		map.put(a, 1);
		map.put(b,2);
		Point c = new Point(1,2);
		if(map.containsKey(a)){
			System.out.println("yes");
		}
	}
}
