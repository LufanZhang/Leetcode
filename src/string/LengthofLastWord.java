package string;
/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5. 
 */
public class LengthofLastWord {
	  public int lengthOfLastWord(String s) {
	        int length = s.length();
	        if(s==null||length==0)
	        return 0;
	        int result = 0;
	        int i = length-1;
	        while(i>=0){
	            if(s.charAt(i)!=' ')
	            break;
	            i--;
	        }
	        while(i>=0){
	            if(s.charAt(i)==' ')
	            break;
	            i--;
	            result++;
	        }
	        return result;
	    }
}
