package test;

import java.util.ArrayList;
import java.util.Stack;

public class Question_2 {
	public static void calculation(String s){
		if(s == null || s.length() == 0){
			System.out.println("null");
		}
		int length = s.length();
		ArrayList<String> exp = new ArrayList<String>();
		int start = 0;
		if(s.charAt(0) == '.' || s.charAt(0) == '/' || s.charAt(0) == '*' || s.charAt(length-1) >'9' || s.charAt(length-1) <'0'){
			System.out.println("wrong arithmetic expression!");
		}
		for(int i=1;i<length;i++){
			char cur = s.charAt(i);
			if(cur == '/' || cur == '*'){
				exp.add(s.substring(start,i));
				exp.add(s.substring(i,i+1));
				start = i+1;
			}
			else if(cur == '+' || cur == '-'){
				exp.add(s.substring(start,i));
				start = i;
			}
		}
		exp.add(s.substring(start,length));
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<exp.size();i++){
			String curString = exp.get(i);
			if(curString.equals("/") || curString.equals("*")){
				i++;
				if(stack.isEmpty() || i == exp.size()){
					System.out.println("wrong arithmetic expression!");
					return;
				}
				else{
					String first = stack.pop();
					String second = exp.get(i);
					double firstDouble = Double.parseDouble(first);
					double secondDouble = Double.parseDouble(second);
					double res = curString.equals("/")? (firstDouble/secondDouble):(firstDouble*secondDouble);
					String resString = String.valueOf(res);
					stack.push(resString);
				}
			}
			else{
				stack.push(curString);
			}
		}
		double result = 0.0;
		while(!stack.isEmpty()){
			String curString = stack.pop();
			double cur = (double)Double.parseDouble(curString);
			result += cur;
		}
		System.out.println(result);
	}
	public static void main(String args[]){
		String s = "-1.3+5.1/3-0.8";
		calculation(s);
	}
}
