package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	 public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
	        if(beginWord == null || endWord == null || beginWord.length() != endWord.length()){
	            return 0;
	        }
	        Queue<String> queue = new LinkedList<String>();
	        int count = 0;
	        queue.offer(beginWord);
	        boolean flag = false;
	        while(!queue.isEmpty()){
	            if(flag){
	                break;
	            }
	            int length = queue.size();
	            count++;
	            for(int i=0;i<length;i++){
	                String cur = queue.poll();
	                System.out.println("cur = "+cur);
	                if(changeOneWord(queue,wordDict,cur,endWord)){
	                	System.out.println("here");
	                    flag = true;
	                    break;
	                }
	            }
	        }
	        return count+1;
	    }
	    public static boolean changeOneWord(Queue<String> queue,Set<String> wordDict,String cur,String endWord){
	        if(!wordDict.contains(cur)){
	            return false;
	        }
	        wordDict.remove(cur);
	        int length = cur.length();
	        char[] curString = cur.toCharArray();
	        for(int i=0;i<length;i++){
	            char origin = curString[i];
	            for(char h='a';h<='z';h++){
	                curString[i] = h;
	                String newString = String.valueOf(curString);
	                System.out.println("newString = "+newString);
	                if(newString.equals(endWord)){
	                    return true;
	                }
	                if(wordDict.contains(newString)){
	                    queue.offer(newString);
	                }
	            }
	            curString[i] = origin;
	        }
	        return false;
	    }
	    public static void main(String args[]){
	    	String begin = "a";
	    	String end = "c";
	    	HashSet<String> set = new HashSet<String>();
	    	set.add("a");
	    	set.add("b");
	    	set.add("c");
	    	int res = ladderLength(begin,end,set);
	    	System.out.println("res = "+res);
	    	ArrayList<Integer> s = new ArrayList<Integer>();
	    	s.
	    }
}
