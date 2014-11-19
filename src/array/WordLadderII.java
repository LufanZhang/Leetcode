package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 *  Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]

Note:

    All words have the same length.
    All words contain only lowercase alphabetic characters.

 */
public class WordLadderII {
	public static ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if(!dict.contains(end)||!dict.contains(start)||start.length()!=end.length())
			return result;
		HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		Queue<String> que1 = new LinkedList<String>();
		Queue<String> que2 = new LinkedList<String>();
		que1.add(start);
		boolean flag = false;
		dict.remove(start);
		while(!que1.isEmpty()){
			if(!dict.contains(end)){
				flag = true;
				break;
			}
			while(!que1.isEmpty()){
				String cur = que1.poll();
				change(cur,que2,dict,map);
				//System.out.println(cur+" "+map);
			}
			while(!que2.isEmpty()){
				String temp = que2.poll();
				que1.add(temp);
				dict.remove(temp);
				//System.out.println(temp);
			}
		}
		Set<String> keys = map.keySet();  
		  Iterator<String> iterator = keys.iterator();  
		  while (iterator.hasNext()) {  
		   String key = iterator.next();  
		   ArrayList<String> arrayList = map.get(key);
		   //System.out.println(key+" "+arrayList);
		  }
		if(flag==true){
			ArrayList<String> list = new ArrayList<String>();
			list.add(end);
			result.add(list);
			while(true){
				if(result.get(0).get(0).equals(start))
					break;
				int size = result.size();
				for(int i=0;i<size;i++){
					ArrayList<String> parents = map.get(result.get(0).get(0));
					int parentSize = parents.size();
					ArrayList<String> old = result.get(0);
					result.remove(old);
					for(int j=0;j<parentSize;j++){
						ArrayList<String> newList = new ArrayList<String>();
						newList.add(parents.get(j));
						newList.addAll(old);
						result.add(newList);
					}
 				}
			}
		}
		return result;
	}
	public static void change(String cur,Queue<String> que2,Set<String> dict,HashMap<String,ArrayList<String>> map){
		int length = cur.length();
		for(int i=0;i<length;i++){
			char[] curChar = cur.toCharArray();
			for(char m='a';m<='z';m++){
				curChar[i] = m;
				String changeString = String.valueOf(curChar);
				if(dict.contains(changeString)){
					if(!que2.contains(changeString))
						que2.add(changeString);
					ArrayList<String> list = new ArrayList<String>();
					if(map.containsKey(changeString)){
						ArrayList<String> parents = map.get(changeString);
						list.addAll(parents);
						list.add(cur);
					}
					else{
						list.add(cur);
					}
					map.put(changeString,list);
				}
			}
		}
	}

}
