package string;

import java.util.HashSet;

/*
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {
//	 public int lengthOfLongestSubstring(String s) {
//	        int length = s.length();
//	        if(s==null||length<=1)
//	        return length;
//	        int max = 0;
//	        int start = 0;
//	        HashSet<Character> set = new HashSet<Character>();
//	        for(int end=0;end<length;end++){
//	            if(!set.contains(s.charAt(end))){
//	                set.add(s.charAt(end));
//	                if(end-start+1>max)
//	                max = end-start+1;
//	            }
//	            else{
//	                while(start<=end){
//	                    if(s.charAt(start)==s.charAt(end)){
//	                        start++;
//	                        break;
//	                    }
//	                    set.remove(s.charAt(start));
//	                    start++;
//	                }
//	            }
//	        }
//	        return max;
//	    }
	 public static int lengthOfLongestSubstring(String s) {
	        if(s == null || s.length() == 0){
	            return 0;
	        }
	        int res = 0;
	        int length = s.length();
	        int start = 0;
	        HashSet<Character> set = new HashSet<Character>();
	        for(int i=0;i<length;i++){
	            char cur = s.charAt(i);
	            if(!set.contains(cur)){
	                set.add(cur);
	            }
	            else{
	                if(i - start > res){
	                    res = i - start;
	                }
	                while(s.charAt(start) != cur){
	                	set.remove(s.charAt(start));
	                    start++;
	                }
	                start++;
	                System.out.println("start = "+start);
	            }
	        }
	        if(length - start > res){
	            res = length - start;
	        }
	        return res;
	    }
	public static void main(String args[]){
		String s = "tmmzuxt";
		int res = lengthOfLongestSubstring(s);
		System.out.println(res);
	}
}
