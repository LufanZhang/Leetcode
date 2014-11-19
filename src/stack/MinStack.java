package stack;

import java.util.Stack;

/*
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

 */
public class MinStack {
	 private Stack<Integer> num;
	    private Stack<Integer> min;
	     public MinStack(){
		    	this.num = new Stack<Integer>();
		    	this.min = new Stack<Integer>();
		    }
	    public void push(int x) {
	        num.push(x);
	        if(min.isEmpty()){
	            min.push(x);
	        }
	        else{
	            if(x<=min.peek()){
	                min.push(x);
	            }
	        }
	    }

	    public void pop() {
	        if(num.isEmpty()){
	            return;
	        }
	        int current = num.pop();
	        if(current==min.peek()){
	            min.pop();
	        }
	    }

	    public int top() {
	        if(num.isEmpty()){
	            return 0;
	        }
	        return num.peek();
	    }

	    public int getMin() {
	        if(min.isEmpty()){
	            return Integer.MAX_VALUE;
	        }
	        return min.peek();
	    }
}
