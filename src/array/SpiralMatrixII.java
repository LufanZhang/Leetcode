package array;
/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,
You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 */
public class SpiralMatrixII {
	   public int[][] generateMatrix(int n) {
	        if(n<0)
	        return null;
	        int[][] result = new int[n][n];
	        int left = 0;
	        int up = 0;
	        int right = n-1;
	        int down = n-1;
	        int count = 1;
	        while(up<=down&&left<=right){
	            for(int i=left;i<=right;i++){
	                result[up][i] = count++;
	            }
	            up++;
	            for(int i=up;i<=down;i++){
	                result[i][right] = count++;
	            }
	            right--;
	            for(int i=right;i>=left;i--){
	                result[down][i] = count++;
	            }
	            down--;
	            for(int i=down;i>=up;i--){
	                result[i][left] = count++;
	            }
	            left++;
	        }
	        return result;
	    }
}
