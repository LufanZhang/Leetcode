package test;

import java.util.HashSet;

public class SolutionI {
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
	public static void main(String args[]){
		String s1 = "apple";
		String s2 = "anaconda";
		String s3 = "MadamImAdam";
		int res1 = palindromeNum(s1);
		int res2 = palindromeNum(s2);
		int res3 = palindromeNum(s3);
		System.out.println("apple="+res1);
		System.out.println("anaconda="+res2);
		System.out.println("MadamImAdam="+res3);
	}
}
