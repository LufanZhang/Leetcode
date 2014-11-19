package math;
/*
 *  Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100". 
 */
public class AddBinary {
	 public String addBinary(String a, String b) {
	        if(a==null&&b==null)
	        return null;
	        if(a==null||b==null)
	        return a==null?b:a;
	        if(a.length()<b.length()){
	            String temp = a;
	            a = b;
	            b = temp;
	        }
	        String result = "";
	        int carry = 0;
	        for(int i=a.length()-1;i>=0;i--){
	            int aBit = Integer.parseInt(a.substring(i,i+1));
	            int bBit = 0;
	            if(i-a.length()+b.length()>=0)
	             bBit = Integer.parseInt(b.substring(i-a.length()+b.length(),i-a.length()+b.length()+1));

	            int resultBit = aBit+bBit+carry;
	            if(resultBit>=2){
	                resultBit = resultBit%2;
	                carry = 1;
	            }
	            else{
	                carry = 0;
	            }
	            result = resultBit+result;
	        }
	        if(carry==1)
	        result = 1+result;
	        return result;
	    }
}
