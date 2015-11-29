package array;

public class ValidNumber {
	// e cannot be the first character
    // e cannot be replicated nor placed before number  
    // '.' cannot be replicated nor placed after 'e' 
     // the sign can be placed at the beginning or after 'e' 
     // no other chacraters except '+', '-', '.', and 'e' 
     // check whether numbers are included.  
     // '+', '-', and 'e' cannot be the last character 
	
	
	//只能有一个e，一个'.'
	//e后面不能再有'.'
	//"+,-"可以在最前面，也可以在e的后面
	//可以以数字或者'.'结尾
	//e不能做第一个
	//e前面和后面必须有数字
	//必须有数字
	  public boolean isNumber(String s) {
	         s = s.trim();

	    boolean pointSeen = false;
	    boolean eSeen = false;
	    boolean numberSeen = false;
	    boolean numberAfterE = true;
	    for(int i=0; i<s.length(); i++) {
	        if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
	            numberSeen = true;
	            numberAfterE = true;
	        } else if(s.charAt(i) == '.') {
	            if(eSeen || pointSeen) {
	                return false;
	            }
	            pointSeen = true;
	        } else if(s.charAt(i) == 'e') {
	            if(eSeen || !numberSeen) {
	                return false;
	            }
	            numberAfterE = false;
	            eSeen = true;
	        } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
	            if(i != 0 && s.charAt(i-1) != 'e') {
	                return false;
	            }
	        } else {
	            return false;
	        }
	    }

	    return numberSeen && numberAfterE;
	    }
}
