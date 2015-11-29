package google;

import java.util.ArrayList;
import java.util.List;

public class MovieName {
	public static List<String> findName(char[][] matrix,String s){
		List<String> res = new ArrayList<String>();
		if(matrix == null || matrix.length == 0){
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j] == s.charAt(0)){
					List<String> list = new ArrayList<String>();
					boolean[][] visited = new boolean[m][n];
					dfsHelper(matrix,s,res,list,i,j,visited);
				}
			}
		}
		return res;
	}
	public static void dfsHelper(char[][] matrix,String s,List<String> res,List<String> list,int i,int j,boolean[][] visited){
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != s.charAt(0) || visited[i][j]){
			return;
		}
		if(s.length() == 1){
			StringBuilder sb = new StringBuilder();
			for(int m=0;m<list.size();m++){
				sb.append(list.get(m));
				sb.append(",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("**");
			res.add(sb.toString());
			return;
		}
		visited[i][j] = true;
		list.add("left");
		dfsHelper(matrix,s.substring(1),res,list,i,j-1,visited);
		list.remove(list.size()-1);
		
		list.add("right");
		dfsHelper(matrix,s.substring(1),res,list,i,j+1,visited);
		list.remove(list.size()-1);
		
		list.add("up");
		dfsHelper(matrix,s.substring(1),res,list,i-1,j,visited);
		list.remove(list.size()-1);
		
		list.add("down");
		dfsHelper(matrix,s.substring(1),res,list,i+1,j,visited);
		list.remove(list.size()-1);
		visited[i][j] = false;
	}
	public static void main(String args[]){
		char[][] matrix = {{'c','b','c','b','a','d'},
							{'s','n','s','k','e','d'},
							{'e','m','n','a','k','e'},
							{'l','k','a','d','s','b'}};
		String name = "snake";
		List<String> res = findName(matrix,name);
		System.out.println(res);
	}
}
