package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<List<String>>();
        }
        int length = s.length();
        HashMap<String,List<List<String>>> map = new HashMap<String,List<List<String>>>();
        return helper(s, new ArrayList<String>(),map,0,length-1);
    }        

    public static List<List<String>> helper(String s, List<String> cur,HashMap<String,List<List<String>>> map,int start,int end){
        if(map.containsKey(s)){
            return map.get(s);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for(int i = start+1; i <= end+1; i++){
            String sub = s.substring(start,i);
            System.out.println("start="+start+" i="+i+" sub="+sub);
            if(isPal(sub)){
            	System.out.println("llllllllll"+sub);
                if(i == end+1){
                    List<String> newList = new ArrayList<String>();
                    newList.add(sub);
                    res.add(newList);
                }
                else{
                    List<List<String>> post = helper(s,cur,map,i,end);
                    for(List<String> postString:post){
                        List<String> newList = new ArrayList<String>();
                        newList.add(sub);
                        newList.addAll(postString);
                        res.add(newList);
                    }
                }
            }
        } 
        map.put(s.substring(start,end+1),res);
        return map.get(s.substring(start,end+1));
    }                

    public static boolean isPal(String str){
        int l = 0;
        int r = str.length()-1;
        while(l <= r){
            if(str.charAt(l) != str.charAt(r))  return false;
            l++;r--;
        }
        return true;
    }
	    public static void main(String args[]){
	    	String s = "seeslaveidemonstrateyetartsnomedievalsees";
	    	List<List<String>> res = partition(s);
	    	System.out.println("res = "+res);
	    }
}
