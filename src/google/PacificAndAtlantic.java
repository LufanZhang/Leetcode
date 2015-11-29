package google;

import java.util.ArrayList;
import java.util.List;

public class PacificAndAtlantic {
	class Point{
		int x,y;
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	public  List<Point> waterShed(int[][] matrix){
		List<Point> res = new ArrayList<Point>();
		if(matrix == null || matrix.length == 0){
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		if(m <= 2 || n <= 2){
			return res;
		}
		int[][] pacific = new int[m][n];
		int[][] atlantic = new int[m][n];
		for(int i=0;i<n;i++){
			pacific[0][i] = 1;
			atlantic[m-1][i] = 1;
		}
		for(int i=1;i<m-1;i++){
			pacific[i][0] = 1;
			atlantic[i][n-1] = 1;
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				pacific[i][j] = dfsHelper(matrix,pacific,i,j);
				atlantic[i][j] = dfsHelper(matrix,atlantic,i,j);
				if(pacific[i][j] == 1 && atlantic[i][j] == 1){
					res.add(new Point(i,j));
				}
			}
		}
		return res;
	}
	public int dfsHelper(int[][] matrix,int[][] find,int i,int j){
		if(find[i][j] != 0){ //indicate this point has been visited
			return find[i][j];
		}
		//up
		int res = -1;
		System.out.println("i="+i+"  j="+j);
		if(i-1 >= 0 && matrix[i][j] > matrix[i-1][j] && dfsHelper(matrix,find,i-1,j) == 1){
			res = 1;
		}
		//down
		else if(i+1 < matrix.length && matrix[i][j] > matrix[i+1][j] && dfsHelper(matrix,find,i+1,j) == 1){
			res = 1;
		}
		//left
		else if(j-1 >= 0 && matrix[i][j] > matrix[i][j-1] && dfsHelper(matrix,find,i,j-1) == 1){
			res = 1;
		}
		//right
		else if(j+1 < matrix[0].length && matrix[i][j] > matrix[i][j+1] && dfsHelper(matrix,find,i,j+1) == 1){
			res = 1;
		}
		find[i][j] = res;
		return res;
	}
//	public  List<Point> waterShed(int[][] matrix){
//		List<Point> res = new ArrayList<Point>();
//		if(matrix == null || matrix.length == 0){
//			return res;
//		}
//		int m = matrix.length;
//		int n = matrix[0].length;
//		boolean[][] visited = new boolean[m][n];
//		boolean[][] pacific = new boolean[m][n];
//		boolean[][] atlantic = new boolean[m][n];
//		for(int i=0;i<m;i++){
//			for(int j=0;j<n;j++){
//				dfsHelper(matrix,pacific,visited);
//			}
//		}
//		Arrays.fill(visited,false);
//		for(int i=0;i<m;i++){
//			for(int j=0;j<n;j++){
//				dfsHelper(matrix,atlantic,visited);
//			}
//		}
//	}
	public static void main(String args[]){
		int[][] matrix = {{8,1,5,9,9,6,3},
						  {6,8,2,8,1,7,9},
						  {5,7,2,5,4,8,5},
						  {2,2,4,3,1,4,4},
						  {1,8,7,1,2,4,7},
						  {6,3,5,7,3,3,6}};
		PacificAndAtlantic test = new PacificAndAtlantic();
		List<Point> res = test.waterShed(matrix);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i).x + " "+ res.get(i).y);
		}

	}
}
