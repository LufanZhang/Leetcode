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
	  public String convert(String s, int nRows) {
	        int length = s.length();
	        if(s==null||length<=nRows||nRows<=1)
	        return s;
	        String res = "";
	        for(int i=0;i<nRows;i++){
	            int j = i;
	            res+=s.charAt(j);
	            while(j<length){
	                j+=(nRows-i-1)*2;
	                if(j<length&&i!=nRows-1)
	                res+=s.charAt(j);
	                j+=2*i;
	                if(j<length&&i!=0)
	                res+=s.charAt(j);
	            }
	        }
	        return res;
	    }
}
