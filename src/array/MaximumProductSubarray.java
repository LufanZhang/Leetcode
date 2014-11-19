package array;
/*
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. 
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        int length = A.length;
		if(A==null||length==0)
			return 0;
		if(length==1)
			return A[0];
		int result = A[0];
		int min = A[0];
		int max = A[0];
		for(int i=1;i<length;i++){
		    int a = min*A[i];
		    int b = max*A[i];
		    min = Math.min(A[i],Math.min(a,b));
		    max = Math.max(A[i],Math.max(a,b));
		    if(max>result)
		    result = max;
		}
		return result;
    }
}
