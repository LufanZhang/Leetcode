package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class IslandsNum {
	class Island{
		ArrayList<Island> neighbors;
		public Island(){
			neighbors = null;
		}
	}
	public int[] findIslandsNum(ArrayList<Island> islands){
		int[] res = {0,0};
		if(islands == null || islands.size() == 0){
			return res;
		}
		HashSet<Island> set = new HashSet<Island>(); //store the island that has been visited
		int length = islands.size();
		int max = 0;
		int min = length;
		int maxCount = 0;
		int minCount = 0;
		for(int i=0;i<length;i++){
			Island cur = islands.get(i);
			if(!set.contains(cur)){
				set.add(cur);
				int count = bfsHelper(cur,set);
				if(count > max){
					maxCount = 1;
					max = count;
				}
				else if(count == max){
					maxCount++;
				}
				else if(count < min){
					min = count;
					minCount = 1;
				}
				else if(count == min){
					minCount++;
				}
			}
		}
		res[0] = maxCount;
		res[1] = minCount;
		return res;
	}
	public int bfsHelper(Island cur,HashSet<Island> set){
		//everytime we poll a island from queue, res++;
		int res = 0;
		Queue<Island> queue = new LinkedList<Island>();
		queue.add(cur);
		while(!queue.isEmpty()){
			Island temp = queue.poll();
			res++;
			if(temp.neighbors != null && temp.neighbors.size() != 0){
				for(Island neighbor:temp.neighbors){
					if(!set.contains(neighbor)){
						queue.add(neighbor);
						set.add(neighbor);
					}
				}
			}
		}
		return res;
	}
}
