package array;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3.
Given word1 = "makes", word2 = "coding", return 1.
这个method会被call很多次怎么办，每次都遍历一边太麻烦了，可以用一个map，把每个单词以及出现的index放到里面，然后
看两个单词时，只用一个一个比较出现的index之间的距离就可以
 */
public class ShortestWordDistanceII {
	public int shortestDistance(String[] words, String word1, String word2){
		 int length = words.length;
		 HashMap<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
		 for(int i=0;i<length;i++){
			 String cur = words[i];
			 if(map.containsKey(cur)){
				 map.get(cur).add(i);
			 }
			 else{
				 ArrayList<Integer> list = new ArrayList<Integer>();
				 list.add(i);
				 map.put(cur,list);
			 }
		 }
		 int m = map.get(word1).size();
		 int n = map.get(word2).size();
		 int i = 0;
		 int j = 0;
		 int res = Integer.MAX_VALUE;
		 while(i < m && j < n){
			 int l = Math.abs(map.get(word1).get(i) - map.get(word2).get(j));
			 if(l < res){
				 res = l;
			 }
			 if(map.get(word1).get(i) < map.get(word2).get(j)){
				 i++;
			 }
			 else{
				 j++;
			 }
		 }
		 return res;
	}
}
