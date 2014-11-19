package array;

import java.util.ArrayList;

public class SpiralMatrix {
	   public ArrayList<Integer> spiralOrder(int[][] matrix) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        int m = matrix.length;
	        if(matrix==null||m==0)
	        return result;
	        int n = matrix[0].length;
	        int left = 0;
	        int up = 0;
	        int right = n-1;
	        int down = m-1;
	        while(left<=right&&up<=down){
	        for(int i=left;i<=right;i++){
	            result.add(matrix[up][i]);
	        }
	        up++;
	        for(int i=up;i<=down;i++){
	            result.add(matrix[i][right]);
	        }
	        right--;
	        if(left>right||up>down)
	        break;
	        for(int i=right;i>=left;i--){
	            result.add(matrix[down][i]);
	        }
	        down--;
	        for(int i=down;i>=up;i--){
	            result.add(matrix[i][left]);
	        }
	        left++;
	        }
	        return result;
	    }
}
