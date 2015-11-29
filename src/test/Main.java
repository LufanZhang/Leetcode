package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;





public class Main {
	class Point{
		int x,y;
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	public   boolean  fun(){
		HashSet<Point> set = new HashSet<Point>();
		Point a = new Point(1,2);
		set.add(a);
		Point b = new Point(1,2);
		if(set.contains(b)){
			System.out.println("true");
			return true;
		}
		System.out.println("false");
		return false;
	}
	public static void main(String[] args) {
		HashMap<List<Integer>,Integer> map = new HashMap<List<Integer>,Integer>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(3);
		map.put(list1,1);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(3);
		if(map.containsKey(list2)){
			System.out.println("true");
		}
	}
}

 

