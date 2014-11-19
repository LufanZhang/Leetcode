package string;

import java.util.Stack;

/*
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {
	  public String simplifyPath(String path) {
	        String result = "/";
	        String[] file = path.split("/");
	        Stack<String> stack = new Stack<String>();
	        for(int i=0;i<file.length;i++){
	            String cur = file[i];
	            if(cur.equals("..")){
	                if(!stack.isEmpty()){
	                    stack.pop();
	                }
	            }
	            else if(cur.equals(".")||cur.equals(""))
	            continue;
	            else
	            stack.push(file[i]);
	        }
	        while(!stack.isEmpty()){
	            result = "/"+stack.pop()+result;
	        }
	        if (result.length() > 1)
	            result = result.substring(0, result.length() - 1);
	        return result;

	    }
}
