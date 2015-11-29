package array;

import java.util.ArrayList;

/*
 * Given an integer array, adjust each integers so that the difference of every adjcent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]| 
You can assume each number in the array is a positive integer and not greater than 100
Given [1,4,2,3] and target=1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal. Return 2.
 */
public class MinimumAdjustmentCost {
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if(A == null || A.size() <= 1){
            return 0;
        }
        int length = A.size();
        int[][] dp = new int[100][length];
        for(int i=0;i<length;i++){
            for(int j=0;j<100;j++){
                if(i == 0){
                    dp[j][i] = Math.abs(A.get(0) - (j + 1));
                }
                else{
                    int start = Math.max(0,j-target);
                    int end = Math.min(99,j+target);
                    int min = Integer.MAX_VALUE;
                    for(int m=start;m<=end;m++){
                        if(dp[m][i-1] < min){
                            min = dp[m][i-1];
                        }
                    }
                    dp[j][i] = min + Math.abs(A.get(i) - (j + 1));
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i=0;i<=99;i++){
            if(dp[i][length-1] < result){
                result = dp[i][length-1];
            }
        }
        return result;
    }

}
