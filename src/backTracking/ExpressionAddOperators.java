package backTracking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	 public static List<String> addOperators(String num, int target) {
	        List<String> res = new ArrayList<String>();
	        if(num == null || num.length() == 0){
	            return res;
	        }
	        StringBuilder sb = new StringBuilder();
	        long first = 0;
	        long second = num.charAt(0) - '0';
	        sb.append(second);
	        dfsHelper(num,target,res,sb,1,first,second);
	        return res;
	    }
	    //pay attention that the immediate result might be larger than integer, so long
	    public static void dfsHelper(String num,int target,List<String> res,StringBuilder sb,int pos,long first,long second){
	        System.out.println("sb = "+sb.toString()+"  first+second = "+(first+second));
	    	if(pos == num.length() && first+second == target){
	            res.add(sb.toString());
	            return;
	        }
	        if(pos >= num.length()){
	            return;
	        }
	        int cur = num.charAt(pos) - '0';
	        sb.append('+');
	        sb.append(cur);
	        dfsHelper(num,target,res,sb,pos+1,first+second,cur);
	        sb.deleteCharAt(sb.length()-1);
	        sb.deleteCharAt(sb.length()-1);
	        
	        sb.append('*');
	        sb.append(cur);
	        dfsHelper(num,target,res,sb,pos+1,first,second * cur);
	        sb.deleteCharAt(sb.length()-1);
	        sb.deleteCharAt(sb.length()-1);
	        
	        sb.append(cur);
	        dfsHelper(num,target,res,sb,pos+1,first,second * 10 + cur);
	        sb.deleteCharAt(sb.length()-1);
	    }
	    public static void main(String args[]){
	    	String s = "123";
	    	int target = 6;
	    	List<String> res = addOperators(s,target);
	    	System.out.println("Res = "+res);
	    }
}
