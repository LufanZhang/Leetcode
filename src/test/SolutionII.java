package test;

import java.util.HashSet;

public class SolutionII {
	public static int palindromeNum(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		String temp = s.toLowerCase();
		int length = temp.length();
		boolean[][] res = new boolean[length][length];
		HashSet<String> set = new HashSet<String>();
		for(int i=length-1;i>=0;i--){
			for(int j=i;j<length;j++){
				if(j == i){
					res[i][j] = true;
				}
				else if(j == i+1){
					if(temp.charAt(i) == temp.charAt(j)){
						res[i][j] = true;
					}
					else{
						res[i][j] = false;
					}
				}
				else{
					if(temp.charAt(i) == temp.charAt(j)){
						res[i][j] = res[i+1][j-1];
					}
					else{
						res[i][j] = false;
					}
				}
				if(res[i][j] == true){
					set.add(temp.substring(i,j+1));
				}
			}
		}
		return set.size();
	}
	static int max = 0;
	public static int generateString(HashSet<Character> set,int n){
		if(n <= 0 || set == null || set.size() == 0){
			return 0;
		}
		StringBuilder sb = new StringBuilder();
		dfsHelper(set,n,sb);
		return max;
	}
	public static void dfsHelper(HashSet<Character> set,int n,StringBuilder sb){
		if(sb.length() == n){
			int temp = palindromeNum(sb.toString());
			if(temp > max){
				max = temp;
			}
			return;
		}
		for(char c:set){
			sb.append(c);
			dfsHelper(set,n,sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	public static void main(String args[]){
		HashSet<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('b');
		set.add('c');
		int n = 4;
		int res = generateString(set,n);
		System.out.println("res4="+res);
	}
}

