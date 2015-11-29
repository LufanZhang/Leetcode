package array;
/*
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. 
 */
public class MaximumProductSubarray {
//    public int maxProduct(int[] A) {
//        int length = A.length;
//		if(A==null||length==0)
//			return 0;
//		if(length==1)
//			return A[0];
//		int result = A[0];
//		int min = A[0];
//		int max = A[0];
//		for(int i=1;i<length;i++){
//		    int a = min*A[i];
//		    int b = max*A[i];
//		    min = Math.min(A[i],Math.min(a,b));
//		    max = Math.max(A[i],Math.max(a,b));
//		    if(max>result)
//		    result = max;
//		}
//		return result;
//    }
	 public static int maxProduct(int[] nums) {
	        if(nums == null || nums.length == 0){
	            return 0;
	        }
	        int length = nums.length;
	        int res = Integer.MIN_VALUE;
	        int max = 1;
	        int min = 1;
	        for(int i=0;i<length;i++){
	            int cur = nums[i];
	            int a = cur * max;
	            int b = cur * min;
	            max = Math.max(cur,Math.max(a,b));
	            min = Math.min(cur,Math.min(a,b));
	            System.out.println("a="+a+"    b="+b+"    max="+max+"    min="+min);
	            if(res < max){
	                res = max;
	            }
	        }
	        return res;
	    }
	 public static void main(String[] args){
		 int[] nums = {-4,-3,-2};
		 int res = maxProduct(nums);
		 System.out.println("result = "+res);
	 }
}
