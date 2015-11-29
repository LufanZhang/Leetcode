package array;
/*
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3.
Given word1 = "makes", word2 = "coding", return 1.
 */
public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2){
		int length = words.length;
		int res = Integer.MAX_VALUE;
		int first = -1;
		int second = -1;
		for(int i=0;i<length;i++){
			String cur = words[i];
			if(!cur.equals(word1) && !cur.equals(word2)){
				continue;
			}
			else if(cur.equals(word1)){
				first = i;
			}
			if(cur.equals(word2)){
				second = i;
			}
			if(first != -1 && second != -1 && Math.abs(first-second) < res){
				res = Math.abs(first-second);
			}
		}
		return res;
	}
}
