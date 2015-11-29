package string;

import java.util.HashMap;
import java.util.Stack;

public class BasicCalculator {
	public static int calculate(String s) {
		 if(s == null || s.length() == 0){
		        return 0;
		    }
		    int sign = 1;
		    int res = 0;
		    Stack<Integer> stack = new Stack<Integer>();
		    int length = s.length();
		    for(int i=0;i<length;i++){
		        char cur = s.charAt(i);
		        if(Character.isDigit(cur)){
		            int num = 0;
		            int j = i;
		            while(j < length && Character.isDigit(s.charAt(j))){
		                num = num*10 + (s.charAt(j) - '0');
		                j++;
		            }
		            i = j - 1;
		            res += num * sign;
		        }
		        else{
		            if(cur == '+'){
		                sign = 1;
		            }
		            else if(cur == '-'){
		                sign = -1;
		            }
		            else if(cur == '('){
		                stack.push(res);
		                stack.push(sign);
		                res = 0;
		                sign = 1;
		            }
		            else if(cur == ')'){
		                res = res*stack.pop();
		                res += stack.pop();
		            }
		        }
		    }
		    return res;
 }
	public static void main(String args[]){
		String s = "3-((16+7)-(15+9))";
		int res = calculate(s);
		System.out.println("res = "+res);
		
	}
	public String fractionToDecimal(int numerator, int denominator) {
	       if(denominator == 0){
	           return "";
	       }
	       if(numerator == 0){
	           return "0";
	       }
	       StringBuilder sb = new StringBuilder();
	       if((numerator < 0 && denominator > 0) && (numerator > 0 && denominator < 0)){
	           sb.append('-');
	       }
	       long num = Math.abs((long)numerator);
	       long den = Math.abs((long)denominator);
	       long integerPart = num / den;
	       sb.append(integerPart);
	       if(num % den == 0){
	           return sb.toString();
	       }
	       sb.append('.');
	       HashMap<Long,Integer> map = new HashMap<Long,Integer>();
	       long rem = num % den;
	       StringBuilder post = new StringBuilder();
	       int index = 0;
	       while(rem != 0){
	          if(map.containsKey(rem)){
	        	  int pos = map.get(rem);
	              post.insert(pos,'(');
	              post.insert(5, '(');
	              post.append(')');
	              break;
	          }
	          int cur = (int) (rem * 10 / den);
	          post.append(cur);
	          map.put(rem,index);
	          rem = (rem * 10) % den;
	          index++;
	       }
	       sb.append(post.toString());
	       return sb.toString();
	    }
}
