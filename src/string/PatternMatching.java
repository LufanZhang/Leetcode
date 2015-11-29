package string;

import java.util.Arrays;
import java.util.HashMap;

public class PatternMatching {
	public static void moveThem(char [] s) {
		if(s == null || s.length == 0){
			return;
		}
		int length = s.length;
		int runner = length - 1;
		int index = runner;
		while(runner >= 0){
			char cur = s[runner];
			if(cur != ' '){
				s[index] = cur;
				index--;
			}
			runner--;
		}
		for(int i=0;i<=index;i++){
			s[i] = ' ';
		}
	}
	
	public static void main(String args[]){
		char[] s = {' ','a',' ',' ','b','c',' '};
		moveThem(s);
		int length = s.length;
		for(int i=0;i<length;i++){
			System.out.print(s[i]+" ");
		}
		long n = 2342353;
		long d = (long) Math.sqrt(n);
	}
}
