package test;

import java.util.HashSet;
import java.util.Set;

public class SolutionIII {
	public int maxNum(String s,Set<Character> set){
		if(s == null || s.length() == 0 || set == null || set.size() == 0){
			return 0;
		}
		int length = s.length();
		HashSet<String> resNum = new HashSet<String>();
		boolean[][] res = new boolean[length][length];
		for(int i=length-1;i>=0;i--){
			for(int j=i;j<length;j++){
				if(j == i){
					res[i][j] = set.contains(s.charAt(i));
				}
			}
		}
	}
}
