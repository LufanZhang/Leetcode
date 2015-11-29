package wayfair;

import java.util.HashMap;
import java.util.Stack;

public class ParenthesesMatching {
	public boolean isMatching(String s){
        if(s == null || s.length() == 0){
            return true;
        }
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<Character>();
        int length = s.length();
        for(int i=0;i<length;i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                if(stack.isEmpty() || stack.peek() != map.get(cur)){
                    return false;
                }
                stack.pop();
            }
            else{
                stack.push(cur);
            }
        }
        return stack.isEmpty();
	}
}
