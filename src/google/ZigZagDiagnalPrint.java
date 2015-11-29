package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZigZagDiagnalPrint {
	public static List<Integer> zigzag(int[][] matrix){
		List<Integer> res = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0){
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int i = 0;
		int j = 0;
		res.add(matrix[0][0]);
		while(true){
			if(i == m-1 && j == n-1){
				break;
			}
			if(j < n-1){
				j++;
			}
			else{
				i++;
			}
			while(i+1 < m && j-1 >= 0){
				res.add(matrix[i][j]);
				i++;
				j--;
			}
			res.add(matrix[i][j]);
			if(i == m-1 && j == n-1){
				break;
			}
			if(i < m-1){
				i++;
			}
			else{
				j++;
			}
			while(i-1 >= 0 && j+1 < n){
				res.add(matrix[i][j]);
				i--;
				j++;
			}
			res.add(matrix[i][j]);
		}
		return res;
	}
	public static void main(String args[]){
		int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
		List<Integer> res = zigzag(matrix);
		System.out.println(res);
		HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<Integer,HashMap<Integer,Integer>>();
		String s = "fewf";

	}
}
