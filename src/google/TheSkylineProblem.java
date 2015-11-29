package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {
	 class Point{
	        int pos,height;
	        boolean isStart;
	        public Point(int pos,int height,boolean isStart){
	            this.pos = pos;
	            this.height = height;
	            this.isStart = isStart;
	        }
	    }
	    public List<int[]> getSkyline(int[][] buildings) {
	        List<int[]> res = new ArrayList<int[]>();
	        if(buildings == null || buildings.length == 0){
	            return res;
	        }
	        int length = buildings.length;
	        List<Point> points = new ArrayList<Point>();
	        for(int i=0;i<length;i++){
	            Point curStart = new Point(buildings[i][0],buildings[i][2],true);
	            Point curEnd = new Point(buildings[i][1],buildings[i][2],false);
	            points.add(curStart);
	            points.add(curEnd);
	        }
	        Comparator<Point> comparator = new Comparator<Point>(){
	            public int compare(Point p1,Point p2){
	                return p1.pos - p2.pos;
	            }
	        };
	        Collections.sort(points,comparator);
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        int size = points.size();
	        Comparator<Integer> com = new Comparator<Integer>(){
	            public int compare(Integer a,Integer b){
	                return b - a;
	            }
	        };
	        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(length,com);
	        pq.offer(0);
	        for(int i=0;i<size;i++){
	        	System.out.print(points.get(i).pos);
	        }
	        for(int i=0;i<size;i++){
	            Point cur = points.get(i);
	            int index = cur.pos;
	            int val = 0;
	            if(cur.isStart){
	                pq.offer(cur.height);
	                val = pq.peek();
	            }
	            else{
	                if(map.containsKey(cur.height)){
	                    map.put(cur.height,map.get(cur.height)+1);
	                }
	                else{
	                    map.put(cur.height,1);
	                }
	                while(!pq.isEmpty()){
	                    if(map.containsKey(pq.peek())){
	                        int removeHeight = pq.poll();
	                        map.put(removeHeight,map.get(removeHeight)-1);
	                        if(map.get(removeHeight) == 0){
	                            map.remove(removeHeight);
	                        }
	                    }
	                    else{
	                    	break;
	                    }
	                }
	                val = pq.peek();
	            }
	            if(res.size() == 0 || res.get(res.size()-1)[1] != val){
	                int[] array = {index,val};
	                res.add(array);
	            }
	        }
	        return res;
	    }
	    public static void main(String args[]){
	    	int[][] buildings = {{0,2,3},{2,5,3}};
	    	TheSkylineProblem t = new TheSkylineProblem();
	    	List<int[]> res = t.getSkyline(buildings);
	    	System.out.println("res="+res);
	    }
}
