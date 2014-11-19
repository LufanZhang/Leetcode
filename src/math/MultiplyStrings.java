package math;
/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
	  public String multiply(String num1, String num2) {
	        int m = num1.length();
	        int n = num2.length();
	        if(num1==null||num2==null||m==0||n==0)
	        return "0";
	        int[] result = new int[m+n];
	        for(int i=m-1;i>=0;i--){
	            for(int j=n-1;j>=0;j--){
	                int n1 = Integer.parseInt(num1.substring(i,i+1));
	                int n2 = Integer.parseInt(num2.substring(j,j+1));
	                int res = n1*n2;
	                result[i+j+1]+=res;
	            }
	        }
	        int carry = 0;
	        for(int i=result.length-1;i>=0;i--){
	            int cur = result[i]+carry;
	            result[i] = cur%10;
	            carry = cur/10;
	        }
	        String s = "";
	        for(int i=0;i<result.length;i++){
	            if(result[i]==0&&s.equals(""))
	            continue;
	            s+=result[i];
	        }
	        if(s.equals(""))
	        return "0";
	        return s;
	    }
}
