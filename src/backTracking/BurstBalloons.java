package backTracking;

import java.util.ArrayList;
import java.util.List;

public class BurstBalloons {
	public static int maxCoins(int[] iNums) {
	    int[] nums = new int[iNums.length + 2];
	    int n = 1;
	    for (int x : iNums) if (x > 0) nums[n++] = x;
	    nums[0] = nums[n++] = 1;
	    
	    int[][] dp = new int[n][n];
	    for (int k = 2; k < n; ++k)
	        for (int left = 0; left < n - k; ++left) {
	            int right = left + k;
	            for (int i = left + 1; i < right; ++i){
	                dp[left][right] = Math.max(dp[left][right], 
	                nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
	                if(i==1 && left == 0 && right == 3){
	                	System.out.println("here--------------->"+(nums[left] * nums[i] * nums[right])+" "+dp[left][i]+" "+dp[i][right]);
	                }
	            }
	        }
	    for(int i=0;i<dp.length;i++){
	    	for(int j=0;j<dp[0].length;j++){
	    		System.out.print(dp[i][j]+" ");
	    	}
	    	System.out.println("");
	    }
	    return dp[0][n - 1];
	}
	    public static void main(String args[]){
	    	int[] nums = {3,1,5,8};
	    	int r = maxCoins(nums);
	    	System.out.println(r);
	    }
}
