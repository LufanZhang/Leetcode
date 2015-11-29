package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AndroidPassword {
	public static List<String> passwordCombination(int[][] matrix){
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		if(matrix == null || matrix.length == 0){
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int length = m * n;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				HashSet<Integer> set = new HashSet<Integer>();
				dfsHelper(matrix,res,sb,length,i,j,set);
			}
		}
		return res;
	}
	public static void dfsHelper(int[][] matrix,List<String> res,StringBuilder sb,int length,int i,int j,HashSet<Integer> set){
//		System.out.println("length="+sb.length());
		if(sb.length() == length-1){
			System.out.println("length="+sb.length());
			sb.append(matrix[i][j]);
			res.add(sb.toString());
			System.out.println(sb.toString());
			sb.deleteCharAt(sb.length()-1);
			return;
		}
		sb.append(matrix[i][j]);
		set.add(matrix[i][j]);
		for(int x=0;x<matrix.length;x++){
			for(int y=0;y<matrix[0].length;y++){
				if(isValid(matrix,i,j,x,y,set)){
					dfsHelper(matrix,res,sb,length,x,y,set);
				}
			}
		}
		set.remove(matrix[i][j]);
		sb.deleteCharAt(sb.length()-1);
	}
	public static boolean isValid(int[][] matrix,int i,int j,int x,int y,HashSet<Integer> set){
		if(set.contains(matrix[x][y])){
			return false;
		}
		int a = Math.abs(i-x);
		int b = Math.abs(j-y);
		if((a == 2 || a == 0) && (b == 2 || b == 0)){
			return false;
		}
		return true;
	}
	public static void main(String args[]){
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		List<String> res = passwordCombination(matrix);
		//System.out.println(res);
		HashSet<String> set = new HashSet<String>();
		for(int i=0;i<res.size();i++){
			String cur = res.get(i);
			if(set.contains(cur)){
				System.out.println("wrong");
			}
			set.add(cur);
		}
	}
}
