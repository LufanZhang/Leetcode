package string;

import java.util.Stack;

/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int length = s.length();
        if(s==null||length<=1)
        return 0;
        int result = 0;
        int max = 0;
        int matchLeft = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for(int i=0;i<length;i++){
            String cur = s.substring(i,i+1);
            if(cur.equals("(")){
                matchLeft++;
                stack.push(i);
            }
            else{
                if(matchLeft<=0)
                stack.push(i);
                else{
                    matchLeft--;
                    stack.pop();
                    result = i-stack.peek();
                    if(result>max)
                    max = result;
                }
            }
        }
        return max;
    }
}
