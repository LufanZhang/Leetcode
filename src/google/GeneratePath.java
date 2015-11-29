package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratePath {
	class Point{
		int x,y;
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	public List<Point> pathGenerator(int[][] matrix){
		List<Point> res = new ArrayList<Point>();
		if(matrix == null || matrix.length == 0){
			return res;
		}
		int[] di = {0,1,1,1,0,-1,-1,-1};
		int[] dj = {1,1,0,-1,-1,-1,0,1};
//		if(dfsHelper(res,matrix,0,0,di,dj)){
//			return res;
//		}
		dfsHelper(res,matrix,0,0,di,dj);
		return res;
	}
	public boolean dfsHelper(List<Point> res,int[][] matrix,int i,int j,int[] di,int[] dj){
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 1){
			return false;
		}
		matrix[i][j] = 1; // indicate this point has been interated
		Point p = new Point(i,j);
		res.add(p);
		if(i == matrix.length-1 && j == matrix[0].length-1){
			return true;
		}
		Random random = new Random();
		int count = 0;
		boolean[] direction = new boolean[8];
		while(count != 8){
			int next = random.nextInt(8);
			if(direction[next] == true){
				continue;
			}
			else{
				direction[next] = true;
				count++;
				if(dfsHelper(res,matrix,i+di[next],j+dj[next],di,dj)){
					return true;
				}
			}
			//System.out.println("next="+next);
		}
		res.remove(res.size()-1);
		matrix[i][j] = 0;
		return false;
	}
	public static void main(String args[]){
		int[][] matrix = new int[10][10];
		GeneratePath g = new GeneratePath();
		List<Point> res = g.pathGenerator(matrix);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i).x+","+res.get(i).y);
		}
	}
	
	
	
}
