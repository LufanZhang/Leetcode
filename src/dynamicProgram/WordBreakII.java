package dynamicProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 *  Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"]. 
 */
public class WordBreakII {
	 public ArrayList<String> wordBreak(String s, Set<String> dict) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	        return wordBreakHelper(s,dict,map);
	    }

	    public ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo){
	        if(memo.containsKey(s)) return memo.get(s);
	        ArrayList<String> result = new ArrayList<String>();
	        int n = s.length();
	        if(n <= 0) return result;
	        for(int len = 1; len <= n; ++len){
	            String subfix = s.substring(0,len);
	            if(dict.contains(subfix)){
	                if(len == n){
	                    result.add(subfix);
	                }else{
	                    String prefix = s.substring(len);
	                    ArrayList<String> tmp = wordBreakHelper(prefix, dict, memo);
	                    for(String item:tmp){
	                        item = subfix + " " + item;
	                        result.add(item);
	                    }
	                }
	            }
	        }
	        memo.put(s, result);
	        return result;
	    }
}
