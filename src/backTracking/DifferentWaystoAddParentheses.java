package backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DifferentWaystoAddParentheses {
	 public static List<Integer> diffWaysToCompute(String input) {
	        if(input == null || input.length() == 0){
	            return new ArrayList<Integer>();
	        }
	       int length = input.length();
	       List<Integer> num = new ArrayList<Integer>();
	       List<Character> sign = new ArrayList<Character>();
	       int start = 0;
	       for(int i=0;i<length;i++){
	           char cur = input.charAt(i);
	           if(cur == '+' || cur == '-' || cur == '*'){
	               int number = Integer.parseInt(input.substring(start,i));
	               start = i+1;
	               num.add(number);
	               sign.add(cur);
	           }
	       }
	       num.add(Integer.parseInt(input.substring(start,length)));
	       HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
	       return helper(num,sign,map,0);
	    }
	   public static List<Integer> helper(List<Integer> num,List<Character> sign,HashMap<Integer,List<Integer>> map,int start){
	       if(map.containsKey(start)){
	           return map.get(start);
	       }
	       List<Integer> res = new ArrayList<Integer>();
	       HashSet<Integer> set = new HashSet<Integer>();
	       if(start == num.size()-1){
	           res.add(num.get(start));
	       }
	       else{
	           int length = num.size();
	           int number = 0;
	           for(int i=start;i<length-1;i++){
	               if(i == start){
	                   number = num.get(start);
	               }
	               else{
	                   char curSign = sign.get(i-1);
	                   int temp = num.get(i);
	                   number = calculate(number,temp,curSign);
	               }
	               List<Integer> post = helper(num,sign,map,i+1);
	               for(int postNum:post){
	                    int result = calculate(number,postNum,sign.get(i));
	                    //if(!set.contains(result)){
	                         res.add(result);
	                         set.add(result);
	                    //}
	               }
	           }
	       }
	       map.put(start,res);
	       return res;
	   }
	   public static int calculate(int a,int b,char c){
	       if(c == '+'){
	           return a + b;
	       }
	       else if(c == '-'){
	           return a - b;
	       }
	       else{
	           return a * b;
	       }
	   }
	   public static void main(String args[]){
		   String s = "2*3-4*5";
		   List<Integer> res = diffWaysToCompute(s);
		   System.out.println("res = "+res);
	   }
}
