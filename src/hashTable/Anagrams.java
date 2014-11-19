package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
 */
public class Anagrams {
	   public ArrayList<String> anagrams(String[] strs) {
	        ArrayList<String> result = new ArrayList<String>();
	        int length = strs.length;
	        if(strs==null||length==0)
	        return result;
	        String[] strsClone = strs.clone();
	        HashMap<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
	        for(int i=0;i<length;i++){
	            char[] temp = strsClone[i].toCharArray();
	            Arrays.sort(temp);
	            strsClone[i] = String.valueOf(temp);
	            if(!map.containsKey(strsClone[i])){
	                ArrayList<Integer> index = new ArrayList<Integer>();
	                index.add(i);
	                map.put(strsClone[i],index);
	            }
	            else{
	                
	                map.get(strsClone[i]).add(i);
	            }
	        }
	        Set<String> key = map.keySet();
	        for (Iterator it = key.iterator(); it.hasNext();) {
	            String s = (String) it.next();
	            ArrayList<Integer> cur = map.get(s);
	            if(cur.size()>1){
	                for(int curInteger:cur){
	                    result.add(strs[curInteger]);
	                }
	            }
	            
	        }
	        return result;
	    }
}
