package string;

import java.util.HashSet;

/*
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	 public int lengthOfLongestSubstring(String s) {
	        int length = s.length();
	        if(s==null||length<=1)
	        return length;
	        int max = 0;
	        int start = 0;
	        HashSet<Character> set = new HashSet<Character>();
	        for(int end=0;end<length;end++){
	            if(!set.contains(s.charAt(end))){
	                set.add(s.charAt(end));
	                if(end-start+1>max)
	                max = end-start+1;
	            }
	            else{
	                while(start<=end){
	                    if(s.charAt(start)==s.charAt(end)){
	                        start++;
	                        break;
	                    }
	                    set.remove(s.charAt(start));
	                    start++;
	                }
	            }
	        }
	        return max;
	    }
}
