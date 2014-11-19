package string;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	  public boolean isValid(String s) {
	       int length = s.length();
	       if(s==null||length==0||length%2!=0)
	       return false;
	       Stack<Character> stack = new Stack<Character>();
	       for(int i=0;i<length;i++){
	           if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
	           stack.push(s.charAt(i));
	           else if(stack.isEmpty()||s.charAt(i)!=match(stack.peek()))
	           return false;
	           else
	           stack.pop();
	       }
	       if(stack.isEmpty())
	       return true;
	       else
	       return false;
	    }
	    public char match(char c){
	        if(c=='(')
	        return ')';
	        else if(c=='{')
	        return '}';
	        else 
	        return ']';
	        
	    }
}
