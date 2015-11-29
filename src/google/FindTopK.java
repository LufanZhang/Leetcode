package google;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import javax.swing.text.html.HTMLDocument.Iterator;

public class FindTopK {
	public static List<String> findK(String[] array,int k){
		List<String> res = new ArrayList<String>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int length = array.length;
		for(int i=0;i<length;i++){
			String cur = array[i];
			if(map.containsKey(cur)){
				map.put(cur, map.get(cur)+1);
			}
			else{
				map.put(cur, 1);
			}
		}
		Comparator<Entry<String,Integer>> comparator = new Comparator<Entry<String,Integer>>(){
			public int compare(Entry<String,Integer> entry1,Entry<String,Integer> entry2){
				return entry1.getValue() - entry2.getValue();
			}
		};
		PriorityQueue<Entry<String,Integer>> pq = new PriorityQueue<Entry<String,Integer>>(k,comparator);
		
		for(Entry<String,Integer> entry:map.entrySet()){
			pq.offer(entry);
			if(pq.size() > k){
				pq.poll();
			}
		}
		while(!pq.isEmpty()){
			res.add(pq.poll().getKey());
		}
		return res;
	}
//	public static List<String> findK(String[] array,int k){
//		List<String> res = new ArrayList<String>();
//		int length = array.length;
//		HashMap<String,Integer> map = new HashMap<String,Integer>();
//		
//	}
	public static void main(String args[]){
		String[] array = {"aaa","bbb","ccc","ddd","eee","aaa","bbb","ccc","aaa","eee","eee","eee","eee"};
		List<String> res = findK(array,3);
		System.out.println("res="+res);
		int[] test = {1,2,4,5,5,};
		
	}
}
