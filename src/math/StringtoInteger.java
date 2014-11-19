package math;
/*
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front. 
 */
public class StringtoInteger {
	   public int atoi(String str) {
	        long temp = 0;
	        int length = str.length();
	        int i = 0;
	        if(str==null||length==0)
	        return 0;
	        while(i<length){
	            if(str.charAt(i)!=' ')
	            break;
	            i++;
	        }
	        int flag = 1;
	        if(i<length){
	            if(str.charAt(i)=='-'){
	            flag = -1;
	            i++;
	            }
	            else if(str.charAt(i)=='+'){
	            flag = 1;
	            i++;
	            }
	        }
	        while(i<length){
	            if(str.charAt(i)<'0'||str.charAt(i)>'9')
	            break;
	            String sub = str.substring(i,i+1);
	            int subInt = Integer.parseInt(sub);
	            temp = temp*10+subInt;
	            i++;
	         }
	         temp = temp*flag;
	         if(temp>Integer.MAX_VALUE)
	         return Integer.MAX_VALUE;
	         if(temp<Integer.MIN_VALUE)
	         return Integer.MIN_VALUE;
	         return (int)temp;
	    }
}
