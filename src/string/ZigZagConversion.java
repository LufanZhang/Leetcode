package string;
/*
 *  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
 */
public class ZigZagConversion {
//	  public String convert(String s, int nRows) {
//	        int length = s.length();
//	        if(s==null||length<=nRows||nRows<=1)
//	        return s;
//	        String res = "";
//	        for(int i=0;i<nRows;i++){
//	            int j = i;
//	            res+=s.charAt(j);
//	            while(j<length){
//	                j+=(nRows-i-1)*2;
//	                if(j<length&&i!=nRows-1)
//	                res+=s.charAt(j);
//	                j+=2*i;
//	                if(j<length&&i!=0)
//	                res+=s.charAt(j);
//	            }
//	        }
//	        return res;
//	    }
	   public static String convert(String s, int numRows) {
	       if(s == null || s.length() == 0 || numRows <= 1){
	           return s;
	       }
	       StringBuilder[] sbList = new StringBuilder[numRows];
	       int length = s.length();
	       int index = 0;
	       int end = numRows - 1;
	       int runner = 0;
	       while(index < length){
	           while(runner < end && index < length){
	        	   System.out.println("runner="+runner+" index="+index);
	               StringBuilder cur = sbList[runner];
	               if(cur == null){
	                   cur = new StringBuilder();
	               }
	               cur.append(s.charAt(index));
	               System.out.println("cur="+cur.toString());
	               runner++;
	               index++;
	           }
	           while(runner > 0 && index < length){
	               StringBuilder cur = sbList[runner];
	               if(cur == null){
	                   cur = new StringBuilder();
	               }
	               cur.append(s.charAt(index));
	               runner--;
	               index++;
	           }
	       }
	       StringBuilder res = new StringBuilder();
	       for(int i=0;i<numRows;i++){
	           StringBuilder cur = sbList[i];
	           if(cur != null && cur.length() != 0){
	               res.append(cur.toString());
	           }
	       }
	       return res.toString();
	    }
	public static void main(String args[]){
		String s = "A";
		int num = 2;
		String res = convert(s,num);
		System.out.println("res="+res);
	}
}
