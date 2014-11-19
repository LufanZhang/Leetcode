package array;
/*
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 */
public class MaximumSubarray {
	   public int maxSubArray(int[] A) {
	        int result = 0;
	        int max = Integer.MIN_VALUE;
	        int length = A.length;
	        if(A==null||length==0)
	        return max;
	        int i=0;
	        while(i<length){
	            result+=A[i];
	            if(max<result)
	            max = result;
	            if(result<0)
	            result = 0;
	            i++;
	        }
	        return max;
	    }
}
