package backTracking;

public class LongestIncreasingContinuoussubsequenceII {
	   static int res = 0;
	    public static int longestIncreasingContinuousSubsequenceII(int[][] A) {
	        // Write your code here
	        if(A == null || A.length == 0){
	            return 0;
	        }
	        int m = A.length;
	        int n = A[0].length;
	        int[][] result = new int[m][n];
	        for(int i=0;i<m;i++){
	        	for(int j=0;j<n;j++){
	        		helper(A,result,i,j);
	        	}
	        }
	        helper(A,result,0,0);
	        for(int i=0;i<m;i++){
	        	for(int j=0;j<n;j++){
	        		System.out.print(result[i][j]+ " ");
	        	}
	        	System.out.println("");
	        }
	        return res;
	    }
	    public static Integer helper(int[][] A,int[][] result,int i,int j){
	        if(result[i][j] != 0){
	            return result[i][j];
	        }
	        int max = 1;
	        if(i-1 >= 0 && A[i-1][j] > A[i][j]){
	            max = Math.max(max,helper(A,result,i-1,j)+1);
	        }
	        if(i+1 < A.length && A[i+1][j] > A[i][j]){
	            max = Math.max(max,helper(A,result,i+1,j)+1);
	        }
	        if(j-1 >= 0 && A[i][j-1] > A[i][j]){
	            max = Math.max(max,helper(A,result,i,j-1)+1) ;
	        }
	        if(j+1 < A[0].length && A[i][j+1] > A[i][j]){
	            max = Math.max(max,helper(A,result,i,j+1)+1);
	        }
	        if(max > res){
	            res = max;
	        }
	        result[i][j] = max;
	        return max;
	    }
	    public static void main(String args[]){
	    	int[][] A = {{1,2,3,4,5,6},{14,15,16,17,18,8},{12,13,11,10,9,7}};
	    	int r = longestIncreasingContinuousSubsequenceII(A);
	    	System.out.println("res = "+r);
	    }
}
