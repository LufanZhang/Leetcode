package string;
/*
 *  A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2. 
 */
public class DecodeWays {
	  public int numDecodings(String s) {
	        int length = s.length();
	        if(s==null||length==0)
	        return 0;
	        if(s.charAt(0)=='0')
	        return 0;
	        int[] result = new int[length+1];
	        result[length] = 1;
	        for(int i=length-1;i>=0;i--){
	            if(s.charAt(i)=='0'){
	                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2')
	                result[i] = 0;
	                else
	                return 0;
	            }
	            else if((i!=length-1)&&(s.charAt(i)=='1'||(s.charAt(i)=='2'&&s.charAt(i+1)<='6')))
	            result[i]=result[i+1]+result[i+2];
	            else
	            result[i] = result[i+1];
	        }
	        return result[0];
	    }
}
