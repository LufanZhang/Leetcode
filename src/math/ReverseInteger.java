package math;
/*
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321 
 */
public class ReverseInteger {
	   public int reverse(int x) {
	        int sig = 1;
	        if(x<0){
	            sig = -1;
	            x = -x;
	        }
	        long result = 0;
	        while(x>0){
	            int cur = x%10;
	            x = x/10;
	            result = result*10+cur;
	        }
	        result = result*sig;
	        int res = 0;
	        if(result>Integer.MAX_VALUE)
	        return Integer.MAX_VALUE;
	        if(result<Integer.MIN_VALUE)
	        return Integer.MIN_VALUE;
	        res = (int)result;
	        return res;
	    }
}
