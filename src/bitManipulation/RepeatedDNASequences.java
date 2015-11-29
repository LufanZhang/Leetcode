package bitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
	  public static List<String> findRepeatedDnaSequences(String s) {
		//each of letter can be represented as 2 bits (A-00,C-01,G-10,T-11),so the 10 letters can be represented as 20 bit
	        //e.g. "AAAAACCCCC"-00 00 00 00 00 01 01 01 01 01
	        List<String> res = new ArrayList<String>();
	        if(s == null || s.length() <= 10){
	            return res;
	        }
	        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	        map.put('A',0);
	        map.put('C',1);
	        map.put('G',2);
	        map.put('T',3);
	        
	        HashSet<Integer> contain = new HashSet<Integer>();
	        HashSet<Integer> hasAdded = new HashSet<Integer>();
	        int temp = 0;
	        for(int i=0;i<20;i++){
	            temp = (temp<<1) + 1;
	        }
	        
	        int length = s.length();
	        int cur = 0;
	        for(int i=0;i<length;i++){
	            char c = s.charAt(i);
	            if(i <= 9){
	                cur = (cur<<2) + map.get(c);
	                if(i == 9){
	                    contain.add(cur);
	                }
	            }
	            else{
	                //in order to gurantee the length is 10, we should add one and then delete the first one
	                cur = ((cur<<2) + map.get(c))&temp;
	                if(contain.contains(cur) && !hasAdded.contains(cur)){
	                    res.add(s.substring(i-9,i+1));
	                    hasAdded.add(cur);
	                }
	                else{
	                    contain.add(cur);
	                }
	            }
	        }
	        return res;
	    }
	  public static void main(String args[]){
		  String s = "CAAAAAAAAAC";
		  List<String> res = findRepeatedDnaSequences(s);
		  System.out.println(res);
		  
	  }
}
