package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {
	List<Iterator> list;
	List<Integer> res;
	int index;
	int length;
	public ZigzagIterator(List<List<Integer>> nums){
		list = new ArrayList<Iterator>();
		length = nums.size();
		for(int i=0;i<length;i++){
			Iterator cur = nums.get(i).iterator();
			list.add(cur);
		}
		res = new ArrayList<Integer>();
		index = 0;
	}
	public boolean hasNext(){
		for(int i=index;i<length;i++){
			Iterator cur = list.get(i);
			if(cur.hasNext()){
				index = i;
				return true;
			}
		}
		for(int i=0;i<index;i++){
			Iterator cur = list.get(i);
			if(cur.hasNext()){
				index = i;
				return true;
			}
		}
		return false;
	}
	public int next(){
		return (Integer) list.get(index).next();
	}
	public static void main(String args[]){
		
	}
}
